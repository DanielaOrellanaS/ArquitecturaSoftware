package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountAssociatedService;
import com.banquito.corepasivos.account.model.AccountAssociatedServicePK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAssociatedServiceRepository
		extends JpaRepository<AccountAssociatedService, AccountAssociatedServicePK> {

	List<AccountAssociatedService> findByCodeLocalAccount(String codeLocalAccount);

	List<AccountAssociatedService> findByCodeInternationalAccount(String codeInternationalAccount);

	List<AccountAssociatedService> findByCodeProduct(String codeProduct);

	List<AccountAssociatedService> findByCodeProductType(String codeProductType);

	List<AccountAssociatedService> findByCodeAssociatedService(String codeAssociatedService);

	void deleteByCodeLocalAccount(String codeLocalAccount);

	void deleteByCodeInternationalAccount(String codeInternationalAccount);

	void deleteByCodeAssociatedService(String codeAssociatedService);

}
