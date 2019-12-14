package com.mortgagebanking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @description - We can maintaining the user property values like property
 *              value and property city for mortgage account.
 * @author Govindasamy.C
 * @since 14-12-2019
 *
 */
@Setter
@Getter
@Entity
public class UserAccountProperty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_account_id")
	private UserAccount userAccountId;
	private Double propertyValue;
	private String propertyCity;

}
