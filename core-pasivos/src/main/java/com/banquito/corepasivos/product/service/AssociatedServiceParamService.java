package com.banquito.corepasivos.product.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.AssociatedServiceParam;
import com.banquito.corepasivos.product.model.AssociatedServiceParamPK;
import com.banquito.corepasivos.product.repository.AssociatedServiceParamRepository;

@Service
public class AssociatedServiceParamService {
    private final AssociatedServiceParamRepository associatedServiceParamRepository;

    public AssociatedServiceParamService(AssociatedServiceParamRepository associatedServiceParamRepository) {
        this.associatedServiceParamRepository = associatedServiceParamRepository;
    }

    public List<AssociatedServiceParam> findAllAssociatedServiceParams() {
        return associatedServiceParamRepository.findAll();
    }

    public List<AssociatedServiceParam> findAllAssociatedServiceParamsByCodeParam(String codeParam) {
        return associatedServiceParamRepository.findByPkCodeParam(codeParam);
    }

    public List<AssociatedServiceParam> findAllAssociatedServiceParamsByCodeAssociatedService(
            String codeAssociatedService) {
        return associatedServiceParamRepository.findByPkCodeAssociatedService(codeAssociatedService);
    }

    public List<AssociatedServiceParam> findByNameContaining(String name) {
        return this.associatedServiceParamRepository.findByNameContaining(name);
    }

    @Transactional
    public void createAssociatedServiceParam(AssociatedServiceParam associatedServiceParam) {
        try {
            this.associatedServiceParamRepository.save(associatedServiceParam);
        } catch (Exception e) {
            throw new RuntimeException("There is already a service associated with these parameters");
        }
    }

    @Transactional
    public void updateAssociatedServiceParam(AssociatedServiceParam associatedServiceParam) {
        Optional<AssociatedServiceParam> auxParam = this.associatedServiceParamRepository
                .findById(associatedServiceParam.getPk());
        if (!auxParam.isPresent())
            throw new RuntimeException("The parameter associated with the service has not been found");
        else
            try {
                this.associatedServiceParamRepository.save(associatedServiceParam);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the data update");
            }
    }

    @Transactional
    public void deleteAssociatedServiceParam(AssociatedServiceParam associatedServiceParam) {
        Optional<AssociatedServiceParam> auxParam = this.associatedServiceParamRepository
                .findById(associatedServiceParam.getPk());
        if (!auxParam.isPresent())
            throw new RuntimeException("Associated service parameters not found");
        else
            try {
                this.associatedServiceParamRepository.delete(associatedServiceParam);
            } catch (Exception e) {
                throw new RuntimeException(
                        "An error occurred while removing the associated service parameters");
            }
    }

    @Transactional
    public void deleteAssociatedServiceParam(AssociatedServiceParamPK pk) {
        Optional<AssociatedServiceParam> auxParam = this.associatedServiceParamRepository.findById(pk);
        if (!auxParam.isPresent())
            throw new RuntimeException("The parameters of the associated service have not been found");
        else
            try {
                this.associatedServiceParamRepository.deleteById(pk);
            } catch (Exception e) {
                throw new RuntimeException(
                        "An error has occurred in the deletion of the associated service parameters");
            }
    }

}
