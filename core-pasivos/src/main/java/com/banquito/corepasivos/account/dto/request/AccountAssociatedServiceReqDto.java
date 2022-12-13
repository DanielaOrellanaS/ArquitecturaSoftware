package com.banquito.corepasivos.account.dto.request;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountAssociatedServiceReqDto implements Serializable {

	private String codeLocalAccount;

	private String codeInternationalAccount;

	private String codeProduct;

	private String codeProductType;

	private String codeAssociatedService;

}
