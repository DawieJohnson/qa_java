package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Predator predatorMock;

    @Test
    public void testGetSoundReturnsMeow() {
        Cat cat = new Cat(predatorMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodReturnsCorrectFood() throws Exception {
        Cat cat = new Cat(predatorMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsEatMeat() throws Exception {
        Cat cat = new Cat(predatorMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        cat.getFood();

        verify(predatorMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodPropagatesException() throws Exception {
        Cat cat = new Cat(predatorMock);
        when(predatorMock.eatMeat()).thenThrow(new Exception("Ошибка получения пищи"));

        cat.getFood();
    }
}