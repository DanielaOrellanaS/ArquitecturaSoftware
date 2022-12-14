package com.banquito.corepasivos.client.mapper;

import com.banquito.corepasivos.client.dto.request.RequestDtoClient;
import com.banquito.corepasivos.client.dto.response.ResponseDtoClient;
import com.banquito.corepasivos.client.model.Client;
import com.banquito.corepasivos.client.model.ClientPK;

public class ClientMapper {

    public static Client map(RequestDtoClient data) {
        Client client = new Client();
        ClientPK pk = new ClientPK();
        pk.setIdentification(data.getIdentification());
        pk.setIdentificationType(data.getIdentificationType());
        client.setPk(pk);
        client.setAppLegalRepresentDoc(data.getAppLegalRepresentDoc());
        client.setArticlesAssociationDoc(data.getArticlesAssociationDoc());
        client.setBasicServicesDocument(data.getBasicServicesDocument());
        client.setBirthDate(data.getBirthDate());
        client.setCareer(data.getCareer());
        client.setClientType(data.getClientType());
        client.setCodeSegment(data.getCodeSegment());
        client.setCompanyName(data.getCompanyName());
        client.setCompanyType(data.getCompanyType());
        client.setEmail(data.getEmail());
        client.setFingerprint(data.getFingerprint());
        client.setFullname(data.getFullname());
        client.setGender(data.getGender());
        client.setIncomeTaxDocument(data.getIncomeTaxDocument());
        client.setLastname(data.getLastname());
        client.setMaritalStatus(data.getMaritalStatus());
        client.setMonthlyAvgIncome(data.getMonthlyAvgIncome());
        client.setName(data.getName());
        client.setNationality(data.getNationality());
        client.setSignature(data.getSignature());
        client.setStatus(data.getStatus());
        client.setTaxPaymentPlace(data.getTaxPaymentPlace());
        client.setTinDocument(data.getTinDocument());
        client.setWorkStatus(data.getWorkStatus());
        client.setBirthDate(data.getBirthDate());
        client.setCreateDate(data.getCreateDate());
        client.setLastStatusDate(data.getLastStatusDate());
        return client;
    }

    public static ResponseDtoClient map(Client data) {
        ResponseDtoClient dto = new ResponseDtoClient();
        dto.setIdentification(data.getPk().getIdentification());
        dto.setIdentificationType(data.getPk().getIdentificationType());
        dto.setAppLegalRepresentDoc(data.getAppLegalRepresentDoc());
        dto.setArticlesAssociationDoc(data.getArticlesAssociationDoc());
        dto.setBasicServicesDocument(data.getBasicServicesDocument());
        dto.setBirthDate(data.getBirthDate());
        dto.setCareer(data.getCareer());
        dto.setClientType(data.getClientType());
        dto.setCodeSegment(data.getCodeSegment());
        dto.setCompanyName(data.getCompanyName());
        dto.setCompanyType(data.getCompanyType());
        dto.setEmail(data.getEmail());
        dto.setFingerprint(data.getFingerprint());
        dto.setFullname(data.getFullname());
        dto.setGender(data.getGender());
        dto.setIncomeTaxDocument(data.getIncomeTaxDocument());
        dto.setLastname(data.getLastname());
        dto.setMaritalStatus(data.getMaritalStatus());
        dto.setMonthlyAvgIncome(data.getMonthlyAvgIncome());
        dto.setName(data.getName());
        dto.setNationality(data.getNationality());
        dto.setSignature(data.getSignature());
        dto.setStatus(data.getStatus());
        dto.setTaxPaymentPlace(data.getTaxPaymentPlace());
        dto.setTinDocument(data.getTinDocument());
        dto.setWorkStatus(data.getWorkStatus());
        dto.setBirthDate(data.getBirthDate());
        dto.setCreateDate(data.getCreateDate());
        dto.setLastStatusDate(data.getLastStatusDate());

        dto.setSegment(data.getSegment());
        dto.setClientRelationships(data.getClientRelationships());
        dto.setClientAddresses(data.getClientAddresses());
        dto.setClientReferences(data.getClientReferences());
        dto.setClientPhones(data.getClientPhones());

        return dto;
    }

}
