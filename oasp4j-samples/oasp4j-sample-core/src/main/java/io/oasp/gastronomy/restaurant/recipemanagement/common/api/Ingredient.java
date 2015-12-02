package io.oasp.gastronomy.restaurant.recipemanagement.common.api;

/**
 * Created by pascaldung on 01.12.15.
 */
public interface Ingredient {

  /**
   * Returns the name of this ingredient.
   *
   * @return name the name of the ingredient.
   */
  public String getName();

  /**
   * Sets the name of this recipe.
   *
   * @param name the name of this special.
   */
  public void setName(String name);
}
