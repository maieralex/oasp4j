package io.oasp.gastronomy.restaurant.recipemanagement.common.api;

/**
 * Created by pascaldung on 01.12.15.
 */
public interface RecipeIngredient {

  /**
   *
   * @return id of the recipe.
     */
  Long getRecipeId();

  /**
   *
   * @param recipeId new Id to be set for the recipe.
     */
  void setRecipeId(Long recipeId);

  /**
   *
   * @return id of the ingredient.
     */
  Long getIngredientId();

  /**
   *
   * @param ingredientId new Id to be set for the recipe.
     */
  void setIngredientId(Long ingredientId);

  /**
   *
   * @return Measuring Unit for the ingredient in the recipe.
     */
  String getMeasuringUnit();

  /**
   *
   * @param measuringUnit set new Measuring Unit for the ingredient in the recipe.
     */
  void setMeasuringUnit(String measuringUnit);

  /**
   *
   * @return Amount of the ingredient in the recipe.
     */
  Double getAmount();

  /**
   *
   * @param amount set new Amount of the ingredient in the recipe.
     */
  void setAmount(Double amount);

  /**
   *
   * @return Position of the ingredient in the recipe.
     */
  Integer getPosition();

  /**
   *
   * @param position set new Position for the ingredient in the recipe.
     */
  void setPosition(Integer position);
}


