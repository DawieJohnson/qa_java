package com.example;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    public void testGetFoodForHerbivoreReturnsCorrectFood() throws Exception {
        List<String> expectedFood = List.of("Трава", "Различные растения");
        List<String> actualFood = animal.getFood("Травоядное");
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodForPredatorReturnsCorrectFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = animal.getFood("Хищник");
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodForUnknownKindThrowsException() {
        Exception exception = assertThrows(Exception.class, () ->
                animal.getFood("Неизвестный")
        );
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }

    @Test
    public void testGetFamilyReturnsCorrectDescription() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
}