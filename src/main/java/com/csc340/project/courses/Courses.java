package com.tutelage.backenddemo.courses;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
public class Courses {

    //course ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(nullable=false)
    private String courseName;

    @Column(nullable = false)
    private String courseInstructor;

    public Courses(String courseName, String courseInstructor) {
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;
    }

    public Courses() {}

    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }
    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

}
