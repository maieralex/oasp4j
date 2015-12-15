package io.oasp.gastronomy.restaurant.recipemanagement.logic.api;

import io.oasp.gastronomy.restaurant.general.logic.base.UcManageBinaryObject;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindIngredient;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindRecipe;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcManageRecipe;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindCategory;

/**
 * Interface for Recipemanagement component.
 */
public interface Recipemanagement extends UcFindRecipe, UcManageRecipe, UcManageBinaryObject, UcFindIngredient, UcFindCategory {

}
