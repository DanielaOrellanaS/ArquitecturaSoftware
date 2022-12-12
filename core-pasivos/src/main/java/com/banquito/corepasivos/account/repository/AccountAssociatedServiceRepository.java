package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.model.AccountAssociatedServicePK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAssociatedServiceRepository
		extends JpaRepository<AccountAssociatedService, AccountAssociatedServicePK> {

	List<AccountAssociatedService> findAllByCodeLocalAccount(String codeLocalAccount);

	List<AccountAssociatedService> findAllByCodeInternationalAccount(String codeInternationalAccount);

	List<AccountAssociatedService> findAllByCodeProduct(String codeProduct);

	List<AccountAssociatedService> findAllByCodeProductType(String codeProductType);

	List<AccountAssociatedService> findAllByCodeAssociatedService(String codeAssociatedService);

	AccountAssociatedService findByCodeAssociatedServiceAndCodeLocalAccount(String codeAssociatedService,
			String codeLocalAccount);

	List<AccountAssociatedService> findAllByCodeLocalAccountAndCodeInternationalAccount(String codeLocalAccount,
			String codeInternationalAccount);
}
