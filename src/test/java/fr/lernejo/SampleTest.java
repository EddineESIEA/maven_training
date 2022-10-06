package fr.lernejo;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {private final Calculator calculator = new Calculator();

    @Test // (1)
    void simple_division() {
        int result = calculator.divide(8).by(2); // (2)

        Assertions.assertThat(result) // (3)
            .as("division of 8 by 2")
            .isEqualTo(4); // (4)
    }

    @Test
    void division_by_zero_should_throw() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class) // (5)
            .isThrownBy(() -> calculator.divide(3).by(0)) // (6)
            .withMessage("Cannot divide by zero"); // (7)
    }

    @ParameterizedTest // (8)
    @CsvSource({
        "0, 3, 3",
        "3, 4, 7"
    }) // (9)
    void addition_cases(int a, int b, int expectedResult) { // (10)
        int result = calculator.add(a).and(b);

        Assertions.assertThat(result) // (3)
            .as("addition of " + a + " and " + b)
            .isEqualTo(expectedResult);
    }

}
