package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Recipe
 */
public class RecipeCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private RecipeEto recipe;

  public RecipeEto getRecipe() {

    return recipe;
  }

  public void setRecipe(RecipeEto recipe) {

    this.recipe = recipe;
  }

}
