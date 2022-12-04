package com.banquito.corepasivos.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.account.service.AccountClientService;

@RestController
@RequestMapping("/accountclient")
public class AccountClientController {
    
    @Autowired
    AccountClientService accountClientService;

    @RequestMapping("/all")
	public Object findAllAccountClient() {
		return this.accountClientService.findAllAccountClient();
	}
}
