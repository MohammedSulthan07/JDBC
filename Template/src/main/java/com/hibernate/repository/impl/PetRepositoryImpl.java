package com.hibernate.repository.impl;

import com.hibernate.config.DatabaseConfig;
import com.hibernate.entity.Owner;
import com.hibernate.entity.Pet;
import com.hibernate.repository.PetRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PetRepositoryImpl implements PetRepository {

	private static final SessionFactory SESSION_FACTORY =
			DatabaseConfig.getSessionFactory();

	@Override
	public Pet findPet(int petId) {
		try (Session session = SESSION_FACTORY.openSession()) {
			Pet pet=session.find(Pet.class,petId);
			return pet;
		}
	}

}