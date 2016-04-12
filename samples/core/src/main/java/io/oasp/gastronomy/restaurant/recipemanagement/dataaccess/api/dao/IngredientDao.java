package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.IngredientEntity;

import java.util.List;

/**
 * Data access interface for Ingredient entities.
 *
 * Created by pascaldung on 02.12.15.
 */
public interface IngredientDao extends ApplicationDao<IngredientEntity> {

  /**
   * Finds all {@link IngredientEntity recipes}.
   * @return the {@link List} with all {@link IngredientEntity} objects.
   */
  List<IngredientEntity> findAllIngredients();
}
