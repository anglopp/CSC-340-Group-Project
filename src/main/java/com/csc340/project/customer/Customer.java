package com.tutelage.backenddemo.customer;


import com.tutelage.backenddemo.courses.Courses;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="tutelagedata")
public class Customer {

    // customer ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    // customer's first name
    @Column(nullable = false)
    private String firstName;

    // customer's lastname
    @Column(nullable = false)
    private String lastName;

    //customer's email
    @Column(nullable = false)
    private String email;

    //customer's password
    @Column(nullable = false)
    private String password;

    // customer's courses
    private String courses;

    //customer's course schedule
    @Temporal(TemporalType.DATE)
    @ElementCollection
    private List<Date> schedule;

    //customer's reviews
    private String reviews;

    // paid or free
    private boolean subscribed;

    public Customer(String firstName, String lastName,
                    String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Customer() {

    }

    public String getCourses() {
        return courses;
    }

    public List<Date> getSchedule() {
        return schedule;
    }

    public String getReviews() {
        return reviews;
    }

    public int getCustomerId() {
        return customerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public void setSchedule(List<Date> schedule) {
        this.schedule = schedule;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }


}
