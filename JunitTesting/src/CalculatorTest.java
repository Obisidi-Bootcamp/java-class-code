import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

        Calculator calculator;


        @BeforeAll
        public static void init(){
                System.out.println("Running Junit tests");
        }

        @BeforeEach
        void setup(){
                calculator = new Calculator();
        }


        @Test
        @DisplayName("Simple Addition should work")
        void add_valid() {
                assertEquals(5, calculator.add(2, 3), "Regular addition should work");
        }

        @Test
        void add_invalid(){
                assertNotEquals(8, calculator.add(4,3), "Regular addition should work");
        }

        @Test
        void multiply_valid(){
                assertEquals(10,calculator.multiply(2,5));
        }

        @AfterAll
        static void cleanup(){
                System.out.println("Done with my testing");
        }







}

