package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountAssociatedServiceParam;
import com.banquito.corepasivos.account.model.AccountAssociatedServiceParamPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAssociatedServiceParamRepository extends
		JpaRepository<AccountAssociatedServiceParam, AccountAssociatedServiceParamPK> {

	List<AccountAssociatedServiceParam> findByCodeLocalAccount(String codeLocalAccount);

	List<AccountAssociatedServiceParam> findByCodeInternationalAccount(String codeInternationalAccount);

	List<AccountAssociatedServiceParam> findByCodeParam(String codeParam);

}
