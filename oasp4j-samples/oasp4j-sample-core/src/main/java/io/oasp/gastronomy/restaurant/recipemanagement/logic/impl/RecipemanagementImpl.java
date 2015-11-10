package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;
import io.oasp.gastronomy.restaurant.general.logic.base.AbstractComponentFacade;
import io.oasp.gastronomy.restaurant.general.logic.base.UcManageBinaryObject;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.Recipemanagement;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindRecipe;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcManageRecipe;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Blob;

/**
 * Implementation class for {@link Recipemanagement}.
 *
 * @author Pascal
 * @since dev
 */
@Named
public class RecipemanagementImpl extends AbstractComponentFacade implements Recipemanagement {

  private UcFindRecipe ucFindRecipe;

  private UcManageRecipe ucManageRecipe;

  private UcManageBinaryObject ucManageBinaryObject;

  /**
   * The constructor.
   */
  public RecipemanagementImpl() {

    super();
  }

  /**
   * Sets the field 'ucFindRecipe'.
   *
   * @param ucFindRecipe New value for ucFindRecipe
   */
  @Inject
  @UseCase
  public void setUcFindRecipe(UcFindRecipe ucFindRecipe) {

    this.ucFindRecipe = ucFindRecipe;
  }

  /**
   * Sets the field 'ucManageRecipe'.
   *
   * @param ucManageRecipe New value for ucManageRecipe
   */
  @Inject
  @UseCase
  public void setUcManageRecipe(UcManageRecipe ucManageRecipe) {

    this.ucManageRecipe = ucManageRecipe;
  }

  /**
   * Sets the field 'ucManageBinaryObject'.
   *
   * @param ucManageBinaryObject New value for recipeDao
   */
  @Inject
  @UseCase
  public void setUcManageBinaryObject(UcManageBinaryObject ucManageBinaryObject) {
    this.ucManageBinaryObject = ucManageBinaryObject;
  }

  @Override
  public RecipeEto findRecipe(Long id) {
    return ucFindRecipe.findRecipe(id);
  }

  @Override
  public PaginatedListTo<RecipeEto> findRecipeEtos(RecipeSearchCriteriaTo criteria) {
    return ucFindRecipe.findRecipeEtos(criteria);
  }

  @Override
  public void deleteRecipe(Long recipeId) {
    ucManageRecipe.deleteRecipe(recipeId);
  }

  @Override
  public RecipeEto saveRecipe(RecipeEto recipe) {
    return ucManageRecipe.saveRecipe(recipe);
  }

  @Override
  public RecipeEto updateRecipePicture(Long recipeId, Blob blob, BinaryObjectEto binaryObjectEto) {
    return ucManageRecipe.updateRecipePicture(recipeId, blob, binaryObjectEto);
  }

  @Override
  public BinaryObjectEto saveBinaryObject(Blob data, BinaryObjectEto binaryObjectEto) {
    return ucManageBinaryObject.saveBinaryObject(data, binaryObjectEto);
  }

  @Override
  public void deleteBinaryObject(Long binaryObjectId) {
    ucManageBinaryObject.deleteBinaryObject(binaryObjectId);
  }

  @Override
  public BinaryObjectEto findBinaryObject(Long binaryObjectId) {
    return ucManageBinaryObject.findBinaryObject(binaryObjectId);
  }

  @Override
  public Blob getBinaryObjectBlob(Long binaryObjectId) {
    return ucManageBinaryObject.getBinaryObjectBlob(binaryObjectId);
  }
}
