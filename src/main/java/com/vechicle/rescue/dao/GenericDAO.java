
package com.vechicle.rescue.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vechicle.rescue.util.HibernateUtil;

public class GenericDAO<EntityType> {

    private final Class<EntityType> entityClass;

    public GenericDAO(Class<EntityType> entityClass) {
        this.entityClass = entityClass;
    }

    // CREATE
    public EntityType save(EntityType entity) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(entity);

            session.flush();

            transaction.commit();

            return entity;

        } catch (RuntimeException e) {

            if (transaction != null) {
                try {
                    if (transaction.isActive()) {
                        transaction.rollback();
                    }
                } catch (RuntimeException rollbackException) {
                    System.out.println(
                        "Rollback failed: "
                        + rollbackException.getMessage()
                    );
                }
            }

            throw e;
        }
    }

    // READ BY ID
    public EntityType getById(Integer id) {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session.get(entityClass, id);
        }
    }

    // READ ALL
    public List<EntityType> getAll() {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM " + entityClass.getSimpleName(),
                    entityClass
            ).getResultList();
        }
    }

    // UPDATE
    public EntityType update(EntityType entity) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            EntityType updatedEntity = session.merge(entity);

            transaction.commit();

            return updatedEntity;

        } catch (RuntimeException e) {

            if (transaction != null) {
                try {
                    if (transaction.isActive()) {
                        transaction.rollback();
                    }
                } catch (RuntimeException rollbackException) {
                    System.out.println(
                        "Rollback failed: "
                        + rollbackException.getMessage()
                    );
                }
            }

            throw e;
        }
    }

    // DELETE BY ID
    public void deleteById(Integer id) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            EntityType entity = session.get(entityClass, id);

            if (entity != null) {
                session.remove(entity);
            }

            transaction.commit();

        } catch (RuntimeException e) {

            if (transaction != null) {
                try {
                    if (transaction.isActive()) {
                        transaction.rollback();
                    }
                } catch (RuntimeException rollbackException) {
                    System.out.println(
                        "Rollback failed: "
                        + rollbackException.getMessage()
                    );
                }
            }

            throw e;
        }
    }
}
