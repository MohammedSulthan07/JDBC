package com.hibernate.entity;

import com.hibernate.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "owner")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	@Column(name = "mobile_number", nullable = false, unique = true, length = 15)
	private String mobileNumber;

	@Column(name = "email_id", nullable = false, unique = true)
	private String emailId;

	@OneToOne(cascade = CascadeType.ALL,optional = false, orphanRemoval = true)
	@JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = true, unique = true)
	private Pet pet;


}