package com.banquito.corepasivos.account.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class AccountAssociatedServiceParamResDto implements Serializable {

	private String codeParam;

	private String status;

	private String textValue;

	private Date dateValue;

	private BigDecimal numberValue;

}
