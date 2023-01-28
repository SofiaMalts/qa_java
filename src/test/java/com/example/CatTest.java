package com.example;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class CatTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Predator predator;
    @Test
    public void getSoundReturnValidString(){
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }
    @Test
    public void getFoodReturnValidList(){
        try {
            Feline feline = new Feline();
            Cat cat = new Cat(feline);
            List<String> expected = List.of ("Животные", "Птицы", "Рыба");
            Mockito.when(predator.eatMeat()).thenReturn(expected);
            assertEquals(expected, cat.getFood());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
