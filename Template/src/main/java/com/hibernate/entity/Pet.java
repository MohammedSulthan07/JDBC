package com.hibernate.entity;

import java.time.LocalDate;

import com.hibernate.enums.Gender;
import com.hibernate.enums.PetType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "pet_name", nullable = false)
	private String name;

	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PetType type;

	@OneToOne(mappedBy = "pet")
	private Owner owner;


}