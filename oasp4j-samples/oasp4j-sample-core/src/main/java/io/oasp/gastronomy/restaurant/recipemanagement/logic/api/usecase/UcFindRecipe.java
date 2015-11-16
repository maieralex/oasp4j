package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase;

import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import java.util.List;

public interface UcFindRecipe {

  /**
	 * Returns a Recipe by its id 'id'.
	 *
	 * @param id The id 'id' of the Recipe.
	 * @return The {@link RecipeEto} with id 'id'
	 */
	RecipeEto findRecipe(Long id);

  /**
	 * Returns a paginated list of Recipes matching the search criteria.
	 *
	 * @param criteria the {@link RecipeSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link RecipeEto}s.
	 */
	PaginatedListTo<RecipeEto> findRecipeEtos(RecipeSearchCriteriaTo criteria);

  /**
   * Returns a random list of Recipes matching the search criteria.
   *
   * @param criteria the {@link RecipeSearchCriteriaTo}.
   * @return the {@link List} of matching {@link RecipeEto}s.
   */
  PaginatedListTo<RecipeEto> findRandomRecipeEtos(RecipeSearchCriteriaTo criteria);

}
