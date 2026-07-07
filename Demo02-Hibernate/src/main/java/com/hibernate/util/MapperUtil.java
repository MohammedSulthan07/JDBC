package com.hibernate.util;


import com.hibernate.dto.OwnerDTO;
import com.hibernate.entity.Owner;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperUtil {

	public static OwnerDTO convertOwnerEntityToDto(Owner owner) {
		OwnerDTO ownerDTO = new OwnerDTO();
//		ownerDTO.setId(owner.getId().toString());
		ownerDTO.setFirstName(owner.getFirstName());
		ownerDTO.setLastName(owner.getLastName());
		ownerDTO.setGender(owner.getGender());
		ownerDTO.setCity(owner.getCity());
		ownerDTO.setState(owner.getState());
		ownerDTO.setMobileNumber(owner.getMobileNumber());
		ownerDTO.setEmailId(owner.getEmailId());
		ownerDTO.setPetId(owner.getPetId());
		ownerDTO.setPetName(owner.getPetName());
		ownerDTO.setPetBirthDate(owner.getPetBirthDate());
		ownerDTO.setPetGender(owner.getPetGender());
		ownerDTO.setPetType(owner.getPetType());
		return ownerDTO;
	}
	
	public static Owner convertOwnerDtoToEntity(OwnerDTO ownerDTO) {
		Owner owner = new Owner();
//		owner.setId(UUID.fromString(ownerDTO.getId()));
		owner.setFirstName(ownerDTO.getFirstName());
		owner.setLastName(ownerDTO.getLastName());
		owner.setGender(ownerDTO.getGender());
		owner.setCity(ownerDTO.getCity());
		owner.setState(ownerDTO.getState());
		owner.setMobileNumber(ownerDTO.getMobileNumber());
		owner.setEmailId(ownerDTO.getEmailId());
		owner.setPetId(ownerDTO.getPetId());
		owner.setPetName(ownerDTO.getPetName());
		owner.setPetBirthDate(ownerDTO.getPetBirthDate());
		owner.setPetGender(ownerDTO.getPetGender());
		owner.setPetType(ownerDTO.getPetType());
		return owner;
	}



}
