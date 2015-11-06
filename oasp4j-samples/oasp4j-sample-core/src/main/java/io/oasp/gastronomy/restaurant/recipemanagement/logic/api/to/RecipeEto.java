package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractEto;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.Recipe;

/**
 * Entity transport object of Recipe.
 */
public class RecipeEto extends AbstractEto implements Recipe {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private Money price;

  private Long imageId;

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {

    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getDescription() {

    return description;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Money getPrice() {

    return price;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPrice(Money price) {

    this.price = price;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getImageId() {

    return this.imageId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setImageId(Long imageId) {

    this.imageId = imageId;

  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
    result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    RecipeEto other = (RecipeEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!this.description.equals(other.description)) {
      return false;
    }
    if (this.price == null) {
      if (other.price != null) {
        return false;
      }
    } else if (!this.price.equals(other.price)) {
      return false;
    }
    return true;
  }
}
