package com.vechicle.rescue;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import com.vechicle.rescue.entity.Customer;
import com.vechicle.rescue.entity.Vehicle;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	//1.create hibernate configuration
    Configuration cfg = new Configuration();
    // 2. read hibernate.cfg.xml file
    cfg.configure();
    //3.register our entity
    cfg.addAnnotatedClass(Customer.class);
    cfg.addAnnotatedClass(Vehicle.class);
    //4. create session factory
    SessionFactory factory = cfg.buildSessionFactory();
    //5.open a session
    Session session = factory.openSession();
    Customer customer = new Customer();
    customer.setCustomerName("Harini");
    customer.setPhoneNumber("9876543210");
    customer.setEmail("harini@gmail.com");
    Vehicle vehicle = new Vehicle();
    vehicle.setVechicleNumber("TN01AB1234");
    vehicle.setVechicleType("Car");
    vehicle.setBrand("Hyundai");
    vehicle.setModel("i20");
    vehicle.setManufactoringYear(2022);
    vehicle.setFuelType("Petrol");
    vehicle.setCustomer(customer);
    Transaction transaction = session.beginTransaction();
    session.persist(customer);
    session.persist(vehicle);
    transaction.commit();
    System.out.println("vechicle and customer created successfully");
    System.out.println("Hibernate Started Sucesfully");
    //6.close the session
    session.close();
    //7.closing the session factory
    factory.close();
}
}
