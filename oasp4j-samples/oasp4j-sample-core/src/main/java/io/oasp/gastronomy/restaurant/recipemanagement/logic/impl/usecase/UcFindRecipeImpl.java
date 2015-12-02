package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl.usecase;

import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.RecipeEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindRecipe;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase.AbstractRecipeUc;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.CategoryEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategoryEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategorySearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Collections;

import javax.annotation.security.PermitAll;
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
  //RolesAllowed(PermissionConstants.FIND_RECIPE)
  @PermitAll
  public List<RecipeEto>  findRandomRecipes(int total, String language) {
    int totalTmp = total;
    RecipeSearchCriteriaTo rsc = new RecipeSearchCriteriaTo();

    rsc.setLanguage(language);
    PaginatedListTo<RecipeEntity> recipes = getRecipeDao().findRecipes(rsc);

    List<RecipeEntity> recipeList = recipes.getResult();
    Collections.shuffle(recipeList);

    if (recipeList.size() < total) {

      totalTmp = recipeList.size();

    }

    return getBeanMapper().mapList(recipeList.subList(0, totalTmp), RecipeEto.class);
  }

  @Override
  //RolesAllowed(PermissionConstants.FIND_RECIPE)
  @PermitAll
  public CategoryEto findCategory(Long id) {
    LOG.debug("Get Category with id {} from database.", id);
    return getBeanMapper().map(getCategoryDao().findOne(id), CategoryEto.class);
  }

}
