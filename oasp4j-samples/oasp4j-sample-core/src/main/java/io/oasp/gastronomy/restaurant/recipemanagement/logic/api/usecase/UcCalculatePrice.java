package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeIngredientEto;

import java.util.Set;

/**
 * Created by pascaldung on 13.01.16.
 */
public interface UcCalculatePrice {

  /**
   * Calculates the price for a set of given ingredients.
   *
   * @param ingredients ingredients for the price calculation
   * @return summed up price for the given ingredients
   */
  Money getSummedPrice (Set<RecipeIngredientEto> ingredients);
}
