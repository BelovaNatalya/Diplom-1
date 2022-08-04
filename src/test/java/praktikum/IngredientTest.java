package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    private Ingredient testIngredient;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}{1}")
    public static Object[][] getIngredients() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100f},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100f},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300}
        };
    }

    @Before
    public void createTestIngredient() {
        testIngredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void shouldBePossibleToGetIngredientType() {
        IngredientType actualIngredientType = testIngredient.getType();
        assertThat("Фактический тип ингредиента не совпал с ожидаемым", actualIngredientType, equalTo(ingredientType));
    }

    @Test
    public void shouldBePossibleToGetIngredientName() {
        String actualIngredientName = testIngredient.getName();
        assertThat("Фактический тип ингредиента не совпал с ожидаемым", actualIngredientName, equalTo(ingredientName));
    }

    @Test
    public void shouldBePossibleToGetIngredientPrice() {
        float actualIngredientPrice = testIngredient.getPrice();
        assertThat("Фактический тип ингредиента не совпал с ожидаемым", actualIngredientPrice, equalTo(ingredientPrice));
    }
}