package com.udemy.spring.entity;

import com.udemy.spring.annotation.CourseCode;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;



@Component
public class Customer {

    @NotNull(message = "is required")
    @Size(min = 1, message = "Size should be more than 1")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "Size should be more than 1")
    private String lastName;

    @Min(value = 0, message = "must be > 0")
    @Max(value = 10, message = "must be < 10")
    @NotNull(message = "is required !!!")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    @CourseCode(value = "PIDOR" , message = "must starts with PIDOR")
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
