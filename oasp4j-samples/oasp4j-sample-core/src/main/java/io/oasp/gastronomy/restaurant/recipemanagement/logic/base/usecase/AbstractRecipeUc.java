package io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase;

import javax.inject.Inject;

import io.oasp.gastronomy.restaurant.general.logic.base.AbstractUc;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao.RecipeDao;

/**
 * Abstract use case for Recipes, which provides access to the commonly necessary data access objects.
 */
public class AbstractRecipeUc extends AbstractUc {

  /**
   * @see #getRecipeDao()
   */
  private RecipeDao recipeDao;

  /**
   * Returns the field 'recipeDao'.
   * 
   * @return the {@link RecipeDao} instance.
   */
  public RecipeDao getRecipeDao() {

    return this.recipeDao;
  }

  /**
   * Sets the field 'recipeDao'.
   * 
   * @param recipeDao New value for recipeDao
   */
  @Inject
  public void setRecipeDao(RecipeDao recipeDao) {

    this.recipeDao = recipeDao;
  }

}
