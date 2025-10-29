package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalGetFoodParameterizedTest {

    private final String animalKind;
    private final List<String> expectedFood;
    private final Animal animal = new Animal();

    public AnimalGetFoodParameterizedTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters(name = "Animal kind: {0}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void testGetFoodWithDifferentAnimalKinds() throws Exception {
        List<String> actualFood = animal.getFood(animalKind);
        assertEquals(expectedFood, actualFood);
    }
}