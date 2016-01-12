package io.oasp.gastronomy.restaurant.recipemanagement.common.api;

/**
 * Created by pascaldung on 01.12.15.
 */
public interface Ingredient {

  /**
   *
   * @return id of the ingredient.
     */
  Long getId();

  /**
   *
   * @param id new id of the ingredient.
     */
  void setId(Long id);

  /**
   * Returns the name of this ingredient.
   *
   * @return name the name of the ingredient.
   */
  String getName();

  /**
   * Sets the name of this recipe.
   *
   * @param name the name of this special.
   */
  void setName(String name);
}
