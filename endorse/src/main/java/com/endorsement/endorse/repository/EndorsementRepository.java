package com.endorsement.endorse.repository;

import com.endorsement.endorse.model.Endorsement;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EndorsementRepository extends Neo4jRepository<Endorsement, Long> {
	@Query("MATCH (r:User)-[e:ENDORSED]->(u:User) WHERE ID(u) = $userId RETURN e")
    List<Endorsement> findByRevieweeId(Long userId);
}