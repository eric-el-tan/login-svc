package com.eric.user.calculation;

import java.time.LocalDate;
import java.time.Period;

public class UserCalculation {

    private UserCalculation instance;

    public UserCalculation getInstance(){
        if (instance == null){
            instance = new UserCalculation();
        }
        return instance;
    }

    public static int calculateAge(LocalDate birthDate) {
        int yearsOfAge = -1;

        if (birthDate == null) {
            return yearsOfAge;
        }

        yearsOfAge = Period.between(birthDate, LocalDate.now()).getYears();

        if (yearsOfAge < 0) {
            yearsOfAge = 0;
        }

        return yearsOfAge;
    }
}
