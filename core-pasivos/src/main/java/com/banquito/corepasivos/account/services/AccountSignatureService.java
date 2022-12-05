package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.repository.AccountRepository;
import com.banquito.corepasivos.account.repository.AccountSignatureRepository;
import com.banquito.corepasivos.client.repository.ClientRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class AccountSignatureService {
    private final AccountSignatureRepository accountSignatureRepository;
<<<<<<< HEAD
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountSignatureService(AccountSignatureRepository accountSignatureRepository,
            AccountRepository accountRepository,
            ClientRepository clientRepository) {
        this.accountSignatureRepository = accountSignatureRepository;
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
=======

    public AccountSignatureService(AccountSignatureRepository accountSignatureRepository) {
        this.accountSignatureRepository = accountSignatureRepository;
>>>>>>> 650967939f0ed2292caaaba6748129d2078e5047
    }

    public List<AccountSignature> findAll() {
        return this.accountSignatureRepository.findAll();
    }

    public List<AccountSignature> findByCodeAccount(String code) {
        List<AccountSignature> accountSignatures = this.accountSignatureRepository.findByPkCodelocalaccount(code);
        if (!accountSignatures.isEmpty()) {
            return accountSignatures;
        } else {
            return null;
        }
    }
<<<<<<< HEAD

    public void register(AccountSignature accountSignature) {
        // aqui se debe validar que los atributos de identificacion y numero de cuenta
        // existan en la clase cliente y cuenta, por lo que se necesita una funcion find
        // en el repositorio de cada una de estas clases
        boolean existClient = this.clientRepository.existsById(accountSignature.getClient().getPk());
        boolean existeAccount = this.accountRepository.existsById(accountSignature.getAccount().getPk());
        List<AccountSignature> accountSignatures = this.accountSignatureRepository
                .findBySignaturereference(accountSignature.getSignatureReference());
        if (existClient && existeAccount && accountSignatures.isEmpty()) {
            this.accountSignatureRepository.save(accountSignature);
        } else{
            throw new RuntimeException("Los datos ingresados son incorrectos");
        }
    }

    @Transactional
    public void delete (String code){
        List<AccountSignature> accountSignatures = this.accountSignatureRepository.findByPkCodelocalaccount(code);
        if (!accountSignatures.isEmpty()) {
            accountSignatures.get(0).setStatus("INA");
            this.accountSignatureRepository.save(accountSignatures.get(0));
        } else {
            throw new RuntimeException("El codigo ingresado no pertenece a ninguna cuenta");
        }
    }
=======
>>>>>>> 650967939f0ed2292caaaba6748129d2078e5047
}
