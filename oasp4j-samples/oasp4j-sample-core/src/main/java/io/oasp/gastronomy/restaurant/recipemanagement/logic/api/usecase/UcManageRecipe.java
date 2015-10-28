package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase;

import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;

import java.sql.Blob;

/**
 * Interface of UcManageRecipe to centralize documentation and signatures of methods.
 */
public interface UcManageRecipe {

  /**
   * Deletes a recipe from the database by its id 'recipeId'.
   *
   * @param recipeId Id of the recipe to delete
   * @return boolean <code>true</code> if the recipe can be deleted, <code>false</code> otherwise
   */
  void deleteRecipe(Long recipeId);

  /**
   * Saves a recipe and store it in the database.
   *
   * @param recipe the {@link RecipeEto} to create.
   * @return the new {@link RecipeEto} that has been saved with ID and version.
   */
  RecipeEto saveRecipe(RecipeEto recipe);

  /**
   * Update the picture of the passed recipe in database.
   *
   * @param recipeId Id of the recipe to update
   * @param blob picture as Blob
   * @param binaryObjectEto the {@link BinaryObjectEto} to store the picture in.
   * @return
   */
  RecipeEto updateRecipePicture(Long recipeId, Blob blob, BinaryObjectEto binaryObjectEto);

}
