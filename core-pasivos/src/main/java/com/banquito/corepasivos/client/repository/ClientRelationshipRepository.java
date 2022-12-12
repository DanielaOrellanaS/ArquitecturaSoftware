package com.banquito.corepasivos.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.ClientRelationship;

@Repository
public interface ClientRelationshipRepository extends JpaRepository<ClientRelationship, Integer> {

    List<ClientRelationship> findByIdentificationAndIdentificationtype(String id, String type);

    List<ClientRelationship> deleteByIdentificationAndIdentificationtype(String id, String type);

}
