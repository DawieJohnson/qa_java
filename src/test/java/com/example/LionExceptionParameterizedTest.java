package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionExceptionParameterizedTest {

    @Mock
    private Feline felineMock;

    private final String invalidSex;

    public LionExceptionParameterizedTest(String invalidSex) {
        this.invalidSex = invalidSex;
    }

    @Parameterized.Parameters(name = "Invalid sex: {0}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {""},
                {null},
                {"Неизвестный"},
                {"самец"},
                {"САМЕЦ"}
        });
    }

    @Test
    public void testLionConstructorThrowsExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion(invalidSex, felineMock)
        );
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }
}