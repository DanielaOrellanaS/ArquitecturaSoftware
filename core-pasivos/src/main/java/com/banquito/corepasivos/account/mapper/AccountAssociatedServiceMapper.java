package com.banquito.corepasivos.account.mapper;

import com.banquito.corepasivos.account.dto.response.AccountAssociatedServiceResDto;
import com.banquito.corepasivos.account.model.AccountAssociatedService;

public class AccountAssociatedServiceMapper {

	public static AccountAssociatedServiceResDto mapper(AccountAssociatedService accountAssociatedService) {
		AccountAssociatedServiceResDto serviceDto = new AccountAssociatedServiceResDto();

		serviceDto.setCodeLocalAccount(accountAssociatedService.getPk().getCodelocalaccount());
		serviceDto.setCodeProduct(accountAssociatedService.getPk().getCodeproduct());
		serviceDto.setStatus(accountAssociatedService.getStatus());
		serviceDto.setCodeProductType(accountAssociatedService.getCodeProductType());
		serviceDto.setCodeAssociatedService(accountAssociatedService.getCodeAssociatedService());
		serviceDto.setStartDate(accountAssociatedService.getStartDate());
		serviceDto.setEndDate(accountAssociatedService.getEndDate());

		return serviceDto;
	}
}
