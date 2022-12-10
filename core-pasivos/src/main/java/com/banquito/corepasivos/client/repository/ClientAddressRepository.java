package com.banquito.corepasivos.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.ClientAddress;
import com.banquito.corepasivos.client.model.ClientAddressPK;

@Repository
public interface ClientAddressRepository extends JpaRepository<ClientAddress, ClientAddressPK> {
    List<ClientAddress> findByPkIdentificationAndPkIdentificationtype(String id, String type);
}
