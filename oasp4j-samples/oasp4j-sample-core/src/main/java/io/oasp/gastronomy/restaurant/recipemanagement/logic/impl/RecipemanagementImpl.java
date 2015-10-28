package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.BinaryObjectDao;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeCto;
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

  private BinaryObjectDao blobDao;

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
    return ucFindRecipe.findRecipe(id);
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_RECIPE)
  public PaginatedListTo<RecipeEto> findRecipeEtos(RecipeSearchCriteriaTo criteria) {
    return ucFindRecipe.findRecipeEtos(criteria);
  }

  @Override
  public RecipeCto findRecipeCto(Long id) {
    return ucFindRecipe.findRecipeCto(id);
  }

  @Override
  public PaginatedListTo<RecipeCto> findRecipeCtos(RecipeSearchCriteriaTo criteria) {
    return ucFindRecipe.findRecipeCtos(criteria);
  }

  @Override
  @RolesAllowed(PermissionConstants.DELETE_RECIPE)
  public void deleteRecipe(Long recipeId) {
    ucManageRecipe.deleteRecipe(recipeId);
  }

  @Override
  @RolesAllowed(PermissionConstants.SAVE_RECIPE)
  public RecipeEto saveRecipe(RecipeEto recipe) {
    return ucManageRecipe.saveRecipe(recipe);
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

  public BinaryObjectDao getBlobDao() {
    return this.blobDao;
  }

}
