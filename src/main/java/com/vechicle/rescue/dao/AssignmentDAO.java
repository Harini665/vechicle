package com.vechicle.rescue.dao;

import org.hibernate.Session;

import com.vechicle.rescue.entity.Assignment;
import com.vechicle.rescue.util.HibernateUtil;

public class AssignmentDAO extends GenericDAO<Assignment> {

    public AssignmentDAO() {
        super(Assignment.class);
    }

    @SuppressWarnings("removal")
	public Assignment getAssignmentWithDetails(int assignmentId) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Assignment.class, assignmentId);
        }
    }
}