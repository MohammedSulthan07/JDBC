package com.hibernate.service.impl;

import com.hibernate.dto.OwnerDTO;
import com.hibernate.entity.Owner;
import com.hibernate.exception.DuplicateOwnerException;
import com.hibernate.exception.OwnerNotFoundException;
import com.hibernate.repository.OwnerRepository;
import com.hibernate.repository.impl.OwnerRepositoryImpl;
import com.hibernate.service.OwnerService;
import com.hibernate.util.MapperUtil;

import java.util.Objects;
import java.util.UUID;

public class OwnerServiceImpl implements OwnerService {

	private OwnerRepository ownerRepository;

	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException {

//		Owner owner = ownerRepository.findOwner(UUID.fromString(ownerDTO.getId()));
//
//		if (Objects.nonNull(owner)) {
//			throw new DuplicateOwnerException("Owner already exists");
//		}

		ownerRepository.saveOwner(MapperUtil.convertOwnerDtoToEntity(ownerDTO));
	}

	@Override
	public OwnerDTO findOwner(String ownerId) throws OwnerNotFoundException {

		Owner owner = ownerRepository.findOwner(UUID.fromString(ownerId));

		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("Owner Not Found");
		}

		return MapperUtil.convertOwnerEntityToDto(owner);
	}

	@Override
	public void updatePetDetails(String ownerId, String petName) throws OwnerNotFoundException {

		Owner owner = ownerRepository.findOwner(UUID.fromString(ownerId));

		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("Owner Not Found");
		}

		ownerRepository.updatePetDetails(UUID.fromString(ownerId),petName);
	}

	@Override
	public void deleteOwner(String ownerId) throws OwnerNotFoundException {

		Owner owner = ownerRepository.findOwner(UUID.fromString(ownerId));

		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("Owner Not Found");
		}

		ownerRepository.deleteOwner(UUID.fromString(ownerId));
	}
}