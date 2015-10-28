package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.BinaryObject;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

import java.sql.Blob;

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

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getDescription() {

    return description;
  }

  public void setDescription(String description) {

    this.description = description;
  }

  public Money getPrice() {

    return price;
  }

  public void setPrice(Money price) {

    this.price = price;
  }

  public Long getImageId() {

    return this.imageId;
  }

  public void setImageId(Long imageId) {

    this.imageId = imageId;
  }

}
