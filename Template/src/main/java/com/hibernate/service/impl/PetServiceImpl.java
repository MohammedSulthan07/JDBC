package com.hibernate.service.impl;

import com.hibernate.dto.PetDTO;

import com.hibernate.entity.Pet;
import com.hibernate.exception.PetNotFoundException;

import com.hibernate.repository.PetRepository;
import com.hibernate.repository.impl.PetRepositoryImpl;
import com.hibernate.service.PetService;
import com.hibernate.util.MapperUtil;

import java.util.Objects;


public class PetServiceImpl implements PetService{
	private static PetRepository petRepository;
	public PetServiceImpl(){
		this.petRepository=new PetRepositoryImpl();
	}

	@Override
	public PetDTO findPet(int petId) throws PetNotFoundException {
		Pet pet=petRepository.findPet(petId);
		if(Objects.isNull(pet)){
			throw new PetNotFoundException("Pet not found");
		}

		return MapperUtil.convertPetEntityToDto(pet);
	}
}