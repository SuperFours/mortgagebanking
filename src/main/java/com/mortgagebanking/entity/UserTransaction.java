package com.mortgagebanking.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @description - get the all user account transaction for fund transafer and
 *              user can paid the amount for their mortgage loan amount by
 *              duration wise.
 * @author Govindasamy.C
 * @since 14-12-2019
 */
@Setter
@Getter
@Entity
public class UserTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "from_account_id")
	private UserAccount fromAccountId;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "to_account_id")
	private UserAccount toAccountId;
	private String transactionType;
	private String transactionId;
	private LocalDate transactionDate;
	private Double transactionAmount;
	private String remarks;
}
