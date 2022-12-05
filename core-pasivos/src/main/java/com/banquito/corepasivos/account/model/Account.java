package com.banquito.corepasivos.account.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

import com.banquito.corepasivos.general.model.Branch;
import com.banquito.corepasivos.product.model.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account implements Serializable {

	@EmbeddedId
	@Include
	private AccountPK pk;

	@Column(name = "code_product", length = 32, nullable = false)
	private String codeProduct;

	@Column(name = "code_product_type", length = 32, nullable = false)
	private String codeProductType;

	@Column(name = "code_branch", length = 3, nullable = false)
	private String codeBranch;

	@Column(name = "entity_bank_code", length = 16, nullable = false)
	private String entityBankCode;

	@Column(name = "international_bank_code", length = 16, nullable = false)
	private String internationalBankCode;

	@Column(name = "status", length = 3, nullable = false)
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_date", nullable = false)
	private Date lastUpdateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "close_date", nullable = true)
	private Date closeDate;

	@Column(name = "present_balance", scale = 17, precision = 2, nullable = false)
	private BigDecimal presentBalance;

	@Column(name = "available_balance", scale = 17, precision = 2, nullable = false)
	private BigDecimal availableBalance;

	@JsonBackReference(value = "product-account")
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "code_product", referencedColumnName = "code_product", insertable = false, updatable = false),
			@JoinColumn(name = "code_product_type", referencedColumnName = "code_product_type", insertable = false, updatable = false),
	})
	private Product product;

	@JsonBackReference(value = "branch-account")
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "code_branch", referencedColumnName = "code_branch", insertable = false, updatable = false),
			@JoinColumn(name = "entity_bank_code", referencedColumnName = "entity_bank_code", insertable = false, updatable = false),
			@JoinColumn(name = "international_bank_code", referencedColumnName = "international_bank_code", insertable = false, updatable = false)
	})
	private Branch branch;

	@JsonManagedReference(value = "account-accountSignature")
	@OneToMany(mappedBy = "account")
	private List<AccountSignature> accountSignatures;

	@JsonManagedReference(value = "account-accountTransaction")
	@OneToMany(mappedBy = "account")
	private List<AccountTransaction> accountTransactions;

	@JsonManagedReference(value = "account-accountAssociatedService")
	@OneToMany(mappedBy = "account")
	private List<AccountAssociatedService> accountAssociatedServices;

	@JsonManagedReference(value = "account-accountClient")
	@OneToMany(mappedBy = "account")
	private List<AccountClient> accountsClient;

	public Account(AccountPK accountPK) {
		this.pk = accountPK;
	}
}
