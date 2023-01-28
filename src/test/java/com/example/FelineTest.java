package com.example;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
public class FelineTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Animal animal;

    @Test
    public void eatFoodReturnListOfValues(){
        try {
            Feline feline = new Feline();
            String animalType = "Хищник";
            List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(animal.getFood(animalType)).thenReturn(expectedFoodList);
            List<String> actualList = feline.eatMeat();
            assertEquals(expectedFoodList, actualList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getFamilyReturnValidString(){
        Feline feline = new Feline();
        String expectedString = "Кошачьи";
        String actualString = feline.getFamily();
        assertEquals(expectedString, actualString);
    }
    @Test
    public void getKittensReturnValidCount(){
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens(1));
        assertEquals(feline.getKittens(1), feline.getKittens());
    }



}