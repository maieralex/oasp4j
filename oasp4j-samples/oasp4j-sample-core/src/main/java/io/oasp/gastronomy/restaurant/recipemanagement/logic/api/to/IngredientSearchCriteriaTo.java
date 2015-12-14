package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * Created by pascaldung on 02.12.15.
 */
public class IngredientSearchCriteriaTo extends SearchCriteriaTo {

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
