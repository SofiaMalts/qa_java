package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)

public class LionTest {
    private final String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;

    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Нечто", true},
        };
    }
    @Mock
    Feline feline;

    @Test
    public void doesHaveManeReturnValidBoolean(){
        try {
            Feline feline = new Feline();

            Lion lion = new Lion(sex, feline);

            boolean expected = hasMane;
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);
        } catch (Exception e) {
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }
    @Test
    public void getKittensReturnValidNumber(){
        try {
            Lion lion = new Lion(sex, feline);
            Mockito.when(feline.getKittens()).thenReturn(1);
            assertEquals(1, lion.getKittens());
        } catch (Exception e) {
            assertEquals(expectedExceptionMessage, e.getMessage());
        }
    }
    @Test
    public void getFoodReturnValidList(){
        try {
            Lion lion = new Lion(sex, feline);
            List <String> expectedList = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(expectedList);
            assertEquals(expectedList, lion.getFood());
        } catch (Exception e) {
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }
}