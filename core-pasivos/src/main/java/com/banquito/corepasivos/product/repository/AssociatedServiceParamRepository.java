package com.banquito.corepasivos.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.product.model.AssociatedServiceParam;
import com.banquito.corepasivos.product.model.AssociatedServiceParamPK;

@Repository
public interface AssociatedServiceParamRepository
        extends JpaRepository<AssociatedServiceParam, AssociatedServiceParamPK> {

}
