package com.vechicle.rescue.service;

import com.vechicle.rescue.dao.CustomerDAO;
import com.vechicle.rescue.dao.VehicleDAO;
import com.vechicle.rescue.entity.Customer;
import com.vechicle.rescue.entity.Vehicle;

public class VehicleService {

    private VehicleDAO vehicleDAO;
    private CustomerDAO customerDAO;

    public VehicleService() {
        vehicleDAO = new VehicleDAO();
        customerDAO = new CustomerDAO();
    }

    public void registerVehicle(
            int vehicleId,
            String vechicleNumber,
            String vechicleType,
            String brand,
            String model,
            int manufactoringYear,
            String fuelType) {

        Customer customer = customerDAO.getById(vehicleId);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        Vehicle vehicle = new Vehicle(
                vechicleNumber,
                vechicleType,
                brand,
                model,
                manufactoringYear,
                fuelType
        );

        vehicle.setCustomer(customer);

        Vehicle savedVehicle = vehicleDAO.save(vehicle);

        System.out.println();
        System.out.println("Vehicle registered successfully!");
        System.out.println("Vehicle ID: " + savedVehicle.getVehicleId());
        System.out.println("Vehicle Number: " + savedVehicle.getVechicleNumber());
        System.out.println("Vehicle Type: " + savedVehicle.getVechicleType());
        System.out.println("Brand: " + savedVehicle.getBrand());
        System.out.println("Model: " + savedVehicle.getModel());
        System.out.println("Manufacturing Year: " + savedVehicle.getManufactoringYear());
        System.out.println("Fuel Type: " + savedVehicle.getFuelType());
        System.out.println("Customer: " + customer.getCustomerName());
    }

    public void viewVehicles() {

        var vehicles = vehicleDAO.getAll();

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.println();
        System.out.println("========== VEHICLES ==========");

        for (Vehicle vehicle : vehicles) {

            String customerName = "Not Assigned";

            if (vehicle.getCustomer() != null) {
                customerName =
                        vehicle.getCustomer().getCustomerName();
            }

            System.out.println(
                    "ID: " + vehicle.getVehicleId()
                    + " | Number: " + vehicle.getVechicleNumber()
                    + " | Type: " + vehicle.getVechicleType()
                    + " | Brand: " + vehicle.getBrand()
                    + " | Model: " + vehicle.getModel()
                    + " | Year: " + vehicle.getManufactoringYear()
                    + " | Fuel: " + vehicle.getFuelType()
                    + " | Customer: " + customerName
            );
        }
    }
}