package com.banquito.corepasivos.account.mapper;

import com.banquito.corepasivos.account.dto.response.AccountTransactionRecipientBankResDto;
import com.banquito.corepasivos.account.dto.response.AccountTransactionResDto;
import com.banquito.corepasivos.account.dto.response.AccountTransactionStatusResDto;
import com.banquito.corepasivos.account.dto.response.AccountTransactionUniqueResDto;
import com.banquito.corepasivos.account.model.AccountTransaction;




public class AccountTransactionMapper {

	public static AccountTransactionResDto mapper(AccountTransaction accountTransacction) {
		AccountTransactionResDto transactionDto = new AccountTransactionResDto();

		transactionDto.setCodeUniqueTransaction(accountTransacction.getCodeUniqueTransaction());
		transactionDto.setType(accountTransacction.getType());
		transactionDto.setRecipientAccountNumber(accountTransacction.getRecipientAccountNumber());
		transactionDto.setRecipientType(accountTransacction.getRecipientType());
		transactionDto.setRecipientBank(accountTransacction.getRecipientBank());
		transactionDto.setReference(accountTransacction.getReference());
		transactionDto.setDescription(accountTransacction.getDescription());
		transactionDto.setValue(accountTransacction.getValue());
		transactionDto.setCreateDate(accountTransacction.getCreateDate());
		transactionDto.setExecuteDate(accountTransacction.getExecuteDate());
		transactionDto.setStatus(accountTransacction.getStatus());
		

		return transactionDto;
	}

	public static AccountTransactionUniqueResDto mapperUniqueCode(AccountTransaction accountTransacction) {
		AccountTransactionUniqueResDto transactionDto = new AccountTransactionUniqueResDto();

		transactionDto.setCodeLocalAccount(accountTransacction.getCodeLocalAccount());
		transactionDto.setCodeInternationalAccount(accountTransacction.getCodeInternationalAccount());
		transactionDto.setType(accountTransacction.getType());
		transactionDto.setRecipientAccountNumber(accountTransacction.getRecipientAccountNumber());
		transactionDto.setRecipientType(accountTransacction.getRecipientType());
		transactionDto.setRecipientBank(accountTransacction.getRecipientBank());
		transactionDto.setReference(accountTransacction.getReference());
		transactionDto.setDescription(accountTransacction.getDescription());
		transactionDto.setValue(accountTransacction.getValue());
		transactionDto.setCreateDate(accountTransacction.getCreateDate());
		transactionDto.setExecuteDate(accountTransacction.getExecuteDate());
		transactionDto.setStatus(accountTransacction.getStatus());
		

		return transactionDto;
	}

	public static AccountTransactionRecipientBankResDto mapperRecipientBanl(AccountTransaction accountTransacction) {
		AccountTransactionRecipientBankResDto transactionDto = new AccountTransactionRecipientBankResDto();

		transactionDto.setType(accountTransacction.getType());
		transactionDto.setRecipientAccountNumber(accountTransacction.getRecipientAccountNumber());
		transactionDto.setRecipientType(accountTransacction.getRecipientType());
		
		transactionDto.setReference(accountTransacction.getReference());
		transactionDto.setDescription(accountTransacction.getDescription());
		transactionDto.setValue(accountTransacction.getValue());
		transactionDto.setCreateDate(accountTransacction.getCreateDate());
		transactionDto.setExecuteDate(accountTransacction.getExecuteDate());
		transactionDto.setStatus(accountTransacction.getStatus());
		

		return transactionDto;
	}

	public static AccountTransactionStatusResDto mapperStatus(AccountTransaction accountTransacction) {
		AccountTransactionStatusResDto transactionDto = new AccountTransactionStatusResDto();

		transactionDto.setCodeUniqueTransaction(accountTransacction.getCodeUniqueTransaction());

		transactionDto.setType(accountTransacction.getType());
		transactionDto.setRecipientAccountNumber(accountTransacction.getRecipientAccountNumber());
		transactionDto.setRecipientType(accountTransacction.getRecipientType());
		transactionDto.setRecipientBank(accountTransacction.getRecipientBank());
		transactionDto.setReference(accountTransacction.getReference());
		transactionDto.setDescription(accountTransacction.getDescription());
		transactionDto.setValue(accountTransacction.getValue());
		transactionDto.setCreateDate(accountTransacction.getCreateDate());
		transactionDto.setExecuteDate(accountTransacction.getExecuteDate());
		
		

		return transactionDto;
	}


	


}
