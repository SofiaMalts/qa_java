package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class LionTestToFail {
    private final String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
    private final String sex;


    public LionTestToFail(String sex){
        this.sex = sex;

    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Нечто"},
                {"Male"},
                {"Female"},
        };
    }

    @Test
    public void doesHaveManeReturnValidBoolean(){
        try {
            Feline feline = new Feline();
            Lion lion = new Lion(sex, feline);
            boolean hasMane = lion.doesHaveMane();
            assertTrue("Система принимает некорректный параметр:"+ sex, hasMane);
            assertFalse("Система принимает некорректный параметр:"+ sex, hasMane);
             } catch (Exception e) {
            assertEquals("Система показывает некорректный текст ошибки", expectedExceptionMessage,e.getMessage());
        }
    }
}