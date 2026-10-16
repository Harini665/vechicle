package com.vechicle.rescue.service;

import com.vechicle.rescue.dao.AssignmentDAO;
import com.vechicle.rescue.dao.BreakDownRequestDAO;
import com.vechicle.rescue.dao.MechanicDAO;
import com.vechicle.rescue.entity.Assignment;
import com.vechicle.rescue.entity.BreakdownRequest;
import com.vechicle.rescue.entity.Mechanic;

public class RescueService {

    private AssignmentDAO assignmentDAO;
    private BreakDownRequestDAO breakdownRequestDAO;
    private MechanicDAO mechanicDAO;

    public RescueService() {

        assignmentDAO = new AssignmentDAO();
        breakdownRequestDAO = new BreakDownRequestDAO();
        mechanicDAO = new MechanicDAO();
    }

    public void completeRescue(int assignmentId) {

        Assignment assignment =
                assignmentDAO.getById(assignmentId);

        if (assignment == null) {
            System.out.println("Assignment not found!");
            return;
        }

        if (!"Assigned".equals(assignment.getStatus())) {

            System.out.println(
                    "This assignment cannot be completed."
            );

            return;
        }

        Mechanic mechanic =
                assignment.getMechanic();

        if (mechanic == null) {
            System.out.println("Mechanic not found!");
            return;
        }

        BreakdownRequest request =
                assignment.getBreakdownRequest();

        if (request == null) {

            System.out.println(
                    "Breakdown request not found!"
            );

            return;
        }

        assignment.setStatus("Completed");
        assignmentDAO.update(assignment);

        request.setStatus("Completed");
        breakdownRequestDAO.update(request);

        mechanic.setAvailabilityStatus("Available");
        mechanicDAO.update(mechanic);

        System.out.println();
        System.out.println(
                "Rescue completed successfully!"
        );

        System.out.println(
                "Mechanic " +
                mechanic.getMechanicName() +
                " is now Available."
        );
    }

    public void viewAssignments() {

        var assignments = assignmentDAO.getAll();

        if (assignments.isEmpty()) {
            System.out.println("No assignments found.");
            return;
        }

        System.out.println();
        System.out.println("========== ASSIGNMENTS ==========");

        for (Assignment assignment : assignments) {

            int requestId = 0;
            String mechanicName = "Not Assigned";

            if (assignment.getBreakdownRequest() != null) {
                requestId =
                        assignment.getBreakdownRequest().getRescueId();
            }

            if (assignment.getMechanic() != null) {
                mechanicName =
                        assignment.getMechanic().getMechanicName();
            }

            System.out.println(
                    "Assignment ID: " + assignment.getAssignmentId()
                    + " | Request ID: " + requestId
                    + " | Mechanic: " + mechanicName
                    + " | Date: " + assignment.getAssignedDate()
                    + " | Status: " + assignment.getStatus()
            );
        }
    }
}