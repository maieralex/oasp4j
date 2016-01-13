package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl.usecase;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.IngredientEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.RecipeEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.RecipeIngredientEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcManageRecipe;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase.AbstractRecipeUc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import java.sql.Blob;
import java.util.Objects;

/**
 * Use case implementation for modifying and deleting Recipes.
 */
@Named
@UseCase
public class UcManageRecipeImpl extends AbstractRecipeUc implements UcManageRecipe {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageRecipeImpl.class);

  @Override
  @RolesAllowed(PermissionConstants.DELETE_RECIPE)
  public void deleteRecipe(Long recipeId) {

    RecipeEntity recipe = getRecipeDao().find(recipeId);
    getRecipeDao().delete(recipe);
    LOG.debug("The recipe with id '{}' has been deleted.", recipeId);
  }

  @Override
  @RolesAllowed(PermissionConstants.SAVE_RECIPE)
  public RecipeEto saveRecipe(RecipeEto recipe) {

    Objects.requireNonNull(recipe, "recipe");

    RecipeEntity recipeEntity = getBeanMapper().map(recipe, RecipeEntity.class);

    if (recipeEntity.getRecipeIngredients() != null) {
      for (RecipeIngredientEntity recipeIngredientEntity : recipeEntity.getRecipeIngredients()) {
        IngredientEntity ingredient = recipeIngredientEntity.getIngredient();
        if (ingredient.getId() == null) {
          getIngredientDao().save(ingredient);
        }
      }
    }

    getRecipeDao().save(recipeEntity);
    LOG.debug("Recipe with id '{}' has been created.", recipeEntity.getId());
    return getBeanMapper().map(recipeEntity, RecipeEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.SAVE_RECIPE_PICTURE)
  public RecipeEto updateRecipePicture(Long recipeId, Blob blob, BinaryObjectEto binaryObjectEto) {
    RecipeEntity recipeEntity = getRecipeDao().findOne(recipeId);
    binaryObjectEto = getUcManageBinaryObject().saveBinaryObject(blob, binaryObjectEto);
    recipeEntity.setImageId(binaryObjectEto.getId());
    RecipeEntity save = getRecipeDao().save(recipeEntity);

    return getBeanMapper().map(save, RecipeEto.class);
  }

}
