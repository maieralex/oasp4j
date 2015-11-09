package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.gastronomy.restaurant.recipemanagement.common.api.Recipe}s.
 *
 */
public class RecipeSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private Money price;

  private Long imageId;

  /**
   * The constructor.
   */
  public RecipeSearchCriteriaTo() {

    super();
  }

  /**
   * @return name
   */
  public String getName() {

    return name;
  }

  /**
   * @param name name to be set
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return description
   */
  public String getDescription() {

    return description;
  }

  /**
   * @param description description to be set
   */
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return price
   */
  public Money getPrice() {

    return price;
  }

  /**
   * @param price price to be set
   */
  public void setPrice(Money price) {

    this.price = price;
  }

  /**
   * @return ImageId
   */
  public Long getImageId() {

    return this.imageId;
  }

  /**
   * @param imageId imageId to be set
   */
  public void setImageId(Long imageId) {

    this.imageId = imageId;
  }

}
