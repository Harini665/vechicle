package com.vechicle.rescue;

import java.util.Scanner;

import com.vechicle.rescue.service.CustomerService;
import com.vechicle.rescue.service.VehicleService;
import com.vechicle.rescue.service.BreakdownService;
import com.vechicle.rescue.service.RescueService;
import com.vechicle.rescue.service.PaymentService;
import com.vechicle.rescue.service.ServiceHistoryService;
import com.vechicle.rescue.dao.MechanicDAO;
import com.vechicle.rescue.entity.Mechanic;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomerService customerService =
                new CustomerService();

        VehicleService vehicleService =
                new VehicleService();

        BreakdownService breakdownService =
                new BreakdownService();

        RescueService rescueService =
                new RescueService();

        PaymentService paymentService =
                new PaymentService();

        ServiceHistoryService serviceHistoryService =
                new ServiceHistoryService();

        MechanicDAO mechanicDAO =
                new MechanicDAO();

        int choice;

        do {

            System.out.println();
            System.out.println(
                    "===== VEHICLE RESCUE MANAGEMENT SYSTEM ====="
            );

            System.out.println();

            System.out.println("1. Register Customer");
            System.out.println("2. Register Vehicle");
            System.out.println("3. Create Breakdown Request");
            System.out.println("4. Complete Rescue");
            System.out.println("5. Make Payment");
            System.out.println("6. Add Service History");
            System.out.println("7. View Customers");
            System.out.println("8. View Vehicles");
            System.out.println("9. View Breakdown Requests");
            System.out.println("10. View Assignments");
            System.out.println("11. View Payments");
            System.out.println("12. View Service History");
            System.out.println("13. View Available Mechanics");
            System.out.println("14. Exit");

            System.out.println();

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                // ==========================================
                // CASE 1 - REGISTER CUSTOMER
                // ==========================================

                case 1:

                    scanner.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customerName =
                            scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber =
                            scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email =
                            scanner.nextLine();

                    customerService.registerCustomer(
                            customerName,
                            phoneNumber,
                            email
                    );

                    break;


                // ==========================================
                // CASE 2 - REGISTER VEHICLE
                // ==========================================

                case 2:

                    System.out.print("Enter Customer ID: ");
                    int customerId =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Vehicle Number: ");
                    String vehicleNumber =
                            scanner.nextLine();

                    System.out.print("Enter Vehicle Type: ");
                    String vehicleType =
                            scanner.nextLine();

                    System.out.print("Enter Brand: ");
                    String brand =
                            scanner.nextLine();

                    System.out.print("Enter Model: ");
                    String model =
                            scanner.nextLine();

                    System.out.print("Enter Manufacturing Year: ");
                    int manufacturingYear =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Fuel Type: ");
                    String fuelType =
                            scanner.nextLine();

                    vehicleService.registerVehicle(
                            customerId,
                            vehicleNumber,
                            vehicleType,
                            brand,
                            model,
                            manufacturingYear,
                            fuelType
                    );

                    break;


                // ==========================================
                // CASE 3 - CREATE BREAKDOWN REQUEST
                // ==========================================

                case 3:

                    System.out.print("Enter Vehicle ID: ");
                    int vehicleId =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Problem Type: ");
                    String problemType =
                            scanner.nextLine();

                    System.out.print("Enter Description: ");
                    String description =
                            scanner.nextLine();

                    System.out.print("Enter Location: ");
                    String location =
                            scanner.nextLine();

                    System.out.println();
                    System.out.println("Priority:");
                    System.out.println("1. High");
                    System.out.println("2. Medium");
                    System.out.println("3. Low");

                    System.out.print("Enter Priority: ");

                    int priority =
                            scanner.nextInt();

                    breakdownService.createBreakdownRequest(
                            vehicleId,
                            problemType,
                            description,
                            location,
                            priority
                    );

                    break;


                // ==========================================
                // CASE 4 - COMPLETE RESCUE
                // ==========================================

                case 4:

                    System.out.print("Enter Assignment ID: ");

                    int assignmentId =
                            scanner.nextInt();

                    rescueService.completeRescue(
                            assignmentId
                    );

                    break;


                // ==========================================
                // CASE 5 - MAKE PAYMENT
                // ==========================================

                case 5:

                    System.out.print("Enter Assignment ID: ");

                    int paymentAssignmentId =
                            scanner.nextInt();

                    System.out.print("Enter Amount: ");

                    double amount =
                            scanner.nextDouble();

                    scanner.nextLine();

                    System.out.println();
                    System.out.println("Payment Methods:");
                    System.out.println("1. Cash");
                    System.out.println("2. UPI");
                    System.out.println("3. Card");

                    System.out.print("Enter Payment Method: ");

                    String paymentMethod =
                            scanner.nextLine();

                    paymentService.makePayment(
                            paymentAssignmentId,
                            amount,
                            paymentMethod
                    );

                    break;


                // ==========================================
                // CASE 6 - ADD SERVICE HISTORY
                // ==========================================

                case 6:

                    System.out.print("Enter Vehicle ID: ");

                    int historyVehicleId =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Service Type: ");

                    String serviceType =
                            scanner.nextLine();

                    System.out.print("Enter Description: ");

                    String serviceDescription =
                            scanner.nextLine();

                    System.out.print("Enter Status: ");

                    String serviceStatus =
                            scanner.nextLine();

                    serviceHistoryService.addServiceHistory(
                            historyVehicleId,
                            serviceType,
                            serviceDescription,
                            serviceStatus
                    );

                    break;


                // ==========================================
                // CASE 7 - VIEW CUSTOMERS
                // ==========================================

                case 7:

                    customerService.viewCustomers();

                    break;


                // ==========================================
                // CASE 8 - VIEW VEHICLES
                // ==========================================

                case 8:

                    vehicleService.viewVehicles();

                    break;


                // ==========================================
                // CASE 9 - VIEW BREAKDOWN REQUESTS
                // ==========================================

                case 9:

                    breakdownService.viewBreakdownRequests();

                    break;


                // ==========================================
                // CASE 10 - VIEW ASSIGNMENTS
                // ==========================================

                case 10:

                    rescueService.viewAssignments();

                    break;


                // ==========================================
                // CASE 11 - VIEW PAYMENTS
                // ==========================================

                case 11:

                    paymentService.viewPayments();

                    break;


                // ==========================================
                // CASE 12 - VIEW SERVICE HISTORY
                // ==========================================

                case 12:

                    serviceHistoryService.viewServiceHistory();

                    break;


                // ==========================================
                // CASE 13 - VIEW AVAILABLE MECHANICS
                // ==========================================

                case 13:

                    var mechanics =
                            mechanicDAO.getAvailableMechanics();

                    if (mechanics.isEmpty()) {

                        System.out.println(
                                "No mechanics are currently available."
                        );

                    } else {

                        System.out.println();
                        System.out.println(
                                "========== AVAILABLE MECHANICS =========="
                        );

                        for (Mechanic mechanic : mechanics) {

                            System.out.println(
                                    "ID: " +
                                    mechanic.getMechanicId()
                                    + " | Name: " +
                                    mechanic.getMechanicName()
                                    + " | Phone: " +
                                    mechanic.getPhone()
                                    + " | Specialization: " +
                                    mechanic.getSpecialization()
                                    + " | Status: " +
                                    mechanic.getAvailabilityStatus()
                            );
                        }
                    }

                    break;


                // ==========================================
                // CASE 14 - EXIT
                // ==========================================

                case 14:

                    System.out.println();
                    System.out.println(
                            "Thank you for using Vehicle Rescue Management System!"
                    );

                    break;


                // ==========================================
                // INVALID CHOICE
                // ==========================================

                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }

        } while (choice != 14);

        scanner.close();
    }
}



//package com.vechicle.rescue;
////import com.vechicle.rescue.entity.Assignment;
//import com.vechicle.rescue.entity.ServiceHistory;
//import com.vechicle.rescue.dao.ServiceHistoryDAO;
//import com.vechicle.rescue.dao.VehicleDAO;
////import com.vechicle.rescue.entity.BreakdownRequest;
////import com.vechicle.rescue.entity.Mechanic;
////import com.vechicle.rescue.entity.Payment;
////
////import java.time.LocalDate;
//
////import com.vechicle.rescue.dao.AssignmentDAO;
////import com.vechicle.rescue.dao.PaymentDAO;
////import com.vechicle.rescue.dao.BreakDownRequestDAO;
////import com.vechicle.rescue.dao.MechanicDAO;
////import com.vechicle.rescue.dao.CustomerDAO;
////import com.vechicle.rescue.entity.Customer;
//import com.vechicle.rescue.entity.Vehicle;
//public class Main {
//
//    public static void main(String[] args) {
//
//        System.out.println("Vehicle Rescue Management System");
//   VehicleDAO vechicledao = new VehicleDAO();
//   ServiceHistoryDAO serviceHistoryDAO = new ServiceHistoryDAO();
//   Vehicle vehicle = vechicledao.getById(2);
//   if(vehicle!=null) {
//	   ServiceHistory history = new ServiceHistory(
//               "Engine Repair",
//               "Engine issue repaired successfully",
//               "Completed"
//       );
//	   
//	   history.setVehicle(vehicle);
//	   serviceHistoryDAO.save(history);
//	   System.out.println("History saved successfully");
//	   
//   }else {
//	   System.out.println("vechicle not found");
//   }
   
//   
//CustomerDAO customerdao = new CustomerDAO();
//BreakDownRequestDAO breakdownrequestdao = new BreakDownRequestDAO();
//MechanicDAO mechanicdao = new MechanicDAO();
//AssignmentDAO assignmentdao = new AssignmentDAO();
//PaymentDAO paymentdao = new PaymentDAO();
////find exising assignment
//Assignment assignment = assignmentdao.getById(1);
//if(assignment!=null) {
//	//create payment
//	Payment payment = new Payment(1500,LocalDate.now(),"UPI","Paid");
//	//connect payment to assignment
//	payment.setAssignment(assignment);
//	//save payment
//	paymentdao.save(payment);
//	System.out.println("Payment saved successfully");
//}else {
//	System.out.println("Assignment not found!");
//}
//
//Mechanic mechanic = new Mechanic( "Arun",
//        "9876543210",
//        "Engine Repair",
//        "Available");
//mechanicdao.save(mechanic);
//System.out.println("mechanic saved successfully");
////find existing breakdown request
//
//BreakdownRequest request = breakdownrequestdao.getById(1);
//if(request!=null) {
//	//create assignment
//	Assignment assignment = new Assignment(
//			LocalDate.now(),
//			"Assigned");
//	//connect assignment to breakdownrequest
//	assignment.setBreakdownRequest(request);
//	
//	//connect assignment to mechanic
//	assignment.setMechanic(mechanic);
//	
//	//save assignment
//	
//	assignmentdao.save(assignment);
//}


//Vehicle vehicle = vechicledao.getById(2);
//if(vehicle!=null) {
//	  BreakdownRequest request = new BreakdownRequest(
//              "Engine Failure",
//              "Vehicle stopped suddenly",
//              "Coimbatore",
//              1,
//              "Pending",
//              LocalDate.now()
//      );
//	  request.setVehicle(vehicle);
//	  breakdownrequestdao.save(request);
//	  System.out.println("Breakdown request saved successfully");
	  
//}
//else {
//	System.out.println("vechicle not found");
//}
//Customer customer = customerdao.getById(2);
//if(customer != null) {
//	Vehicle vehicle = new Vehicle(
//	        "TN01AB1234",s
//	        "Car",
//	        "Toyota",
//	        "Corolla",
//	        2022,
//	        "Petrol"
//	);
//
//	vehicle.setCustomer(customer); 	
//	vechicledao.save(vehicle);
//	System.out.println("vehicle saved successfully");
//	
//}
//        //create a new customer
//        
//        Customer customer = new Customer(
//        		0,
//        		"TestCustomer",
//        		"90000000001",
//        		"testcustomer@example.com");
//        //save the customer
//        customerdao.save(customer);
//        System.out.println("customer saved successfully");
//        
//    List<Customer> customers = customerdao.getAll();
//    System.out.println("\nCustomerList: ");
//    Customer foundcustomer = customerdao.getById(2);
//    if(foundcustomer!=null) {
//    	System.out.println(foundcustomer.getCustomerId()+"|"+foundcustomer.getCustomerName()+"|"+foundcustomer.getEmail()+"|"+foundcustomer.getPhoneNumber());
//    	
//    }else {
//    	System.out.println("customer not found");
//    }
//    Customer customertoupdate = customerdao.getById(2);
//    if(customertoupdate!=null) {
//    	customertoupdate.setPhoneNumber("9999999999");
//    	customerdao.update(customertoupdate);
//    	System.out.println("customer updated successfully");
//    }
//   customerdao.deleteById(3);
//   System.out.println("customer deleted successfully");
//    
//    
//    }
//}