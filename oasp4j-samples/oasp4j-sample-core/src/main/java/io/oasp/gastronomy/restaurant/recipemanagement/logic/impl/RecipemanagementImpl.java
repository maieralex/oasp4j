package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl;


import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;
import io.oasp.gastronomy.restaurant.general.logic.base.AbstractComponentFacade;
import io.oasp.gastronomy.restaurant.general.logic.base.UcManageBinaryObject;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.Recipemanagement;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategoryEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.IngredientEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindCategory;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindIngredient;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindRecipe;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcManageRecipe;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Blob;
import java.util.List;

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

  private UcFindCategory ucFindCategory;

  private UcManageBinaryObject ucManageBinaryObject;

  private UcFindIngredient ucFindIngredient;

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
  @SuppressWarnings("SpringJavaAutowiringInspection")
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
  @SuppressWarnings("SpringJavaAutowiringInspection")
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
  @SuppressWarnings("SpringJavaAutowiringInspection")
  public void setUcManageBinaryObject(UcManageBinaryObject ucManageBinaryObject) {
    this.ucManageBinaryObject = ucManageBinaryObject;
  }

  /**
   * Sets the field 'ucFindIngredient'.
   *
   * @param ucFindIngredient New value for ucFindIngredient
   */
  @Inject
  @UseCase
  @SuppressWarnings("SpringJavaAutowiringInspection")
  public void setUcManageBinaryObject(UcFindIngredient ucFindIngredient) {
    this.ucFindIngredient = ucFindIngredient;
  }


  /**
   * Sets the field 'ucFindCategory'.
   *
   * @param ucFindCategory New value for ucFindCategory
   */
  @Inject
  @UseCase
  @SuppressWarnings("SpringJavaAutowiringInspection")
  public void setUcFindCategory(UcFindCategory ucFindCategory) {

    this.ucFindCategory = ucFindCategory;
  }

  @Override
  public RecipeEto findRecipe(Long id) {
    return ucFindRecipe.findRecipe(id);
  }

  @Override
  public CategoryEto findCategory(Long id) {
    return ucFindCategory.findCategory(id);
  }

  @Override
  public List<CategoryEto> findAllCategories() {

    return ucFindCategory.findAllCategories();
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

  @Override
  public List<RecipeEto> findRandomRecipes(int id, String language) {
    return ucFindRecipe.findRandomRecipes(id, language);
  }

  @Override
  public List<IngredientEto> findAllIngredients() {

    return ucFindIngredient.findAllIngredients();
  }
}
