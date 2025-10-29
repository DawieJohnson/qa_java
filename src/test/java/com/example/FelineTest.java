package com.example;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void testEatMeatReturnsCorrectFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFamilyReturnsFelineFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }


    @Test
    public void testGetKittensWithoutParametersReturnsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
    // ....... */

    @Test
    public void testGetKittensWithParametersReturnsCorrectCount() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }
}