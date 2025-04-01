package com.tutelage.backenddemo.customer;

import com.tutelage.backenddemo.courses.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tutelagedata")
public class CustomerController {

    @Autowired
    private CustomerService service;

    /**
     * Get a list of customers in the database
     *http://localhost:8080/tutelagedata/all
     */
    @GetMapping("/all")
    public Object getAllCustomers() {
    return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }

    /**
     * Get a specific customer's information using id
     * http://localhost:8080/customers/1
     */
    @GetMapping("/{customerId}")
    public Object getCustomerById(@PathVariable int customerId) {
        return new ResponseEntity<>(service.getCustomertById(customerId), HttpStatus.OK);
    }

//    /**
//     * Get a list of customers under a specific course
//     *http://localhost:8080/customers/courses/csc-340
//     */
//    @GetMapping("/courses/{courseId}")
//    public Object getCustomerCourses(@PathVariable String courseId) {
//    return new ResponseEntity<>(service.getCustomersByCourseId(courseId), HttpStatus.OK);
//    }

    /**
     * Get list of all available courses/services
     * http://localhost:8080/tutelagedata/courses
     */
    @GetMapping("/courses")
    public Object getAllCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    /**
     * Get customer's schedule based on ID
     * http://localhost:8080/tutelagedata/1/schedule
     */
    @GetMapping("/schedule/{customerId}")
    public ResponseEntity<List<String>> getCustomerSchedule(@PathVariable int customerId) {

        return new ResponseEntity<>(service.getCustomerSchedule(customerId), HttpStatus.OK);
    }

    /**
     * Get customer's subscription type
     * http://localhost:8080/tutelagedata/1/isSubscribed
     */
    @GetMapping("/subscribed/{customerId}")
    public Object getCustomerSubscription(@PathVariable int customerId) {
        return new ResponseEntity<>(service.getCustomerSubscription(customerId), HttpStatus.OK);
    }

    @GetMapping("/reviews/{customerId}")
    public Object getCustomerReviews(@PathVariable int customerId) {
        return new ResponseEntity<>(service.getCustomerSubscription(customerId), HttpStatus.OK);
    }

    /**
     * Register a new customer
     * http://localhost:8080/tutelagedata/new
     */
    @PostMapping("/new/customer")
    public String addNewCustomer(@RequestBody Customer customer) {
        service.addNewCustomer(customer);
//        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.CREATED);
//        System.out.println("New customer added");
        return "Customer added";
    }

//    /**
//     * Post a new course
//     */
//    @PostMapping("/new/course")
//    public String addNewCourse(@RequestBody int customerId, @RequestParam String course) {
//        service.addNewCourse(customerId,course);
//        return "New course added";
//    }

    /**
     * Update Customer information and return new information
     * http://localhost:8080/tutelagedata/update/1
     */
    @PutMapping("/update/{customerId}")
    public Object updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        service.updateCustomer(customerId, customer);
        return new ResponseEntity<>(service.getCustomertById(customerId), HttpStatus.CREATED);
    }

    /**
     * Update a Customer's course
     */
    @PutMapping("/update/courses/{customerId}")
    public String updateCourses(@PathVariable int customerId, @RequestBody Map<String, String> courseAdd) {
        String newCourse = courseAdd.get("newCourse");
        service.updateCustomerCourse(customerId,newCourse);
        return "Course updated";
    }

    /**
     * Customer Site Review
     */
    @PutMapping("/update/sitereview/{customerId}")
    public ResponseEntity<String> updateSitereview(@PathVariable int customerId, @RequestBody Map<String, String> sitereviewAdd) {
        String siteReview = sitereviewAdd.get("siteReview");
        service.updateCustomerReview(customerId, siteReview);
        return new ResponseEntity<>("Thank you for the review!", HttpStatus.OK);
    }

    /**
     * Update a Customer's subscription status
     */
    @PutMapping("/update/subscription/{customerId}")
    public String updateSubscription(@PathVariable int customerId, @RequestBody Map<String, Boolean> subscribed) {
        boolean isSubscribed = subscribed.get("isSubscribed");
        service.updateSubscription(customerId, isSubscribed);
        return "Subscription updated";
    }

    /**
     * Update a Customer's schedule
     */
    @PutMapping("/update/schedule/{customerId}")
    public ResponseEntity<String> addSchedule(@PathVariable int customerId, @RequestBody Map<String, String> scheduleInput) {
        try {
            String newSchedule = scheduleInput.get("schedule");
            Date newScheduleDate = new SimpleDateFormat("yyyy-MM-dd").parse(newSchedule);
            boolean isUpdated = service.addScheduleToCustomer(customerId, newScheduleDate);
            if (isUpdated) {
                return new ResponseEntity<>("Schedule added.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update schedule.", HttpStatus.BAD_REQUEST);
            }
        } catch (ParseException e) {
            return new ResponseEntity<>("Invalid date format! Please use yyyy-MM-dd.", HttpStatus.BAD_REQUEST);
        }

    }



    /**
     * Enroll a customer to available course
     */



    /**
     * Delete account
     *  http://localhost:8080/tutelagedata/delete/1
     */
    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        service.deleteCustomer(customerId);
        System.out.println("Customer deleted");
    }





}
