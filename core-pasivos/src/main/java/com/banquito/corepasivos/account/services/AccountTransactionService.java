package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.Account;
import com.banquito.corepasivos.account.model.AccountTransaction;
import com.banquito.corepasivos.account.repository.AccountRepository;
import com.banquito.corepasivos.account.repository.AccountTransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class AccountTransactionService {

    private final AccountTransactionRepository accountTransactionRepository;
	private final AccountRepository accountRepository;

	public AccountTransactionService(AccountTransactionRepository accountTransactionRepository, AccountRepository accountRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
        this.accountRepository =accountRepository;
    }

    public List<AccountTransaction> findAll(){
        return this.accountTransactionRepository.findAll();
    }

//	@Transactional
//    public void saveTransactionDeb(AccountTransaction transaction) {
//        if (transaction.getCodeTransaction() != null) {
//            Optional<AccountTransaction> transactionIdOpt = this.accountTransactionRepository.findById(transaction.getCodeTransaction());
//			if (transactionIdOpt.isPresent()) {
//                throw new RuntimeException("Cant create transactiton, transaction already registered");
//            }
//        }
//        this.accountTransactionRepository.save(transaction);
//    }

	// @Transactional 
    // public void saveTransactionDeb(AccountTransaction transaction) {
        
    //         Optional<AccountTransaction> transactionIdOpt = this.accountTransactionRepository.findByCodeUniqueTransaction(transaction.getCodeUniqueTransaction());
	// 		if (transactionIdOpt.isPresent()) {
    //             throw new RuntimeException("Cant create transactiton, transaction already registered");
    //         }
	// 		this.accountTransactionRepository.save(transaction);
    //     }

	 @Transactional
	 public void saveTransactionDeb(AccountTransaction transaction) {
	 	List<Account> accountList = this.accountRepository.findByPkCodelocalaccount("21d6e4168ac6e7529ca7");
		 if(accountList.size() > 0){
	 		Account accountOpt = accountList.get(0);
			 try{
	 			//BigDecimal valor = BigDecimal.ZERO;
				 BigDecimal valor = BigDecimal.valueOf(20.00);
				 transaction.setCodeLocalAccount("21d6e4168ac6e7529ca7");
				 transaction.setCodeInternationalAccount("d4bf80fcff5933f3b4c82fb1bd09bd8648");
				 transaction.setCodeUniqueTransaction("216eb62cb3046fff2f9434b2c1e672707fcab8d3848840a8ada9bec5221056d0");
				 transaction.setType("DEB");
				 transaction.setRecipientAccountNumber("18005343710");
	 			 transaction.setRecipientType("BEN");
	 			 transaction.setRecipientBank("BANCO PICHINCHA");
	 			 transaction.setReference("85094730");
	 			 transaction.setDescription(null);
	 			 transaction.setValue(valor);
				 transaction.setCreateDate(new Date());
				 transaction.setExecuteDate(null);
				 transaction.setStatus("ACT");
				 //Controlar que cuando la transaccion sea de credito los valores se suman
				 //Actualizar tambien el valor de present balance
				 //update account balance

				 if (accountOpt.getAvailableBalance().compareTo(valor) == 1) {
						accountOpt.setAvailableBalance(new BigDecimal(
										accountOpt.getAvailableBalance().doubleValue() - valor.doubleValue(),
										MathContext.DECIMAL32));
						this.accountRepository.save(accountOpt);

				 } else {
						throw new RuntimeException("You dont have founds");
				 }

				 this.accountTransactionRepository.save(transaction);

	 		}catch(Exception e){

	 		}

	 	}else{
	 		throw new RuntimeException("Account doesnt exits");
	 	}
	 }

	// @Transactional 
    // public void TransactionPayer(AccountTransaction accounttransaction){
    //      Optional <Account> account = this.accountRepository.findByLocalAccount(accounttransaction.getCodeLocalAccount());
    //      if(account.isPresent()){
    //         BigDecimal valor = BigDecimal.ZERO;
    //         accounttransaction.setCreateDate(new Date());
    //         accounttransaction.setType("DEB");
    //         accounttransaction.setRecipientAccountNumber("18005343710");
    //         accounttransaction.setRecipientType("PAY");
    //         accounttransaction.setRecipientBank("BANCO PICHINCHA");
    //         accounttransaction.setReference("85094730");
    //         accounttransaction.setDescription(null);
    //         accounttransaction.setValue(valor);
    //         if(account.get().getAvailableBalance().compareTo(valor) == -1){
    //             account.get().setAvailableBalance(new BigDecimal(account.get().getAvailableBalance().doubleValue()- valor.doubleValue(),MathContext.DECIMAL32));
    //             this.accountRepository.save(account.get());
                

    //         }else{
    //             throw new RuntimeException("no cuenta con fondos");
    //         }
    //         accounttransaction.setExecuteDate(null);
    //         accounttransaction.setStatus("ACT");
    //         this.accountTransactionRepository.save(accounttransaction);
    //      }else{
    //         throw new RuntimeException("cuenta no existe");

    //      }

    // }

    public List<AccountTransaction> findByCodeLocalAccount(String codeLocalAccount) {
		List<AccountTransaction> accountTransaction = this.accountTransactionRepository
				.findByCodeLocalAccount(codeLocalAccount);
		if (accountTransaction.isEmpty()) {
			throw new RuntimeException("Account Transaction by Account not found");
		} else {
			return accountTransaction;
		}
	}


	
	public List<AccountTransaction> findByCodeUniqueTransaction(String codeUniqueTransaction) {
		List<AccountTransaction> accountTransaction = this.accountTransactionRepository
				.findByCodeUniqueTransaction(codeUniqueTransaction);
		if (accountTransaction.isEmpty()) {
			throw new RuntimeException("Account Transaction not found");
		} else {
			return accountTransaction;
		}
	}

	public List<AccountTransaction> findByStatus(String status) {
		List<AccountTransaction> accountTransaction = this.accountTransactionRepository
				.findByStatus(status);
		if (accountTransaction.isEmpty()) {
			throw new RuntimeException("Account not found");
		} else {
			return accountTransaction;
		}
	}


	public List<AccountTransaction> findByRecipientBank(String recipientBank) {
		List<AccountTransaction> accountTransaction = this.accountTransactionRepository
				.findByRecipientBank(recipientBank);
		if (accountTransaction.isEmpty()) {
			throw new RuntimeException("Account Transaction by Recipient Bank not found");
		} else {
			return accountTransaction;
		}
	}

	// public List<AccountTransaction> findByDate(Date start, Date end) {
	// 	List<AccountTransaction> accountTransaction = this.accountTransactionRepository
	// 			.findByDate(start, end);
	// 	if (accountTransaction.isEmpty()) {
	// 		throw new RuntimeException("Account Transaction by Date not found");
	// 	} else {
	// 		return accountTransaction;
	// 	}
	// }
}
