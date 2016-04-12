package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.module.basic.common.api.to.AbstractEto;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.RecipeIngredient;

/**
 * Created by pascaldung on 15.12.15.
 */
public class RecipeIngredientEto extends AbstractEto implements RecipeIngredient {

  private Long recipeId;

  private IngredientEto ingredient;

  private String measuringUnit;

  private Double amount;

  private Integer position;

  /**
   *
   * @return ETO of the ingredient.
     */
  public IngredientEto getIngredient() {
    return ingredient;
  }

  /**
   *
   * @param ingredient new ETO of the ingredient.
     */
  public void setIngredient(IngredientEto ingredient) {
    this.ingredient = ingredient;
  }

  @Override
  public Long getIngredientId() {
    if (ingredient == null) {
      return null;
    }

    return ingredient.getId();
  }

  /**
   *
   * @param ingredientId new Id to be set for the recipe.
   */
  @Override
  public void setIngredientId(Long ingredientId) {
    if (ingredientId == null) {
      ingredient = null;
    } else {
      IngredientEto ingredientEto = new IngredientEto();
      ingredientEto.setId(ingredientId);
      ingredient = ingredientEto;
    }
  }

  /**
   *
   * @return id of the recipe.
   */
  public Long getRecipeId() {
    return recipeId;
  }

  /**
   *
   * @param recipeId new Id to be set for the recipe.
   */
  public void setRecipeId(Long recipeId) {
    this.recipeId = recipeId;
  }

  /**
   *
   * @return Measuring Unit for the ingredient in the recipe.
   */
  public String getMeasuringUnit() {
    return measuringUnit;
  }

  /**
   *
   * @param measuringUnit set new Measuring Unit for the ingredient in the recipe.
   */
  public void setMeasuringUnit(String measuringUnit) {
    this.measuringUnit = measuringUnit;
  }

  /**
   *
   * @return Amount of the ingredient in the recipe.
   */
  public Double getAmount() {
    return amount;
  }

  /**
   *
   * @param amount set new Amount of the ingredient in the recipe.
   */
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  /**
   *
   * @return Position of the ingredient in the recipe.
   */
  public Integer getPosition() {
    return position;
  }

  /**
   *
   * @param position set new Position for the ingredient in the recipe.
   */
  public void setPosition(Integer position) {
    this.position = position;
  }

  /**
   * Overwrite default behavior because we are able to add multiple new (id is null) ingredients.
   *
   * @param obj
   * @return
     */
  @Override
  public boolean equals(Object obj) {

    if (getId() == null) {
      return false;
    } else {
      return super.equals(obj);
    }
  }

}
