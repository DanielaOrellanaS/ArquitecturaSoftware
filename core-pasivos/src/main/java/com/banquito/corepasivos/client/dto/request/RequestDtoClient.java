package com.banquito.corepasivos.client.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.banquito.corepasivos.client.model.ClientAddress;
import com.banquito.corepasivos.client.model.ClientPhone;
import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.model.ClientRelationship;
import com.banquito.corepasivos.client.model.Segment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDtoClient implements Serializable {
    private String identification;
    private String identificationType;
    private String codeSegment;
    private String clientType;
    private String lastname;
    private String name;
    private String fullname;
    private String email;
    private Date birthDate;
    private String gender;
    private String companyName;
    private String companyType;
    private String status;
    private Date createDate;
    private Date lastStatusDate;
    private String signature;
    private String workStatus;
    private String taxPaymentPlace;
    private String fingerprint;
    private String nationality;
    private String maritalStatus;
    private String monthlyAvgIncome;
    private String basicServicesDocument;
    private String incomeTaxDocument;
    private String articlesAssociationDoc;
    private String tinDocument;
    private String appLegalRepresentDoc;
    private String career;

    private Segment segment;
    private List<ClientRelationship> clientRelationships;
    private List<ClientAddress> clientAddresses;
    private List<ClientReference> clientReferences;
    private List<ClientPhone> clientPhones;
}
