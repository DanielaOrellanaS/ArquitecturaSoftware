package com.banquito.corepasivos.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.ClientRelationship;

@Repository
public interface ClientRelationshipRepository extends JpaRepository<ClientRelationship, Integer> {

    List<ClientRelationship> findByCodeRelationship(Integer codeRelationship);

    List<ClientRelationship> findByIdentification(String identification);

    List<ClientRelationship> findByRelationshipType(String relationshipType);

    List<ClientRelationship> findAll();

}
