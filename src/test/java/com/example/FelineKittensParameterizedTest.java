package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FelineKittensParameterizedTest {

    private final int kittensCount;
    private final int expectedCount;
    private final Feline feline = new Feline();

    public FelineKittensParameterizedTest(int kittensCount, int expectedCount) {
        this.kittensCount = kittensCount;
        this.expectedCount = expectedCount;
    }

    @Parameterized.Parameters(name = "Kittens count: {0}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {5, 5},
                {10, 10}
        });
    }

    @Test
    public void testGetKittensWithDifferentCounts() {
        assertEquals(expectedCount, feline.getKittens(kittensCount));
    }
}