package com.vechicle.rescue.service;

import com.vechicle.rescue.dao.ServiceHistoryDAO;
import com.vechicle.rescue.dao.VehicleDAO;
import com.vechicle.rescue.entity.ServiceHistory;
import com.vechicle.rescue.entity.Vehicle;

public class ServiceHistoryService {

    private ServiceHistoryDAO serviceHistoryDAO;
    private VehicleDAO vehicleDAO;

    public ServiceHistoryService() {

        serviceHistoryDAO = new ServiceHistoryDAO();
        vehicleDAO = new VehicleDAO();
    }

    public void addServiceHistory(
            int vehicleId,
            String serviceHistory,
            String serviceDescription,
            String serviceStatus) {

        Vehicle vehicle =
                vehicleDAO.getById(vehicleId);

        if (vehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        ServiceHistory history =
                new ServiceHistory(
                        serviceHistory,
                        serviceDescription,
                        serviceStatus
                );

        history.setVehicle(vehicle);

        ServiceHistory savedHistory =
                serviceHistoryDAO.save(history);

        System.out.println();
        System.out.println(
                "Service history added successfully!"
        );

        System.out.println(
                "History ID: " +
                savedHistory.getHistoryId()
        );

        System.out.println(
                "Vehicle ID: " +
                vehicle.getVehicleId()
        );

        System.out.println(
                "Service: " +
                savedHistory.getServiceHistory()
        );

        System.out.println(
                "Status: " +
                savedHistory.getServiceStatus()
        );
    }

    public void viewServiceHistory() {

        var histories =
                serviceHistoryDAO.getAll();

        if (histories.isEmpty()) {
            System.out.println("No service history found.");
            return;
        }

        System.out.println();
        System.out.println("========== SERVICE HISTORY ==========");

        for (ServiceHistory history : histories) {

            int vehicleId = 0;

            if (history.getVehicle() != null) {
                vehicleId =
                        history.getVehicle().getVehicleId();
            }

            System.out.println(
                    "History ID: " + history.getHistoryId()
                    + " | Vehicle ID: " + vehicleId
                    + " | Service: " + history.getServiceHistory()
                    + " | Description: " + history.getServiceDescription()
                    + " | Status: " + history.getServiceStatus()
            );
        }
    }
}