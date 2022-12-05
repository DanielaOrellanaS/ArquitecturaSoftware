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

    @Transactional
    public void createAssociatedServiceParam(AssociatedServiceParam associatedServiceParam) {
        try {
            this.associatedServiceParamRepository.save(associatedServiceParam);
        } catch (Exception e) {
            throw new RuntimeException("Ya existe un servicio asociado con estos parámetros");
        }
    }

    @Transactional
    public void updateAssociatedServiceParam(AssociatedServiceParam associatedServiceParam) {
        Optional<AssociatedServiceParam> auxAddress = this.associatedServiceParamRepository
                .findById(associatedServiceParam.getPk());
        if (!auxAddress.isPresent())
            throw new RuntimeException("No se ha encontrado la direcciona asociada al usuario");
        else
            try {
                this.associatedServiceParamRepository.save(associatedServiceParam);
            } catch (Exception e) {
                throw new RuntimeException("Ha ocurrido un error en la actualizacion de datos");
            }
    }

    @Transactional
    public void deleteAssociatedServiceParam(AssociatedServiceParam associatedServiceParam) {
        Optional<AssociatedServiceParam> auxAddress = this.associatedServiceParamRepository
                .findById(associatedServiceParam.getPk());
        if (!auxAddress.isPresent())
            throw new RuntimeException("No se han encontrado los parámetros del servicio asociado");
        else
            try {
                this.associatedServiceParamRepository.delete(associatedServiceParam);
            } catch (Exception e) {
                throw new RuntimeException(
                        "Ha ocurrido un error en la eliminacion de los parametros del servicio asociado");
            }
    }

    @Transactional
    public void deleteAssociatedServiceParam(AssociatedServiceParamPK pk) {
        Optional<AssociatedServiceParam> auxAddress = this.associatedServiceParamRepository.findById(pk);
        if (!auxAddress.isPresent())
            throw new RuntimeException("No se han encontrado los parametros del servicio asociado");
        else
            try {
                this.associatedServiceParamRepository.deleteById(pk);
            } catch (Exception e) {
                throw new RuntimeException(
                        "Ha ocurrido un error en la eliminacion de los parámetros del servicio asociado");
            }
    }

}
