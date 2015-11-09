package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractCto;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;

/**
 * Composite transport object of Recipe.
 */
public class RecipeCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private RecipeEto recipe;

  private BinaryObjectEto image;

  /**
   * @return recipe
   */
  public RecipeEto getRecipe() {

    return recipe;
  }

  /**
   * @param recipe the recipe to be set
   */
  public void setRecipe(RecipeEto recipe) {

    this.recipe = recipe;
  }

  /**
   * @return image
   */
  public BinaryObjectEto getImage() {
    return image;
  }

  /**
   * @param image the image to be set
   */
  public void setImage(BinaryObjectEto image) {
    this.image = image;
  }
}
