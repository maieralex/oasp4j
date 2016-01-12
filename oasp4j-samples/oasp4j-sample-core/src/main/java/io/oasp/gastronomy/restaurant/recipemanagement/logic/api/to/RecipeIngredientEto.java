package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractEto;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.RecipeIngredient;

/**
 * Created by pascaldung on 15.12.15.
 */
public class RecipeIngredientEto extends AbstractEto implements RecipeIngredient{

  private Long recipeId;

  private IngredientEto ingredient;

  private String measuringUnit;

  private Double amount;

  private Integer position;

  public IngredientEto getIngredient() {
    return ingredient;
  }

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

  public Long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(Long recipeId) {
    this.recipeId = recipeId;
  }

  public String getMeasuringUnit() {
    return measuringUnit;
  }

  public void setMeasuringUnit(String measuringUnit) {
    this.measuringUnit = measuringUnit;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

}
