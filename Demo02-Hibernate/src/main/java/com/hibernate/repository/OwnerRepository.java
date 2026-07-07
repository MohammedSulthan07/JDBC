package com.hibernate.repository;

import com.hibernate.entity.Owner;

import java.util.UUID;

public interface OwnerRepository {
	
	void saveOwner(Owner owner);

	Owner findOwner(UUID ownerId);

	void updatePetDetails(UUID ownerId, String petName);

	void deleteOwner(UUID ownerId);

}
