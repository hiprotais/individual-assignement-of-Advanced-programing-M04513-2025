package com.school.school.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.school.school.beans.Course;
import com.school.school.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // CREATE
    @PostMapping ("/add")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.createCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    // READ ALL
    @GetMapping ("/findall")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    // READ BY ID
    @GetMapping ("/findbyid/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping ("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return ResponseEntity.ok(courseService.updateCourse(id, course));
    }

   
    // Delete student
    @DeleteMapping("delete/{id}")
    public String deleteCourse(@PathVariable  long id) {
        boolean deleted = courseService.deleteCoure( id);
        return deleted ? " Course deleted now!" : "Course not founded!";
 
    }
}
