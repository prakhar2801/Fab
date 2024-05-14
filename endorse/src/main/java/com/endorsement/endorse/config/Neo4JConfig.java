package com.endorsement.endorse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.AbstractNeo4jConfig;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.neo4j.driver.Driver;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.endorsement.endorse")
public class Neo4JConfig extends AbstractNeo4jConfig {

    @Override
    public Driver driver() {
        return GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("username", "password"));
    }
}
