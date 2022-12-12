package com.banquito.corepasivos.account.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class AccountTransactionResDto implements Serializable {

	

	private String codeUniqueTransaction;
	private String type;
	private String recipientAccountNumber;
	private String recipientType;
	private String recipientBank;
	private String reference;
	private String description;
	private BigDecimal value;
	private Date createDate;
	private Date executeDate;
	private String status;

	

}

