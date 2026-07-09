package com.hibernate.dto;

import com.hibernate.enums.Gender;
import lombok.Data;

@Data
public class OwnerDTO {
	private int id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private String city;
	private String state;
	private String mobileNumber;
	private String emailId;
	private PetDTO petDTO;

	@Override
	public String toString() {
		return "OwnerDTO{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", gender=" + gender +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", mobileNumber='" + mobileNumber + '\'' +
				", emailId='" + emailId + '\'' +
				", petDTO=" + petDTO +
				'}';
	}
}