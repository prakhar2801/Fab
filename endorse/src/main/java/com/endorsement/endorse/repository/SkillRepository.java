package com.endorsement.endorse.repository;

import com.endorsement.endorse.model.Skill;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends Neo4jRepository<Skill, Long> {
}
