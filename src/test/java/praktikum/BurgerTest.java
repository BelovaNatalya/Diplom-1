package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger testBurger;

    @Mock
    private Ingredient ingredientOne;

    @Mock
    private Ingredient ingredientTwo;

    @Mock
    private Bun bun;

    @Before
    public void createTestBurger() {
        testBurger = new Burger();
    }

    @Test
    public void shouldBePossibleToSetBuns() {
        testBurger.setBuns(bun);

        assertThat("Не получилось добавить булочку", testBurger.bun, equalTo(bun));
    }

    @Test
    public void shouldBePossibleToAddIngredient() {
        testBurger.addIngredient(ingredientOne);

        assertThat("Не получилось добавить ингредиент", testBurger.ingredients.contains(ingredientOne));
    }

    @Test
    public void shouldBePossibleToRemoveOneAddedIngredient() {
        testBurger.addIngredient(ingredientOne);
        testBurger.removeIngredient(0);

        assertThat("Не получилось удалить ингредиент", testBurger.ingredients.isEmpty());
    }

    @Test
    public void shouldBePossibleToMoveIngredient() {
        testBurger.addIngredient(ingredientOne);
        testBurger.addIngredient(ingredientTwo);
        testBurger.moveIngredient(1,0);

        assertThat("Не получилось переместить ингредиент", testBurger.ingredients.get(0), equalTo(ingredientTwo));
    }

    @Test
    public void shouldBePossibleToGetPriceOfBurger() {
        testBurger.setBuns(bun);
        testBurger.ingredients.add(ingredientOne);
        testBurger.ingredients.add(ingredientTwo);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredientOne.getPrice()).thenReturn(100f);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(100f);

        float expectedPrice = 400;

        assertThat("Фактическая стоимость не совпала с ожидаемой", testBurger.getPrice(), equalTo(expectedPrice));
    }

    @Test
    public void shouldBePossibleToGetReceiptOfBurger() {
        testBurger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);

        testBurger.ingredients.add(ingredientOne);
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientOne.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientOne.getPrice()).thenReturn(100f);

        testBurger.ingredients.add(ingredientTwo);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientTwo.getName()).thenReturn("dinosaur");
        Mockito.when(ingredientTwo.getPrice()).thenReturn(200f);

        String expectedReceipt = "(==== black bun ====)" + "\r\n= sauce hot sauce =" +
                                 "\r\n= filling dinosaur =" + "\r\n(==== black bun ====)\r\n" +
                                 "\r\nPrice: 500,000000\r\n";
        assertThat("Фактический рецепт не совпал с ожидаемым", testBurger.getReceipt(), equalTo(expectedReceipt));
    }
}