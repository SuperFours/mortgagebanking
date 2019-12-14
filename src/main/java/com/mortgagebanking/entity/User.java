package com.mortgagebanking.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @description - User Entity - We are maintaining the basic details of the user
 *              like name, dob, age, emailaddress, phonenumber and etc.
 * @author Govindasamy.C
 * @since 14-12-2019
 */
@Getter
@Setter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String emailAddress;
	private String phoneNumber;
	@Column(name = "address_1")
	private String address1;
	@Column(name = "address_2")
	private String address2;
	private Integer pinCode;
	private String panNumber;
	private String userName;
	private String password;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userId")
	private UserAccount userAccount;

}
