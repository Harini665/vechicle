package com.vechicle.rescue.service;

import java.time.LocalDate;

import com.vechicle.rescue.dao.AssignmentDAO;
import com.vechicle.rescue.dao.PaymentDAO;
import com.vechicle.rescue.entity.Assignment;
import com.vechicle.rescue.entity.Payment;

public class PaymentService {

    private AssignmentDAO assignmentDAO;
    private PaymentDAO paymentDAO;

    public PaymentService() {

        assignmentDAO = new AssignmentDAO();
        paymentDAO = new PaymentDAO();
    }

    public void makePayment(
            int assignmentId,
            double amount,
            String paymentMethod) {

        Assignment assignment =
                assignmentDAO.getById(assignmentId);

        if (assignment == null) {
            System.out.println("Assignment not found!");
            return;
        }

        if (!"Completed".equals(assignment.getStatus())) {

            System.out.println(
                    "Payment cannot be made because rescue is not completed."
            );

            return;
        }

        if (amount <= 0) {

            System.out.println(
                    "Payment amount must be greater than 0."
            );

            return;
        }

        Payment payment =
                new Payment(
                        amount,
                        LocalDate.now(),
                        paymentMethod,
                        "Paid"
                );

        payment.setAssignment(assignment);

        Payment savedPayment =
                paymentDAO.save(payment);

        System.out.println();
        System.out.println(
                "Payment completed successfully!"
        );

        System.out.println(
                "Payment ID: " +
                savedPayment.getPaymentId()
        );

        System.out.println(
                "Amount: ₹" +
                savedPayment.getAmount()
        );

        System.out.println(
                "Payment Method: " +
                savedPayment.getPaymentMethod()
        );
    }

    public void viewPayments() {

        var payments = paymentDAO.getAll();

        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        System.out.println();
        System.out.println("========== PAYMENTS ==========");

        for (Payment payment : payments) {

            int assignmentId = 0;

            if (payment.getAssignment() != null) {
                assignmentId =
                        payment.getAssignment().getAssignmentId();
            }

            System.out.println(
                    "Payment ID: " + payment.getPaymentId()
                    + " | Assignment ID: " + assignmentId
                    + " | Amount: ₹" + payment.getAmount()
                    + " | Date: " + payment.getPaymentDate()
                    + " | Method: " + payment.getPaymentMethod()
                    + " | Status: " + payment.getPaymentStatus()
            );
        }
    }
}