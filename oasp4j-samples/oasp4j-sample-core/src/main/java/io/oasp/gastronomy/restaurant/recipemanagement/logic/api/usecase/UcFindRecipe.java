package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase;

import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategoryEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategorySearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import java.util.List;

/**
 * Interface of UcFindRecipe to centralize documentation and signatures of methods.
 * @author Guided Project TH Koeln
 * @version 1.0
 */
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
   * Returns a Recipe by its id 'id'.
   *
   * @param total     The number of max items for the RecipeList
   * @param language  The language of the items for the RecipeList
   * @return The {@link RecipeEto} with id 'id'
   */
  List<RecipeEto>  findRandomRecipes(int total, String language);

}
