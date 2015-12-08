package io.oasp.gastronomy.restaurant.recipemanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;

/**
 * This is the interface for a {@link Recipe} of the restaurant.
 *
 * @author pascaldung
 */
public interface Recipe extends ApplicationEntity {

  /**
   * @return the name of a recipe
   */
  String getName();

  /**
   * @param name set new name of a recipe
   */
  void setName(String name);

  /**
   * @return the description of a recipe
   */
  String getDescription();

  /**
   * @param description set a new description of a recipe
   */
  void setDescription(String description);

  /**
   * @return the language of a recipe
   */
  String getLanguage();

  /**
   * @param language set a new language of a recipe
   */
  void setLanguage(String language);

  /**
   * @return the price of a recipe
   */
  Money getPrice();

  /**
   * @param price set a new price of a recipe
   */
  void setPrice(Money price);

  /**
   * @return the image ID of a recipe
   */
  Long getImageId();

  /**
   * @param imageId the image ID of a recipe
   */
  void setImageId(Long imageId);

  /**
   * @return rating return the actual rating of a recipe.
   */
  public Integer getRating();

  /**
   * @param rating set the actual rating of a recipe.
   */
  public void setRating(Integer rating);

}
