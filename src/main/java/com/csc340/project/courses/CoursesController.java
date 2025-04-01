package com.tutelage.backenddemo.courses;

import com.tutelage.backenddemo.customer.Customer;
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
@RequestMapping("/coursesdata")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;
//
//    /**
//     * Get all available courses
//     */
//    @GetMapping("/all")
//    public Object getAllCourses() {
//
//        return new ResponseEntity<>(coursesService.getAllCourses(), HttpStatus.OK);
//    }
//
//    @PostMapping("/new/addCourse")
//    public String addCourse(@RequestBody Courses course) {
//        coursesService.addCourse(course);
//        return "Course added";
//    }

    /**
     * Get all available courses
     */
    @GetMapping("/all")
    public ResponseEntity<List<Courses>> getAllCourses() {
        List<Courses> courses = coursesService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);  // Returning ResponseEntity with OK status
    }

    /**
     * Add a new course
     */
    @PostMapping("/new/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Courses course) {
        coursesService.addCourse(course);
        return new ResponseEntity<>("Course added successfully", HttpStatus.CREATED);  // Returning ResponseEntity with CREATED status
    }

}
