package com.banquito.corepasivos.account.mapper;

import com.banquito.corepasivos.account.dto.response.AccountAssociatedServiceParamResDto;
import com.banquito.corepasivos.account.model.AccountAssociatedServiceParam;

public class AccountAssociatedServiceParamMapper {

	public static AccountAssociatedServiceParamResDto mapper(
			AccountAssociatedServiceParam accountAssociatedServiceParam) {
		AccountAssociatedServiceParamResDto serviceDto = new AccountAssociatedServiceParamResDto();

		serviceDto.setCodeParam(accountAssociatedServiceParam.getPk().getCodeparam());
		serviceDto.setStatus(accountAssociatedServiceParam.getStatus());
		serviceDto.setTextValue(accountAssociatedServiceParam.getTextValue());
		serviceDto.setDateValue(accountAssociatedServiceParam.getDateValue());
		serviceDto.setNumberValue(accountAssociatedServiceParam.getNumberValue());

		return serviceDto;
	}
}
