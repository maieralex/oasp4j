package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase;

import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.IngredientEto;

import java.util.List;

/**
 * Interface of UcFindIngredient to centralize documentation and signatures of methods.
 * @author Guided Project TH Koeln
 * @version 1.0
 */
public interface UcFindIngredient {

  /**
   * Retuns a {@link List} of all stored {@link IngredientEto}
   *
   * @return all stored IngredientEto
   */
  List<IngredientEto> findAllIngredients();

}
