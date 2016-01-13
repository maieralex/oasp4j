package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase;

import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategoryEto;

import java.util.List;

/**
 * Interface of UcFindCategory to centralize documentation and signatures of methods.
 * @author Guided Project TH Koeln
 * @version 1.0
 */
public interface UcFindCategory {

  /**
   * Returns a {@link List} of all stored {@link CategoryEto}.
   *
   * @return all stored CategoryEto
   */
  List<CategoryEto> findAllCategories();

  /**
   * Returns a Category by its id 'id'.
   *
   * @param id The id 'id' of the Category.
   * @return The {@link CategoryEto} with id 'id'
   */
  CategoryEto findCategory(Long id);

  /**
   * Returns a {@link List} of all stored {@link CategoryEto} filtered by language.
   *
   * @param language The language 'language' of the Category.
   * @return all stored CategoryEto filtered by language
   */
  List<CategoryEto> findCategories(String language);
}
