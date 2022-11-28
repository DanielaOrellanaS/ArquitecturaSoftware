package com.banquito.corepasivos.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.AssociatedServiceParam;
import com.banquito.corepasivos.product.repository.AssociatedServiceParamRepository;

@Service
public class AssociatedServiceParamServiceImpl implements AssociatedServiceParamService {

    @Autowired
    AssociatedServiceParamRepository associatedServiceParamRepository;

    @Override
    public List<AssociatedServiceParam> getAllAssociatedServiceParam() {
        return this.associatedServiceParamRepository.findAll();
    }

}
