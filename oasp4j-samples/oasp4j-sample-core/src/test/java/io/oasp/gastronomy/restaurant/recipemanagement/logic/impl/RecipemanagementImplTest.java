package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl;

import io.oasp.gastronomy.restaurant.general.common.AbstractSpringIntegrationTest;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.Recipemanagement;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.module.configuration.common.api.ApplicationConfigurationConstants;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import javax.inject.Inject;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;

/**
 * Created by pascaldung on 21.10.15.
 */
@ContextConfiguration({ ApplicationConfigurationConstants.BEANS_LOGIC })
public class RecipemanagementImplTest extends AbstractSpringIntegrationTest {

  @Inject
  Recipemanagement recipeManagement;



  @Test
  public void testFindRecipe() throws Exception {

    assertEquals("WienerSchnitzel", recipeManagement.findRecipe(0L).getName());
  }

  @Test
  public void testFindRecipeEtos() throws Exception {

    RecipeSearchCriteriaTo criteria = new RecipeSearchCriteriaTo();

    PaginatedListTo<RecipeEto> list = recipeManagement.findRecipeEtos(criteria);
    assertEquals(5, list.getResult().size());
  }

  @Test
  public void testDeleteRecipe() throws Exception {

    //Create new Recipe to save and delete.
    RecipeEto newRecipe = new RecipeEto();
    newRecipe.setName("RecipeToBeDeleted");
    newRecipe.setDescription("A recipe, that is to be deleted.");
    newRecipe.setPrice(new Money(0.99));

    RecipeEto insertedRecipe = this.recipeManagement.saveRecipe(newRecipe);

    //Delete created recipe.
    this.recipeManagement.deleteRecipe(insertedRecipe.getId());

    assertEquals(null, this.recipeManagement.findRecipe(insertedRecipe.getId()));
  }

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

  @Test
  public void testGetBinaryObjectBlob() throws Exception {

    RecipeEto recipe = this.recipeManagement.findRecipe(4L);
    assertEquals(new Long(10), recipe.getImageId());

    byte[] expected = {13, 73, 72, 68};
    byte[] actual = this.recipeManagement.getBinaryObjectBlob(recipe.getImageId()).getBytes(12, 4);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testNewUpdateRecipePicture() throws Exception {
    RecipeEto newRecipe = new RecipeEto();
    newRecipe.setId(null);
    newRecipe.setName("NewRecipe 123");
    newRecipe.setDescription("A new recipe 123");
    newRecipe.setPrice(new Money(0.99));
    RecipeEto insertedRecipe = this.recipeManagement.saveRecipe(newRecipe);

    byte[] bytes = {11, 22, 33, 44};
    Blob blob = new SerialBlob(bytes);

    BinaryObjectEto binaryObjectEto = new BinaryObjectEto();
    binaryObjectEto.setMimeType("test");
    binaryObjectEto.setSize(blob.length());

    RecipeEto recipeEto = this.recipeManagement.updateRecipePicture(insertedRecipe.getId(), blob, binaryObjectEto);

    Blob binaryObjectBlob = recipeManagement.getBinaryObjectBlob(recipeEto.getImageId());

    byte[] actual = binaryObjectBlob.getBytes(1, 4);
    assertArrayEquals(bytes, actual);
  }

  @Test
  public void testUpdateRecipePicture() throws Exception {

    byte[] bytes = {11, 22, 33, 44};
    Blob blob = new SerialBlob(bytes);

    BinaryObjectEto binaryObjectEto = new BinaryObjectEto();
    binaryObjectEto.setMimeType("test");
    binaryObjectEto.setSize(blob.length());

    RecipeEto recipeEto = this.recipeManagement.updateRecipePicture(4L, blob, binaryObjectEto);
    Blob binaryObjectBlob = recipeManagement.getBinaryObjectBlob(recipeEto.getImageId());

    byte[] actual = binaryObjectBlob.getBytes(1, 4);
    assertArrayEquals(bytes, actual);
  }

}
