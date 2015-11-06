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
   * @return the name of a {@link RecipeEto}
   */
  String getName();

  /**
   * @param name set new name of a {@link RecipeEto}
   */
  void setName(String name);

  /**
   * @return the description of a {@link RecipeEto}
   */
  String getDescription();

  /**
   * @param description set a new description of a {@link RecipeEto}
   */
  void setDescription(String description);

  /**
   * @return the price of a {@link RecipeEto}
   */
  Money getPrice();

  /**
   * @param price set a new price of a {@link RecipeEto}
   */
  void setPrice(Money price);

  /**
   * @return the image ID of a {@link RecipeEto}
   */
  Long getImageId();

  /**
   * @param imageId the image ID of a {@link RecipeEto}
   */
  void setImageId(Long imageId);

}
