package com.tutelage.backenddemo.customer;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    Optional<Customer> findById(int customerId);
    List<Customer> getCustomersByCustomerId(int customerId);

    @Query("SELECT c.courses FROM Customer c")
    List<Customer> findAllCourses();

    @Query("SELECT c.schedule FROM Customer c WHERE c.customerId = :customerId")
    List<String> findAllSchedule(int customerId);

    @Query("SELECT c.subscribed FROM Customer c WHERE c.customerId =:customerId")
    Boolean findSubscribedByCustomerId(int customerId);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.courses = CASE " +
            "WHEN c.courses IS NULL OR c.courses = '' THEN :course " +
            "ELSE CONCAT(c.courses, ', ', :course) " +
            "END WHERE c.customerId = :customerId")
    void updateCustomerCourse(int customerId, String course);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.subscribed = :subscribed WHERE c.customerId = :customerId")
    void updateSubscription(@Param("subscribed") boolean subscribed, @Param("customerId") int customerId);


    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.reviews = :siteReview WHERE c.customerId = :customerId")
    void updateCustomerReview(int customerId, String siteReview);


//    @Modifying
//    @Query("UPDATE Customer c \n" +
//            "SET c.courses = \n"+
//            "CASE \n" +
//                "")
//    void addNewCourse(int customerId, String course);
}
