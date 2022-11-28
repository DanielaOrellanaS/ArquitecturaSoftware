package com.banquito.corepasivos.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.model.ClientReferencePK;

@Repository
public interface ClientReferenceRepository extends JpaRepository<ClientReference, ClientReferencePK> {
    List<ClientReference> findByPkCode(Integer codeReference);

    List<ClientReference> findByPkIdentificationtype(String identificationType);

    List<ClientReference> findByPkIdentification(String identification);
}
