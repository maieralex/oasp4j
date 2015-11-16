package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl.usecase;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.Recipe;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.RecipeEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindRecipe;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase.AbstractRecipeUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

/**
 * Use case implementation for searching, filtering and getting Recipes.
 */
@Named
@UseCase
public class UcFindRecipeImpl extends AbstractRecipeUc implements UcFindRecipe {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindRecipeImpl.class);

  @Override
  //RolesAllowed(PermissionConstants.FIND_RECIPE)
  @PermitAll
  public RecipeEto findRecipe(Long id) {

    LOG.debug("Get Recipe with id {} from database.", id);
    return getBeanMapper().map(getRecipeDao().findOne(id), RecipeEto.class);
  }

  @Override
  //@RolesAllowed(PermissionConstants.FIND_RECIPE)
  @PermitAll
  public PaginatedListTo<RecipeEto> findRecipeEtos(RecipeSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<RecipeEntity> recipes = getRecipeDao().findRecipes(criteria);
    return mapPaginatedEntityList(recipes, RecipeEto.class);
  }

  @Override
  //@RolesAllowed(PermissionConstants.FIND_RECIPE)
  @PermitAll
  public PaginatedListTo<RecipeEto> findRandomRecipeEtos(RecipeSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    //Gets all RecipesEntities which map to the criteria
    PaginatedListTo<RecipeEntity> recipes = getRecipeDao().findRecipes(criteria);


    //Creates an (Random)ArrayList from recipes.getResult()
    List<RecipeEntity> randomList = new ArrayList<RecipeEntity>();
    for (RecipeEntity recipeEntityItem: recipes.getResult()) {
      randomList.add(recipeEntityItem);
    }

    //Randomize
    Collections.shuffle(randomList);

    //Creates and returns new PaginatedList with the RandomArrayList
    PaginatedListTo<RecipeEntity> randomRecipesList =
      new PaginatedListTo<RecipeEntity>(randomList, recipes.getPagination());

    return mapPaginatedEntityList(randomRecipesList, RecipeEto.class);
  }

}
