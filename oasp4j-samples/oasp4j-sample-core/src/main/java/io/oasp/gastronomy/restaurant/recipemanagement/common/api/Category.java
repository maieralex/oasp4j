package io.oasp.gastronomy.restaurant.recipemanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;

/**
 * This is the interface for a {@link Category} of the recipe.
 *
 */
public interface Category extends ApplicationEntity {

  /**
   * @return the name of a category
   */
  String getName();

  /**
   * @param name set new name of a category
   */
  void setName(String name);

  /**
   * @return the language of a category
   */
  String getLanguage();

  /**
   * @param language set a new language of a category
   */
  void setLanguage(String language);

  /**
   * @return the languageId of a category
   */
  public long getLanguageId();

  /**
   * @param languageId set new languageId of a category
   */
  public void setLanguageId(long languageId);
}
