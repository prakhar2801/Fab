package com.endorsement.endorse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.endorsement.endorse.model.Endorsement;
import com.endorsement.endorse.service.EndorsementService;

@RestController
public class EndorsementController {

	@Autowired
    private EndorsementService endorsementService;

    @GetMapping("/endorsements/{userId}")
    public Map<String, List<Endorsement>> getEndorsements(@PathVariable Long userId) {
        Map<String, List<Endorsement>> endorsementsBySkill = new HashMap<>();

        // Retrieve all endorsements for the user with the given userId
        List<Endorsement> endorsements = endorsementService.getEndorsementsByUserId(userId);

        // Group endorsements by skill
        for (Endorsement endorsement : endorsements) {
            String skillName = endorsement.getSkill().getName();
            List<Endorsement> skillEndorsements = endorsementsBySkill.getOrDefault(skillName, new ArrayList<>());
            skillEndorsements.add(endorsement);
            endorsementsBySkill.put(skillName, skillEndorsements);
        }

        return endorsementsBySkill;
    }
    
    @PostMapping("/endorsement")
    public Endorsement postEndorsement(@RequestBody Endorsement endorsement) {
        // Calculate adjusted score based on factors like coworker status, years of experience, expertise, etc.
        int adjustedScore = endorsementService.calculateAdjustedScore(endorsement);

        // Set the adjusted score in the endorsement object
        endorsement.setScore(adjustedScore);

        // Save the endorsement in the database
        return endorsementService.createEndorsement(endorsement);
    }
}
