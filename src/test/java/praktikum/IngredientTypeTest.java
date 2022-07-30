package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void shouldBeTwoTypesOfIngredients() {
        int expectedAmount = 2;
        assertThat("Фактическое количество типов ингридиентов не совпало с ожидаемым", IngredientType.values().length, equalTo(expectedAmount));
    }

    @Test
    public void shouldBeSauceType() {
        assertThat("Типа ингридиентов sauce нет в списке", SAUCE.name(), equalTo("SAUCE"));
    }

    @Test
    public void shouldBeFillingType() {
        assertThat("Типа ингридиентов filling нет в списке", FILLING.name(), equalTo("FILLING"));
    }
}
