package io.oasp.gastronomy.restaurant.recipemanagement.logic.api;

import io.oasp.gastronomy.restaurant.general.logic.base.UcManageBinaryObject;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.*;

/**
 * Interface for Recipemanagement component.
 */
public interface Recipemanagement extends UcFindRecipe, UcManageRecipe,
  UcManageBinaryObject, UcFindIngredient, UcFindCategory, UcCalculatePrice {

}
