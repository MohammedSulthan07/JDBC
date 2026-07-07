package com.hibernate.service;


import com.hibernate.dto.OwnerDTO;
import com.hibernate.exception.DuplicateOwnerException;
import com.hibernate.exception.OwnerNotFoundException;

public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException;

	OwnerDTO findOwner(String ownerId) throws OwnerNotFoundException;

	void updatePetDetails(String ownerId, String petName) throws OwnerNotFoundException;

	void deleteOwner(String ownerId) throws OwnerNotFoundException;

}
