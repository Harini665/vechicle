package com.vechicle.rescue.dao;

import java.util.List;

import org.hibernate.Session;

import com.vechicle.rescue.entity.Mechanic;
import com.vechicle.rescue.util.HibernateUtil;

public class MechanicDAO extends GenericDAO<Mechanic> {

    public MechanicDAO() {
        super(Mechanic.class);
    }

    public List<Mechanic> getAvailableMechanics() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM Mechanic WHERE availabilityStatus = :status",
                    Mechanic.class
            )
            .setParameter("status", "Available")
            .getResultList();
        }
    }
}