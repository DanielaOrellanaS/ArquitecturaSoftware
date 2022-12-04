package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.service.AccountClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/accountclient")
public class AccountClientController {
    
    private final AccountClientService accountClientService;

    public AccountClientController( AccountClientService accountClientService){
        this.accountClientService = accountClientService;
    }

    @RequestMapping("/all")
	public Object findAllAccountClient() {
		return this.accountClientService.findAllAccountClient();
	}
}
