package io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.BinaryObjectDao;
import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.gastronomy.restaurant.general.logic.base.AbstractUc;
import io.oasp.gastronomy.restaurant.general.logic.base.UcManageBinaryObject;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao.RecipeDao;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao.CategoryDao;

import javax.inject.Inject;

/**
 * Abstract use case for Recipes, which provides access to the commonly necessary data access objects.
 */
public class AbstractRecipeUc extends AbstractUc {

  /**
   * @see #getRecipeDao()
   */
  private RecipeDao recipeDao;
  private CategoryDao categoryDao;

  /**
   * @see #getBinaryObjectDao()
   */
  private BinaryObjectDao binaryObjectDao;

  /**
   * @see #getUcManageBinaryObject()
   */
  private UcManageBinaryObject ucManageBinaryObject;

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

  /**
   * Returns the field 'categoryDao'.
   *
   * @return the {@link CategoryDao} instance.
   */
  public CategoryDao getCategoryDao() {

    return this.categoryDao;
  }

  /**
   * Sets the field 'categoryDao'.
   *
   * @param categoryDao New value for categoryDao
   */
  @Inject
  public void setCategoryDao(CategoryDao categoryDao) {

    this.categoryDao = categoryDao;
  }

  /**
   * Returns the field 'binaryObjectDao'.
   *
   * @return the {@link BinaryObjectDao} instance.
   */
  @Inject
  @UseCase
  public BinaryObjectDao getBinaryObjectDao() {

    return this.binaryObjectDao;
  }

  /**
   * Sets the field 'binaryObjectDao'.
   *
   * @param binaryObjectDao New value for binaryObjectDao
   */
  @Inject
  public void setBinaryObjectDao(BinaryObjectDao binaryObjectDao) {
    this.binaryObjectDao = binaryObjectDao;
  }

  /**
   * Returns the field 'ucManageBinaryObject'.
   *
   * @return the {@link UcManageBinaryObject} instance.
   */
  public UcManageBinaryObject getUcManageBinaryObject() {
    return ucManageBinaryObject;
  }

  /**
   * Sets the field 'ucManageBinaryObject'.
   *
   * @param ucManageBinaryObject New value for ucManageBinaryObject
   */
  @Inject
  @UseCase
  @SuppressWarnings("SpringJavaAutowiringInspection")
  public void setUcManageBinaryObject(UcManageBinaryObject ucManageBinaryObject) {
    this.ucManageBinaryObject = ucManageBinaryObject;
  }
}
