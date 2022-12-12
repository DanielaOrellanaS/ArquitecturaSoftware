package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.model.AccountAssociatedServicePK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAssociatedServiceRepository
		extends JpaRepository<AccountAssociatedService, AccountAssociatedServicePK> {

	List<AccountAssociatedService> findAllByCodeLocalAccountAndCodeInternationalAccount(String codeLocalAccount,
			String codeInternationalAccount);

	AccountAssociatedService findByCodeLocalAccountAndCodeInternationalAccount(String codeLocalAccount,
			String codeInternationalAccount);

	List<AccountAssociatedService> findAllByCodeLocalAccountAndCodeInternationalAccountAndStatus(
			String codeLocalAccount,
			String codeInternationalAccount, String status);

	AccountAssociatedService findByCodeLocalAccountAndCodeInternationalAccountAndCodeAssociatedService(
			String codeLocalAccount, String codeInternationalAccount, String codeAssociatedService);

}
