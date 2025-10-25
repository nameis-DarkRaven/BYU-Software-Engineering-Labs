package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person testPerson;

    @BeforeEach
    public void setup(){
        testPerson = new Person("Methusalah", "McIntosh", LocalDate.parse("1996-01-01"));
    }

    @Test
    public void testGetFullName(){
        String expectedFullName = "Methusalah McIntosh";
        assertEquals(expectedFullName, testPerson.getFullName());
    }

    @Test
    public void testGetAge(){
        double age = 29;
        assertEquals(age, testPerson.getAge());
    }
}