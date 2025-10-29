package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testMaleLionHasMane() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionHasNoMane() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetKittensReturnsCorrectCount() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        when(felineMock.getKittens()).thenReturn(3);

        int kittensCount = lion.getKittens();

        assertEquals(3, kittensCount);
    }

    @Test
    public void testGetKittensCallsFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        when(felineMock.getKittens()).thenReturn(3);

        lion.getKittens();

        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFoodReturnsCorrectFood() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsFelineEatMeat() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        lion.getFood();

        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testLionConstructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Неизвестный", felineMock);
    }
}