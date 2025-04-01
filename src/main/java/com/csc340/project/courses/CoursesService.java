package com.tutelage.backenddemo.courses;



import com.tutelage.backenddemo.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository courseRepository;

    // Method to retrieve all courses
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    // Method to add a new course
    public void addCourse(Courses course) {
        courseRepository.save(course);
    }
}
