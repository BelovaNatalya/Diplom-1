package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BunTest {
    private Bun testBun;

    @Before
    public void createTestBun() {
        testBun = new Bun("black bun", 100);
    }

    @Test
    public void shouldBeBunNameCorrect() {
        String expectedName = "black bun";
        String actualName = testBun.getName();
        assertThat("Ожидаемый результат не совпал с фактическим", actualName, equalTo(expectedName));
    }

    @Test
    public void shouldBeBunPriceCorrect() {
        float expectedPrice = 100;
        float actualPrice = testBun.getPrice();
        assertThat("Ожидаемый результат не совпал с фактическим", actualPrice, equalTo(expectedPrice));
    }
}