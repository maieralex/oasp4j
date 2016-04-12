package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.RecipeEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import java.util.List;

/**
 * Data access interface for Recipe entities.
 */
public interface RecipeDao extends ApplicationDao<RecipeEntity> {

  /**
   * Finds the {@link RecipeEntity recipes} matching the given {@link RecipeSearchCriteriaTo}.
   *
   * @param criteria is the {@link RecipeSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link RecipeEntity} objects.
   */
  PaginatedListTo<RecipeEntity> findRecipes(RecipeSearchCriteriaTo criteria);

  /**
   * Finds all {@link RecipeEntity recipes}.
   * @return the {@link List} with all {@link RecipeEntity} objects.
   */
  List<RecipeEntity> findAllRecipes();


}
