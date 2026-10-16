package com.vechicle.rescue.service;

import java.time.LocalDate;
import java.util.List;

import com.vechicle.rescue.dao.AssignmentDAO;
import com.vechicle.rescue.dao.BreakDownRequestDAO;
import com.vechicle.rescue.dao.MechanicDAO;
import com.vechicle.rescue.dao.VehicleDAO;
import com.vechicle.rescue.entity.Assignment;
import com.vechicle.rescue.entity.BreakdownRequest;
import com.vechicle.rescue.entity.Mechanic;
import com.vechicle.rescue.entity.Vehicle;

public class BreakdownService {

    private VehicleDAO vehicleDAO;
    private BreakDownRequestDAO breakdownRequestDAO;
    private MechanicDAO mechanicDAO;
    private AssignmentDAO assignmentDAO;

    public BreakdownService() {

        vehicleDAO = new VehicleDAO();
        breakdownRequestDAO = new BreakDownRequestDAO();
        mechanicDAO = new MechanicDAO();
        assignmentDAO = new AssignmentDAO();
    }

    public void createBreakdownRequest(
            int vehicleId,
            String problemType,
            String description,
            String location,
            int priority) {

        Vehicle vehicle = vehicleDAO.getById(vehicleId);

        if (vehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        BreakdownRequest request =
                new BreakdownRequest(
                        problemType,
                        description,
                        location,
                        priority,
                        "Pending",
                        LocalDate.now()
                );

        request.setVehicle(vehicle);

        BreakdownRequest savedRequest =
                breakdownRequestDAO.save(request);

        System.out.println();
        System.out.println("Breakdown request created!");
        System.out.println(
                "Request ID: " +
                savedRequest.getRescueId()
        );

        List<Mechanic> availableMechanics =
                mechanicDAO.getAvailableMechanics();

        if (availableMechanics.isEmpty()) {

            System.out.println(
                    "No mechanic is currently available."
            );

            return;
        }

        Mechanic mechanic =
                availableMechanics.get(0);

        Assignment assignment =
                new Assignment(
                        LocalDate.now(),
                        "Assigned"
                );

        assignment.setBreakdownRequest(request);
        assignment.setMechanic(mechanic);

        assignmentDAO.save(assignment);

        mechanic.setAvailabilityStatus("Busy");

        mechanicDAO.update(mechanic);

        request.setStatus("Assigned");

        breakdownRequestDAO.update(request);

        System.out.println(
                "Mechanic " +
                mechanic.getMechanicName() +
                " assigned successfully!"
        );

        System.out.println(
                "Breakdown process completed."
        );
    }

    public void viewBreakdownRequests() {

        var requests = breakdownRequestDAO.getAll();

        if (requests.isEmpty()) {
            System.out.println("No breakdown requests found.");
            return;
        }

        System.out.println();
        System.out.println("========== BREAKDOWN REQUESTS ==========");

        for (BreakdownRequest request : requests) {

            int vehicleId = 0;

            if (request.getVehicle() != null) {
                vehicleId =
                        request.getVehicle().getVehicleId();
            }

            System.out.println(
                    "Request ID: " + request.getRescueId()
                    + " | Vehicle ID: " + vehicleId
                    + " | Problem: " + request.getProblemType()
                    + " | Description: " + request.getDescription()
                    + " | Location: " + request.getLocation()
                    + " | Priority: " + request.getPriority()
                    + " | Status: " + request.getStatus()
                    + " | Date: " + request.getRequestDate()
            );
        }
    }
}