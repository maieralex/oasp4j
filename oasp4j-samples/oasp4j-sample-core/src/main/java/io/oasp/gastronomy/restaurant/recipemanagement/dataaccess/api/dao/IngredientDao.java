package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.IngredientEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.IngredientSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import java.util.List;

/**
 *
 * Data access interface for Ingredient entities.
 *
 * Created by pascaldung on 02.12.15.
 */
public interface IngredientDao extends ApplicationDao<IngredientEntity> {

  /**
   * Finds the {@link IngredientEntity recipes} matching the given {@link IngredientSearchCriteriaTo}.
   *
   * @param criteria is the {@link IngredientSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link IngredientEntity} objects.
   */
  PaginatedListTo<IngredientEntity> findIngredients(IngredientSearchCriteriaTo criteria);

  /**
   * Finds all {@link IngredientEntity recipes}.
   * @return the {@link List} with all {@link IngredientEntity} objects.
   */
  List<IngredientEntity> findAllIngredients();
}
