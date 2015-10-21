package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl.usecase;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.RecipeEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcManageRecipe;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase.AbstractRecipeUc;

/**
 * Use case implementation for modifying and deleting Recipes
 */
@Named
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

    // initialize, validate recipeEntity here if necessary

    getRecipeDao().save(recipeEntity);
    LOG.debug("Recipe with id '{}' has been created.", recipeEntity.getId());
    return getBeanMapper().map(recipeEntity, RecipeEto.class);
  }

}
