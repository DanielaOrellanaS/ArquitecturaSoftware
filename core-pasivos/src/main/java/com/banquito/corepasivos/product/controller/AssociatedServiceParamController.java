package com.banquito.corepasivos.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banquito.corepasivos.product.service.AssociatedServiceParamService;

@RestController
@RequestMapping("/associatedserviceparam")
public class AssociatedServiceParamController {
    @Autowired
    AssociatedServiceParamService associatedServiceParamService;

    @GetMapping("/all")
    public Object findAssociatedServiceParam() {
        return this.associatedServiceParamService.findAllAssociatedServiceParam();
    }
}
