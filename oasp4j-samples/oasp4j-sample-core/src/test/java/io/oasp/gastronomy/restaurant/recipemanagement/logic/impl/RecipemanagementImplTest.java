package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl;

import io.oasp.gastronomy.restaurant.general.common.AbstractSpringIntegrationTest;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.Recipemanagement;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.*;
import io.oasp.module.configuration.common.api.ApplicationConfigurationConstants;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import javax.inject.Inject;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pascaldung on 21.10.15.
 */
@ContextConfiguration({ ApplicationConfigurationConstants.BEANS_LOGIC })
public class RecipemanagementImplTest extends AbstractSpringIntegrationTest {

  @Inject
  private Recipemanagement recipeManagement;

  /**
   *
   * @throws Exception if test fails.
   */
  @Test
  public void testFindRecipe() throws Exception {

    assertEquals("Hamburger", this.recipeManagement.findRecipe(0L).getName());
  }

  /**
   *
   * @throws Exception if test fails.
   */
  @Test
  public void testFindCategory() throws Exception {

    final int expectedRecipeListSize = 149;
    final int expectedCategoryListSize = 14;
    final Money expectedRecipePrice = new Money(7.99);

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();
    Long[] categories = new Long[1];
    categories[0] = (long) 2;

    criteria.setCategories(categories);

    PaginatedListTo<RecipeEto> list = this.recipeManagement.findRecipeEtos(criteria);
    // von 2 auf 149 wegen Test Data !
    assertEquals(expectedRecipeListSize, list.getResult().size());
    assertEquals("Vorspeisen", this.recipeManagement.findCategory(0L).getName());
    assertEquals("de", this.recipeManagement.findCategory(0L).getLanguage());
    assertEquals(new Long(2), this.recipeManagement.findRecipe(0L).getCategoryId());
    assertEquals(expectedCategoryListSize, this.recipeManagement.findAllCategories().size());
    assertEquals("Vom Grill", this.recipeManagement.findCategory(2L).getName());
    assertEquals(new Long(2), this.recipeManagement.findRecipe(0L).getCategoryId());
    assertEquals(new Integer(1), this.recipeManagement.findRecipe(0L).getRating());
    assertEquals(expectedRecipePrice, this.recipeManagement.findRecipe(0L).getPrice());
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testFindRecipeEtos() throws Exception {

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();
    // wegen Testdaten von 7 auf 500
    // nachdem MAXIMUM HIT COUNT auf 1000
    PaginatedListTo<RecipeEto> list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(1000, list.getResult().size());
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testSearchRecipeEtosWithCriteriaSearchStringName() throws Exception {

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();
    criteria.setSearchString("hAm");
    // wegen Testdaten von 1 auf 9 geändert.
    PaginatedListTo<RecipeEto> list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(9, list.getResult().size());
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testSearchRecipeEtosWithCriteriaSearchStringDescription() throws Exception {

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();
    criteria.setSearchString("gEmÜse");

    PaginatedListTo<RecipeEto> list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(2, list.getResult().size());
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testSearchRecipeEtosWithCriteriaSearchStringTwoParameters() throws Exception {

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();
    criteria.setSearchString("Hamburger Lammkarree");

    PaginatedListTo<RecipeEto> list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(0, list.getResult().size());
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testFindRandomRecipesSize() throws Exception {

    List<RecipeEto> list = this.recipeManagement.findRandomRecipes(3, "en");
    assertEquals(3, list.size());
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testFindRandomRecipesLanguage() throws Exception {

    List<RecipeEto> list = this.recipeManagement.findRandomRecipes(3, "en");
    assertEquals("en", list.get(0).getLanguage());
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testDeleteRecipe() throws Exception {

    final Money price = new Money(0.99);

    // Create new Recipe to save and delete.
    RecipeEto newRecipe = new RecipeEto();
    newRecipe.setName("RecipeToBeDeleted");
    newRecipe.setDescription("A recipe, that is to be deleted.");
    newRecipe.setPrice(price);

    RecipeEto insertedRecipe = this.recipeManagement.saveRecipe(newRecipe);

    // Delete created recipe.
    this.recipeManagement.deleteRecipe(insertedRecipe.getId());

    assertEquals(null, this.recipeManagement.findRecipe(insertedRecipe.getId()));
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testSaveRecipe() throws Exception {

    final Money price = new Money(0.99);

    RecipeEto newRecipe = new RecipeEto();
    newRecipe.setName("NewRecipe");
    newRecipe.setDescription("A new recipe");
    newRecipe.setPrice(price);

    RecipeEto insertedRecipe = this.recipeManagement.saveRecipe(newRecipe);

    assertEquals(newRecipe.getName(), insertedRecipe.getName());
    assertEquals(newRecipe.getDescription(), insertedRecipe.getDescription());
    assertEquals(newRecipe.getPrice(), insertedRecipe.getPrice());
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testUpdateRecipe() throws Exception {

    final Money price = new Money(5.99);

    RecipeEto newRecipe = new RecipeEto();
    newRecipe.setDescription("this should be updated.");
    newRecipe.setImageId(10L);
    newRecipe.setPrice(price);
    newRecipe.setName("RecipeToBeUpdated");

    RecipeEto savedRecipe = this.recipeManagement.saveRecipe(newRecipe);

    savedRecipe.setDescription("this IS updated.");

    RecipeEto updatedRecipe = this.recipeManagement.saveRecipe(savedRecipe);

    assertEquals(savedRecipe.getId(), updatedRecipe.getId());
    assertEquals("Recipe name has changed", savedRecipe.getName(), updatedRecipe.getName());
    assertNotEquals("Recipe description was not updated", newRecipe.getDescription(), updatedRecipe.getDescription());

  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testGetBinaryObjectBlob() throws Exception {

    final int position = 12;
    final int length = 4;

    RecipeEto recipe = this.recipeManagement.findRecipe(6L);
    assertEquals(new Long(0), recipe.getImageId());

    final byte[] expected = { 13, 73, 72, 68 };
    byte[] actual = this.recipeManagement.getBinaryObjectBlob(recipe.getImageId()).getBytes(position, length);
    assertArrayEquals(expected, actual);
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testNewUpdateRecipePicture() throws Exception {

    final Money price = new Money(0.99);

    RecipeEto newRecipe = new RecipeEto();
    newRecipe.setId(null);
    newRecipe.setName("NewRecipe 123");
    newRecipe.setDescription("A new recipe 123");
    newRecipe.setPrice(price);
    RecipeEto insertedRecipe = this.recipeManagement.saveRecipe(newRecipe);

    final byte[] bytes = { 11, 22, 33, 44 };
    Blob blob = new SerialBlob(bytes);

    BinaryObjectEto binaryObjectEto = new BinaryObjectEto();
    binaryObjectEto.setMimeType("test");
    binaryObjectEto.setSize(blob.length());

    RecipeEto recipeEto = this.recipeManagement.updateRecipePicture(insertedRecipe.getId(), blob, binaryObjectEto);

    Blob binaryObjectBlob = this.recipeManagement.getBinaryObjectBlob(recipeEto.getImageId());

    byte[] actual = binaryObjectBlob.getBytes(1, 4);
    assertArrayEquals(bytes, actual);
  }

  /**
   * Test the update recipe picture functionality.
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testUpdateRecipePicture() throws Exception {

    final byte[] bytes = { 11, 22, 33, 44 };
    Blob blob = new SerialBlob(bytes);

    BinaryObjectEto binaryObjectEto = new BinaryObjectEto();
    binaryObjectEto.setMimeType("test");
    binaryObjectEto.setSize(blob.length());

    RecipeEto recipeEto = this.recipeManagement.updateRecipePicture(4L, blob, binaryObjectEto);
    Blob binaryObjectBlob = this.recipeManagement.getBinaryObjectBlob(recipeEto.getImageId());

    byte[] actual = binaryObjectBlob.getBytes(1, 4);
    assertArrayEquals(bytes, actual);
  }

  /**
   * Test for the findAllIngredients Method.
   *
   * @throws Exception When mapping the ingredients fails
     */
  @Test
  public void testFindAllIngredients() throws Exception {

    List<IngredientEto> ingredients = this.recipeManagement.findAllIngredients();
    assertEquals(2, ingredients.size());
  }

  /**
   * Tests saving a recipe together with recipeIngredients.
   *
   * @throws Exception When mapping of RecipeIngredients fails
     */
  @Test
  public void testSaveRecipeWithIngredients() throws Exception {

    final double amount = 55.0;

    RecipeEto recipe = this.recipeManagement.findRecipe(0L);
    assertEquals(2, recipe.getRecipeIngredients().size());

    List<IngredientEto> allIngredients = this.recipeManagement.findAllIngredients();

    RecipeIngredientEto recipeIngredientEto = new RecipeIngredientEto();
    recipeIngredientEto.setAmount(amount);
    recipeIngredientEto.setMeasuringUnit("Löffel");
    recipeIngredientEto.setPosition(4);
    recipeIngredientEto.setRecipeId(recipe.getId());
    recipeIngredientEto.setIngredient(allIngredients.get(0));

    recipe.getRecipeIngredients().add(recipeIngredientEto);
    RecipeEto savedRecipe = this.recipeManagement.saveRecipe(recipe);

    RecipeEto updatedRecipe = this.recipeManagement.findRecipe(0L);
    assertEquals(3, updatedRecipe.getRecipeIngredients().size());

    updatedRecipe.setRecipeIngredients(null);
    this.recipeManagement.saveRecipe(updatedRecipe);
    RecipeEto noIngredientsRecipe = this.recipeManagement.findRecipe(0L);
    assertEquals(0, noIngredientsRecipe.getRecipeIngredients().size());

    assertEquals(2, this.recipeManagement.findAllIngredients().size());

    RecipeSearchCriteriaTo recipeSearchCriteriaTo = new RecipeSearchCriteriaTo();
    PaginatedListTo<RecipeEto> recipeEtos = this.recipeManagement.findRecipeEtos(recipeSearchCriteriaTo);
    for (RecipeEto recipeEto : recipeEtos.getResult()) {
      if (recipeEto.getId() == 0L) {
        assertEquals(0, recipeEto.getRecipeIngredients().size());
      }
    }
  }

  /**
   * Tests the saving of recipes with newly added recipeIngredients.
   *
   * @throws Exception When mapping of RecipeIngredients fails.
     */
  @Test
  public void testSaveRecipeWithNewIngredient() throws Exception {

    final double amount = 55.0;

    List<IngredientEto> allIngredients = this.recipeManagement.findAllIngredients();

    RecipeEto recipe = this.recipeManagement.findRecipe(0L);
    assertEquals(2, recipe.getRecipeIngredients().size());

    IngredientEto newIngredientEto = new IngredientEto();
    newIngredientEto.setName("new one");

    RecipeIngredientEto recipeIngredientEto = new RecipeIngredientEto();
    recipeIngredientEto.setAmount(amount);
    recipeIngredientEto.setMeasuringUnit("Löffel");
    recipeIngredientEto.setPosition(4);
    recipeIngredientEto.setRecipeId(recipe.getId());
    recipeIngredientEto.setIngredient(newIngredientEto);

    recipe.getRecipeIngredients().add(recipeIngredientEto);
    RecipeEto savedRecipe = this.recipeManagement.saveRecipe(recipe);

    RecipeEto updatedRecipe = this.recipeManagement.findRecipe(0L);
    assertEquals(3, updatedRecipe.getRecipeIngredients().size());

    int updatedIngredientsSize = this.recipeManagement.findAllIngredients().size();
    assertEquals(allIngredients.size() + 1, updatedIngredientsSize);
  }

  /**
   * Tests the findRecipe Method with RecipeIngredients.
   *
   * @throws Exception WHen the mapping of recipes fails
     */
  @Test
  public void testRecipeWithIngredients() throws Exception {

    RecipeEto recipe = this.recipeManagement.findRecipe(0L);
    assertEquals(2, recipe.getRecipeIngredients().size());
  }

  // TODO check ingredient list

  /**
   *
   * @throws Exception if test fails.
   */
  @Test
  public void testFindAllCategories() throws Exception {

    final int expectedCategorySize = 14;

    List<CategoryEto> categories = this.recipeManagement.findAllCategories();
    assertEquals(expectedCategorySize, categories.size());
    assertEquals("Vorspeisen", categories.get(0).getName());
    assertEquals("de", categories.get(0).getLanguage());
  }

  /**
   * Tests the Filter for recipes.
   *
   */
  @Test
  public void testRecipeFilter() {

    final int priceToTwentyFour = 24;
    final int expectedResultSize = 102;

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();
    Long[] categories = new Long[1];
    categories[0] = (long) 2;
    PaginatedListTo<RecipeEto> list;

    criteria.setCategories(categories);
    criteria.setPriceFrom(7);
    criteria.setPriceTo(priceToTwentyFour);
    criteria.setRatingFrom(1);
    criteria.setRatingTo(1);
    // wegen Testdaten von 1 auf 7 geändert.
    list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(7, list.getResult().size());

    criteria.setCategories(null);
    criteria.setPriceFrom(7);
    criteria.setPriceTo(priceToTwentyFour);
    criteria.setRatingFrom(1);
    criteria.setRatingTo(5);
    // wegen Testdaten von 2 auf 102 geändert.
    list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(expectedResultSize, list.getResult().size());

    categories[0] = (long) 0;
    criteria.setCategories(categories);
    criteria.setPriceFrom(5);
    criteria.setPriceTo(6);
    criteria.setRatingFrom(null);
    criteria.setRatingTo(4);
    // wegen Testdaten von 2 auf 4 geändert.
    list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(4, list.getResult().size());

    try {
      criteria.setPriceFrom(null);
      fail("Expected an NullPointerException to be thrown");
    } catch (NullPointerException e) {
    }
  }

  /**
   *
   * @throws Exception if test fails.
   */
  @Test
  public void testRecipeWithCategory() throws Exception {

    RecipeEto recipe = this.recipeManagement.findRecipe(0L);
    assertEquals("Vom Grill", recipe.getCategoryEntity().getName());
    assertEquals("de", recipe.getCategoryEntity().getLanguage());
  }

  /**
   *
   * @throws Exception if test fails.
   */
  @Test
  public void testSaveRecipeWithNewCategory() throws Exception {

    RecipeEto recipe = this.recipeManagement.findRecipe(0L);
    assertEquals("Vom Grill", recipe.getCategoryEntity().getName());

    CategoryEto category = this.recipeManagement.findCategory(0L);
    recipe.setCategoryEntity(category);
    this.recipeManagement.saveRecipe(recipe);

    RecipeEto updatedRecipe = this.recipeManagement.findRecipe(0L);
    assertEquals("Vorspeisen", updatedRecipe.getCategoryEntity().getName());
  }

  /**
   *
   * @throws Exception if test fails.
   */
  @Test
  public void testFindCategoriesByLanguage() throws Exception {

    List<CategoryEto> categories = this.recipeManagement.findCategories("en");
    assertEquals(7, categories.size());
    assertEquals("Appetizer", categories.get(0).getName());
    assertEquals("en", categories.get(0).getLanguage());
  }

  /**
   * Tests the summed price returned by the price engine.
   */
  @Test
  public void testGetSummedPrice() {

    final Long firstIngredientId = 98765L;
    final Long secondIngredientId = 98766L;
    final Long thirdIngredientId = 98767L;

    final double firstAmount = 5.0;
    final double secondAmount = 50.0;
    final double thirdAmount = 75.0;

    Set<RecipeIngredientEto> ingredients = new HashSet<>(3);

    RecipeIngredientEto ingredientOne = new RecipeIngredientEto();
    ingredientOne.setId(firstIngredientId);
    ingredientOne.setAmount(firstAmount);
    ingredientOne.setMeasuringUnit("g");

    RecipeIngredientEto ingredientTwo = new RecipeIngredientEto();
    ingredientTwo.setId(secondIngredientId);
    ingredientTwo.setAmount(secondAmount);
    ingredientTwo.setMeasuringUnit("l");

    RecipeIngredientEto ingredientThree = new RecipeIngredientEto();
    ingredientThree.setId(thirdIngredientId);
    ingredientThree.setAmount(thirdAmount);
    ingredientThree.setMeasuringUnit("kg");

    ingredients.add(ingredientOne);
    ingredients.add(ingredientTwo);
    ingredients.add(ingredientThree);

    final Money expectedPrice = new Money(130.0);
    Money summedPrice = this.recipeManagement.getSummedPrice(ingredients);

    assertEquals(expectedPrice, summedPrice);
  }

  /**
   * Tests the returned price for a recipe without ingredients.
   */
  @Test
  public void testGetSummedPriceEmpty() {

    Set<RecipeIngredientEto> ingredients = new HashSet<RecipeIngredientEto>();

    Money expectedPrice = new Money(0.0);

    Money summedPrice = this.recipeManagement.getSummedPrice(ingredients);

    assertEquals(expectedPrice, summedPrice);
  }

  /**
   * Tests the returned price for a recipe that equals null.
   */
  @Test
  public void testGetSummedPriceNull() {

    Money expectedPrice = new Money(0.0);

    Money summedPrice = this.recipeManagement.getSummedPrice(null);

    assertEquals(expectedPrice, summedPrice);
  }

  /**
   * Tests the returned price for a recipe containing an empty ingredient in it's Set of ingredients.
   */
  @Test
  public void testGetSummedPriceWithOneEmptySlot() {

    final Long firstIngredientId = 98765L;
    final Long thirdIngredientId = 98767L;

    final double firstAmount = 5.0;
    final double thirdAmount = 75.0;

    Set<RecipeIngredientEto> ingredients = new HashSet<>();

    RecipeIngredientEto ingredientOne = new RecipeIngredientEto();
    ingredientOne.setId(firstIngredientId);
    ingredientOne.setAmount(firstAmount);
    ingredientOne.setMeasuringUnit("g");

    RecipeIngredientEto ingredientTwo = null;

    RecipeIngredientEto ingredientThree = new RecipeIngredientEto();
    ingredientThree.setId(thirdIngredientId);
    ingredientThree.setAmount(thirdAmount);
    ingredientThree.setMeasuringUnit("kg");

    ingredients.add(ingredientOne);
    ingredients.add(ingredientTwo);
    ingredients.add(ingredientThree);

    final Money expectedPrice = new Money(80.0);
    Money summedPrice = this.recipeManagement.getSummedPrice(ingredients);
  }

}
