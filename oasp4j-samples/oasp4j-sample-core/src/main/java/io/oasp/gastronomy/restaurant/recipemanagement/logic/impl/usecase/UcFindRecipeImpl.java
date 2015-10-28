package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl.usecase;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.BinaryObjectDao;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeCto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.RecipeEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindRecipe;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase.AbstractRecipeUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Recipes
 */
@Named
public class UcFindRecipeImpl extends AbstractRecipeUc implements UcFindRecipe {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindRecipeImpl.class);

  @Override
  @RolesAllowed(PermissionConstants.FIND_RECIPE)
  public RecipeEto findRecipe(Long id) {

    LOG.debug("Get Recipe with id {} from database.", id);
    return getBeanMapper().map(getRecipeDao().findOne(id), RecipeEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_RECIPE)
  public PaginatedListTo<RecipeEto> findRecipeEtos(RecipeSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<RecipeEntity> recipes = getRecipeDao().findRecipes(criteria);
    return mapPaginatedEntityList(recipes, RecipeEto.class);
  }

  public RecipeCto findRecipeCto(Long id) {

    RecipeCto result = new RecipeCto();

    RecipeEto recipe = findRecipe(id);

    if(recipe == null) return null;

    result.setRecipe(recipe);

    if(recipe.getImageId() != null)
      result.setImage(findImage(recipe.getImageId()));

    return result;
  }

  @Override
  public PaginatedListTo<RecipeCto> findRecipeCtos(RecipeSearchCriteriaTo criteria) {
    return null;
  }

  private BinaryObjectEto findImage(Long imageId) {

    return getBeanMapper().map(getBlobDao().findOne(imageId), BinaryObjectEto.class);
  }

}
