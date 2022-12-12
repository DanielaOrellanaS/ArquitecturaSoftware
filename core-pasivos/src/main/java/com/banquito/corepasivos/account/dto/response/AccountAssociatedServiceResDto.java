package com.banquito.corepasivos.account.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class AccountAssociatedServiceResDto implements Serializable {

	private String codeLocalAccount;

	private String codeProduct;

	private String status;

	private String codeProductType;

	private String codeAssociatedService;

	private Date startDate;

	private Date endDate;

}
