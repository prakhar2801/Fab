package com.endorsement.endorse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endorsement.endorse.model.Endorsement;
import com.endorsement.endorse.repository.EndorsementRepository;

import java.util.List;
@Service
public class EndorsementService {

	@Autowired
    private EndorsementRepository endorsementRepository;

    public List<Endorsement> getAllEndorsements() {
        return endorsementRepository.findAll();
    }

    public Endorsement getEndorsementById(Long id) {
        return endorsementRepository.findById(id).orElse(null);
    }

    public Endorsement createEndorsement(Endorsement endorsement) {
        return endorsementRepository.save(endorsement);
    }

    public void deleteEndorsement(Long id) {
        endorsementRepository.deleteById(id);
    }
    
    public List<Endorsement> getEndorsementsByUserId(Long userId) {
        // Retrieve all endorsements for the user with the given userId
        return endorsementRepository.findByRevieweeId(userId);
    }
    
    public int calculateAdjustedScore(Endorsement endorsement) {
    	int revieweeExp = endorsement.getReviewee().getYearsOfExperience();
    	int reviewerExp = endorsement.getReviewer().getYearsOfExperience();
    	if(revieweeExp > reviewerExp) {
    	    if(endorsement.getSkill().getUsers().contains(endorsement.getReviewee())) {
    	    	return 4;
    	    } else {
    	    	
    	    	return 2;
    	    }
    	} else {
    		if(endorsement.getSkill().getUsers().contains(endorsement.getReviewee())) {
    	    	return 2;
    	    } else {
    	    	return 1;
    	    }
    	}
    }
}
