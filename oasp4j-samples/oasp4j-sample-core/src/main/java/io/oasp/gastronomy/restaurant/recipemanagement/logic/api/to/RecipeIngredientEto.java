package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

/**
 * Created by pascaldung on 15.12.15.
 */
public class RecipeIngredientEto {

  Long recipeId;

  IngredientEto ingredient;

  String measuringUnit;

  Double amount;

  Integer position;

  public Long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(Long recipeId) {
    this.recipeId = recipeId;
  }

  public IngredientEto getIngredient() {
    return ingredient;
  }

  public void setIngredient(IngredientEto ingredient) {
    this.ingredient = ingredient;
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
