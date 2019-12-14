package com.mortgagebanking.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * @description - User Account - We are maintaining the all user accounts
 *              details such as account type, account number, balance details in
 *              the table.
 * @author Govindasamy.C
 * @Since 14-12-2019
 */
@Setter
@Getter
@Entity
@SequenceGenerator(name = "accountNumber", allocationSize = 1, initialValue = 60005000)
public class UserAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User userId;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountNumber")
	private String accountNumber;
	private String password;
	private String accountType;
	private Double minimumBalance;
	private Double balanceAmount;
	private LocalDateTime createdDate;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userAccountId")
	private UserAccountProperty userAccountProperty;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "fromAccountId")
	private Set<UserTransaction> fromAccountDetail;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "toAccountId")
	private Set<UserTransaction> toAccountDetail;
}
