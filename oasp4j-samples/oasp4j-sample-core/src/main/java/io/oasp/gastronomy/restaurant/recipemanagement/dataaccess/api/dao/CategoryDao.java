package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.CategoryEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategorySearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import java.util.List;

/**
 * Data access interface for Category entities.
 */
public interface CategoryDao extends ApplicationDao<CategoryEntity> {

  /**
   * Finds the {@link CategoryEntity categories} matching the given {@link CategorySearchCriteriaTo}.
   *
   * @param criteria is the {@link CategorySearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link CategoryEntity} objects.
   */
  PaginatedListTo<CategoryEntity> findCategories(CategorySearchCriteriaTo criteria);

  /**
   * Finds all {@link CategoryEntity categories}.
   * @return the {@link List} with all {@link CategoryEntity} objects.
   */
  List<CategoryEntity> findAllCategories();


}
