package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.module.basic.common.api.to.AbstractCto;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;

import java.util.Set;

/**
 * Composite transport object of Recipe.
 */
public class RecipeCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private RecipeEto recipe;

  private BinaryObjectEto image;

  private Set<IngredientEto> ingredients;

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
   * @return image.
   */
  public BinaryObjectEto getImage() {
    return image;
  }

  /**
   * @param image the image to be set.
   */
  public void setImage(BinaryObjectEto image) {
    this.image = image;
  }

  /**
   * @return ingredients.
     */
  public Set<IngredientEto> getIngredients() {
    return ingredients;
  }

  /**
   * @param ingredients the ingredients to be set.
     */
  public void setIngredients(Set<IngredientEto> ingredients) {
    this.ingredients = ingredients;
  }
}
