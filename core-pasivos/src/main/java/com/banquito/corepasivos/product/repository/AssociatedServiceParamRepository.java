package com.banquito.corepasivos.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.product.model.AssociatedServiceParam;
import com.banquito.corepasivos.product.model.AssociatedServiceParamPK;

public interface AssociatedServiceParamRepository
        extends JpaRepository<AssociatedServiceParam, AssociatedServiceParamPK> {
    List<AssociatedServiceParam> findByPkCodeParam(String codeParam);

    List<AssociatedServiceParam> findByPkCodeAssociatedService(String codeAssociatedService);
}
