package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.module.basic.common.api.to.AbstractEto;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.Ingredient;

/**
 * Created by pascaldung on 02.12.15.
 */
public class IngredientEto extends AbstractEto implements Ingredient {

  private String name;

  /**
   * Returns the name of this ingredient.
   *
   * @return name the name of the ingredient.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of this recipe.
   *
   * @param name the name of this special.
   */
  public void setName(String name) {
    this.name = name;
  }
}
