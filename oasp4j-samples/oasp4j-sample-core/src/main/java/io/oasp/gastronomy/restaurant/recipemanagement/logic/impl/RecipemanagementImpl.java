package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.general.logic.base.AbstractComponentFacade;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.RecipeEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao.RecipeDao;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.Recipemanagement;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindRecipe;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcManageRecipe;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation class for {@link Recipemanagement}.
 *
 * @author Pascal
 * @since dev
 */
@Named
public class RecipemanagementImpl extends AbstractComponentFacade implements Recipemanagement {

  private static final Logger LOG = LoggerFactory.getLogger(RecipemanagementImpl.class);

  /**
   * @see #setRecipeDao(RecipeDao)
   */
  private RecipeDao recipeDao;

  private UcFindRecipe ucFindRecipe;

  private UcManageRecipe ucManageRecipe;

  /**
   * The constructor.
   */
  public RecipemanagementImpl() {

    super();
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_RECIPE)
  public RecipeEto findRecipe(Long id) {

    LOG.debug("Get RecipeEto with id '{}' from database.", id);
    return getBeanMapper().map(getRecipeDao().findOne(id), RecipeEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_RECIPE)
  public PaginatedListTo<RecipeEto> findRecipeEtos(RecipeSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<RecipeEntity> recipes = getRecipeDao().findRecipes(criteria);
    return mapPaginatedEntityList(recipes, RecipeEto.class);
  }

  @Override
  public void deleteRecipe(Long recipeId) {

    getRecipeDao().delete(recipeId);
  }

  @Override
  public RecipeEto saveRecipe(RecipeEto recipe) {

    Objects.requireNonNull(recipe, "recipe");

    if ((recipe.getName() == null) && (recipe.getDescription() == null) && (recipe.getPrice() == null)) {
      throw new IllegalArgumentException("The recipe cannot be empty");
    } else {
      RecipeEntity persistedRecipe = getRecipeDao().save(getBeanMapper().map(recipe, RecipeEntity.class));
      return getBeanMapper().map(persistedRecipe, RecipeEto.class);
    }
  }

  /**
   * Sets the field 'ucFindRecipe'.
   *
   * @param ucFindRecipe New value for ucFindRecipe
   */
  @Inject
  public void setUcFindRecipe(UcFindRecipe ucFindRecipe) {

    this.ucFindRecipe = ucFindRecipe;
  }

  /**
   * Sets the field 'ucManageRecipe'.
   *
   * @param ucManageRecipe New value for ucManageRecipe
   */
  @Inject
  public void setUcManageRecipe(UcManageRecipe ucManageRecipe) {

    this.ucManageRecipe = ucManageRecipe;
  }

  /**
   * @return recipeDao
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
