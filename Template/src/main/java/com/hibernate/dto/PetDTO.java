package com.hibernate.dto;

import java.time.LocalDate;

import com.hibernate.enums.Gender;
import com.hibernate.enums.PetType;
import lombok.Data;

@Data
public class PetDTO {
	private int id;
	private String name;
	private LocalDate birthDate;
	private Gender gender;
	private PetType type;
	private OwnerDTO ownerDTO;

	@Override
	public String toString() {
		return "PetDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", birthDate=" + birthDate +
				", gender=" + gender +
				", type=" + type +
				", ownerDTO=" + ownerDTO +
				'}';
	}
}