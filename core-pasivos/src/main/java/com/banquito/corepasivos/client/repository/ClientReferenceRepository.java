package com.banquito.corepasivos.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.ClientReference;

@Repository
public interface ClientReferenceRepository extends JpaRepository<ClientReference, Integer> {
    List<ClientReference> findByIdentificationAndIdentificationtype(String id, String type);
}
