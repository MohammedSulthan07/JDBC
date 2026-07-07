package com.hibernate.repository.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.config.DatabaseConfig;
import com.hibernate.entity.Owner;
import com.hibernate.repository.OwnerRepository;

import java.util.UUID;


public class OwnerRepositoryImpl implements OwnerRepository {
	private static final SessionFactory sessionFactory= DatabaseConfig.getSessionFactory();
	
	
	@Override
	public void saveOwner(Owner owner) {
		try(Session session=sessionFactory.openSession()){
			session.beginTransaction();
			session.persist(owner);
			session.getTransaction().commit();
		}
	}

	@Override
	public Owner findOwner(UUID ownerId) {
		try(Session session=sessionFactory.openSession()) {
			return session.find(Owner.class,ownerId);
		}
	}

	@Override
	public void updatePetDetails(UUID ownerId, String petName) {
		try(Session session=sessionFactory.openSession()){
			session.beginTransaction();
			Owner owner=session.find(Owner.class,ownerId);
			owner.setPetName(petName);
			session.merge(owner);
			session.getTransaction().commit();
		}
	}

	@Override
	public void deleteOwner(UUID ownerId) {
		try(Session session=sessionFactory.openSession()) {
			session.beginTransaction();
			Owner owner=session.find(Owner.class,ownerId);
			session.remove(owner);
			session.getTransaction().commit();
		}
	}
}

