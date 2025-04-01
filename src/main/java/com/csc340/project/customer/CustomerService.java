package com.tutelage.backenddemo.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CustomerService {

//
//    public Object getAllCustomers() {
//    }
//

//    public Object getCustomersByCourseId(String courseId) {
//    }

    @Autowired
    private CustomerRepository customerRepository;


    public Customer getCustomertById(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public List<Customer> getAllCourses() {
        return customerRepository.findAllCourses();
    }

    public List<String> getCustomerSchedule(int customerId) {
        return customerRepository.findAllSchedule(customerId);
    }

    public Object getCustomerSubscription(int customerId) {
        return customerRepository.findSubscribedByCustomerId(customerId);
    }


    public void addNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(int customerId, Customer customer) {
        Customer customert = getCustomertById(customerId);
        customert.setFirstName(customer.getFirstName());
        customert.setLastName(customer.getLastName());
        customert.setEmail(customer.getEmail());
        customert.setPassword(customer.getPassword());

        customerRepository.save(customert);
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void updateCustomerCourse(int customerId, String course) {
        customerRepository.updateCustomerCourse(customerId, course);
    }

    public void updateSubscription(int customerId, boolean subscribed) {
        customerRepository.updateSubscription(subscribed, customerId);
    }

    public boolean updateCustomerSchedule(int customerId, List<Date> newScheduleDates) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            // Replace the current schedule with the new one
            customer.setSchedule( newScheduleDates);

            // Save the updated customer object
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    public boolean addScheduleToCustomer(int customerId, Date newScheduleDate) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            // Get current schedule
            List<Date> currentSchedule = customer.getSchedule();

            // If the schedule is null, initialize it
            if (currentSchedule == null) {
                currentSchedule = new ArrayList<>();
            }

            // Add the new schedule item
            currentSchedule.add(newScheduleDate);

            // Update the customer schedule
            customer.setSchedule(currentSchedule);

            // Save the updated customer object
            customerRepository.save(customer);
            return true;
        }
        return false;
    }


    public void updateCustomerReview(int customerId, String siteReview) {
        customerRepository.updateCustomerReview(customerId, siteReview);
    }
}
