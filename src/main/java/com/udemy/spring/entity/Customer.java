package com.udemy.spring.entity;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private int freePasses;

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

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }
}
