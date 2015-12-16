package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl;

import io.oasp.gastronomy.restaurant.general.common.AbstractSpringIntegrationTest;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.Recipemanagement;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategoryEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.IngredientEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeIngredientEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.module.configuration.common.api.ApplicationConfigurationConstants;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import java.sql.Blob;
import java.util.List;

import javax.inject.Inject;
import javax.sql.rowset.serial.SerialBlob;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

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

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();
    String[] categories = new String[1];
    categories[0] = "Vom Grill";

    criteria.setCategories(categories);

    PaginatedListTo<RecipeEto> list = this.recipeManagement.findRecipeEtos(criteria);

    assertEquals(2, list.getResult().size());
    assertEquals("Vorspeisen", this.recipeManagement.findCategory(0L).getName());
    assertEquals("de", this.recipeManagement.findCategory(0L).getLanguage());
    assertEquals(new Long(2), this.recipeManagement.findRecipe(0L).getCategoryId());
    assertEquals(14, this.recipeManagement.findAllCategories().size());
    assertEquals("Vom Grill", this.recipeManagement.findCategory(2L).getName());
    assertEquals(new Long(2), this.recipeManagement.findRecipe(0L).getCategoryId());
    assertEquals(new Integer(1), this.recipeManagement.findRecipe(0L).getRating());
    assertEquals(new Money(7.99), this.recipeManagement.findRecipe(0L).getPrice());
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testFindRecipeEtos() throws Exception {

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();

    PaginatedListTo<RecipeEto> list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(7, list.getResult().size());
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testSearchRecipeEtosWithCriteriaSearchStringName() throws Exception {

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();
    criteria.setSearchString("hAm");

    PaginatedListTo<RecipeEto> list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(1, list.getResult().size());
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

    // Create new Recipe to save and delete.
    RecipeEto newRecipe = new RecipeEto();
    newRecipe.setName("RecipeToBeDeleted");
    newRecipe.setDescription("A recipe, that is to be deleted.");
    newRecipe.setPrice(new Money(0.99));

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

    RecipeEto newRecipe = new RecipeEto();
    newRecipe.setName("NewRecipe");
    newRecipe.setDescription("A new recipe");
    newRecipe.setPrice(new Money(0.99));

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

    RecipeEto newRecipe = new RecipeEto();
    newRecipe.setDescription("this should be updated.");
    newRecipe.setImageId(10L);
    newRecipe.setPrice(new Money(5.99));
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

    RecipeEto recipe = this.recipeManagement.findRecipe(6L);
    assertEquals(new Long(0), recipe.getImageId());

    byte[] expected = { 13, 73, 72, 68 };
    byte[] actual = this.recipeManagement.getBinaryObjectBlob(recipe.getImageId()).getBytes(12, 4);
    assertArrayEquals(expected, actual);
  }

  /**
   *
   * @throws Exception if something fails.
   */
  @Test
  public void testNewUpdateRecipePicture() throws Exception {

    RecipeEto newRecipe = new RecipeEto();
    newRecipe.setId(null);
    newRecipe.setName("NewRecipe 123");
    newRecipe.setDescription("A new recipe 123");
    newRecipe.setPrice(new Money(0.99));
    RecipeEto insertedRecipe = this.recipeManagement.saveRecipe(newRecipe);

    byte[] bytes = { 11, 22, 33, 44 };
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

    byte[] bytes = { 11, 22, 33, 44 };
    Blob blob = new SerialBlob(bytes);

    BinaryObjectEto binaryObjectEto = new BinaryObjectEto();
    binaryObjectEto.setMimeType("test");
    binaryObjectEto.setSize(blob.length());

    RecipeEto recipeEto = this.recipeManagement.updateRecipePicture(4L, blob, binaryObjectEto);
    Blob binaryObjectBlob = this.recipeManagement.getBinaryObjectBlob(recipeEto.getImageId());

    byte[] actual = binaryObjectBlob.getBytes(1, 4);
    assertArrayEquals(bytes, actual);
  }

  @Test
  public void testFindAllIngredients() throws Exception {

    List<IngredientEto> ingredients = this.recipeManagement.findAllIngredients();
    assertEquals(2, ingredients.size());
    // TODO check content of the returned list
  }

  @Test
  public void testSaveRecipeWithIngredients() throws Exception {

    RecipeEto recipe = this.recipeManagement.findRecipe(0L);
    assertEquals(2, recipe.getRecipeIngredients().size());

    List<IngredientEto> allIngredients = this.recipeManagement.findAllIngredients();

    RecipeIngredientEto recipeIngredientEto = new RecipeIngredientEto();
    recipeIngredientEto.setAmount(55.0);
    recipeIngredientEto.setMeasuringUnit("Löffel");
    recipeIngredientEto.setPosition(4);
    recipeIngredientEto.setRecipeId(recipe.getId());
    recipeIngredientEto.setIngredient(allIngredients.get(0));

    recipe.getRecipeIngredients().add(recipeIngredientEto);
    this.recipeManagement.saveRecipe(recipe);

    RecipeEto updatedRecipe = this.recipeManagement.findRecipe(0L);
    assertEquals(3, updatedRecipe.getRecipeIngredients().size());
    // TODO check the new ingredient
  }

  @Test
  public void testSaveRecipeWithNewIngredient() throws Exception {

    RecipeEto recipe = this.recipeManagement.findRecipe(0L);
    assertEquals(2, recipe.getRecipeIngredients().size());

    IngredientEto newIngredientEto = new IngredientEto();
    newIngredientEto.setName("new one");

    RecipeIngredientEto recipeIngredientEto = new RecipeIngredientEto();
    recipeIngredientEto.setAmount(55.0);
    recipeIngredientEto.setMeasuringUnit("Löffel");
    recipeIngredientEto.setPosition(4);
    recipeIngredientEto.setRecipeId(recipe.getId());
    recipeIngredientEto.setIngredient(newIngredientEto);

    recipe.getRecipeIngredients().add(recipeIngredientEto);
    this.recipeManagement.saveRecipe(recipe);

    RecipeEto updatedRecipe = this.recipeManagement.findRecipe(0L);
    assertEquals(3, updatedRecipe.getRecipeIngredients().size());
    // TODO check the new ingredient
  }

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
    List<CategoryEto> categories = this.recipeManagement.findAllCategories();
    assertEquals(14, categories.size());
    assertEquals("Vorspeisen", categories.get(0).getName());
    assertEquals("de", categories.get(0).getLanguage());
  }

  @Test
  public void testRecipeFilter() {

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();
    String[] categories = new String[1];
    categories[0] = "Vom Grill";
    PaginatedListTo<RecipeEto> list;

    criteria.setCategories(categories);
    criteria.setPriceFrom(7);
    criteria.setPriceTo(24);
    criteria.setRatingFrom(1);
    criteria.setRatingTo(1);

    list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(1, list.getResult().size());

    criteria.setCategories(null);
    criteria.setPriceFrom(7);
    criteria.setPriceTo(24);
    criteria.setRatingFrom(1);
    criteria.setRatingTo(5);

    list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(2, list.getResult().size());

    categories[0] = "Vorspeisen";
    criteria.setCategories(categories);
    criteria.setPriceFrom(5);
    criteria.setPriceTo(6);
    criteria.setRatingFrom(null);
    criteria.setRatingTo(4);

    list = this.recipeManagement.findRecipeEtos(criteria);
    assertEquals(2, list.getResult().size());

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
    RecipeEto recipe = recipeManagement.findRecipe(0L);
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
}
