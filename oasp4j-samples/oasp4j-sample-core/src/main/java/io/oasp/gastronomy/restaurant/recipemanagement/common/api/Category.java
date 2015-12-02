package io.oasp.gastronomy.restaurant.recipemanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;

/**
 * This is the interface for a {@link Category} of the recipe.
 *
 */
public interface Category extends ApplicationEntity {

  /**
   * @return the name of a {@link CategoryEto}
   */
  String getName();

  /**
   * @param name set new name of a {@link CategoryEto}
   */
  void setName(String name);

  /**
   * @return the language of a {@link CategoryEto}
   */
  String getLanguage();

  /**
   * @param language set a new language of a {@link CategoryEto}
   */
  void setLanguage(String language);

}
