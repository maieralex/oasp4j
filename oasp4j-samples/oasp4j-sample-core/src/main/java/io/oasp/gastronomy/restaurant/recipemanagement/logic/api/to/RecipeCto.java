package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractCto;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;

/**
 * Composite transport object of Recipe
 */
public class RecipeCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private RecipeEto recipe;

  private BinaryObjectEto image;

  public RecipeEto getRecipe() {

    return recipe;
  }

  public void setRecipe(RecipeEto recipe) {

    this.recipe = recipe;
  }

  public BinaryObjectEto getImage() {
    return image;
  }

  public void setImage(BinaryObjectEto image) {
    this.image = image;
  }
}
