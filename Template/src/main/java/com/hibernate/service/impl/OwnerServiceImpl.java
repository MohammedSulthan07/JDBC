package com.hibernate.service.impl;

import com.hibernate.dto.OwnerDTO;
import com.hibernate.entity.Owner;
import com.hibernate.exception.OwnerNotFoundException;
import com.hibernate.repository.OwnerRepository;
import com.hibernate.repository.impl.OwnerRepositoryImpl;
import com.hibernate.service.OwnerService;
import com.hibernate.util.MapperUtil;

public class OwnerServiceImpl implements OwnerService {

	private static OwnerRepository ownerRepository;

	public OwnerServiceImpl() {
		ownerRepository = new OwnerRepositoryImpl();
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) {
		Owner owner = MapperUtil.convertOwnerDtoToEntity(ownerDTO);
		ownerRepository.saveOwner(owner);
	}

	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {

		Owner owner = ownerRepository.findOwner(ownerId);

		if (owner == null) {
			throw new OwnerNotFoundException("Owner not found with id : " + ownerId);
		}

		return MapperUtil.convertOwnerEntityToDto(owner);
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (owner == null) {
			throw new OwnerNotFoundException("Owner not found");
		}
		ownerRepository.updatePetDetails(ownerId,petName);

	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (owner == null) {
			throw new OwnerNotFoundException("Owner not found");
		}
		ownerRepository.deleteOwner(ownerId);

	}
}