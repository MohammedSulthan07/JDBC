package com.hibernate.repository.impl;

import com.hibernate.config.DatabaseConfig;
import com.hibernate.entity.Owner;
import com.hibernate.entity.Pet;
import com.hibernate.repository.OwnerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OwnerRepositoryImpl implements OwnerRepository {

	private static final SessionFactory SESSION_FACTORY =
			DatabaseConfig.getSessionFactory();

	@Override
	public void saveOwner(Owner owner) {
		try (Session session = SESSION_FACTORY.openSession()) {
			Transaction tx = session.beginTransaction();

			session.persist(owner);

			tx.commit();
		}
	}

	@Override
	public Owner findOwner(int ownerId) {
		try (Session session = SESSION_FACTORY.openSession()) {
			return session.find(Owner.class, ownerId);
		}
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) {
		try (Session session = SESSION_FACTORY.openSession()) {
			Transaction tx= session.beginTransaction();
			Owner owner=session.find(Owner.class,ownerId);
			owner.getPet().setName(petName);
			session.merge(owner);
			tx.commit();
		}

	}

	@Override
	public void deleteOwner(int ownerId) {
		try (Session session = SESSION_FACTORY.openSession()) {
			Transaction tx= session.beginTransaction();
			Owner owner=session.find(Owner.class,ownerId);
			session.remove(owner);
			tx.commit();
		}

	}
}