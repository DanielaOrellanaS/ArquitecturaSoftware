package com.banquito.corepasivos.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.product.model.AssociatedServiceParam;
import com.banquito.corepasivos.product.model.AssociatedServiceParamPK;

public interface AssociatedServiceParamRepository
        extends JpaRepository<AssociatedServiceParam, AssociatedServiceParamPK> {

}
