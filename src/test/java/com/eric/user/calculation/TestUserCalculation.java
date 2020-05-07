package com.eric.user.calculation;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestUserCalculation {

    @Test
    public void testNormal(){
        assertEquals(3, UserCalculation.calculateAge(LocalDate.of(2017, 1, 13)));
    }

    @Test
    public void testAbnormal_futureDate(){
        assertEquals(0, UserCalculation.calculateAge(LocalDate.of(2099, 1, 13)));
    }

    @Test
    public void testAbnormal_null(){
        assertEquals(-1, UserCalculation.calculateAge(null));
    }
}
