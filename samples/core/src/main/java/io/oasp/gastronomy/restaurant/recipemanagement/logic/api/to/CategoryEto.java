package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.module.basic.common.api.to.AbstractEto;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.Category;

/**
 * Entity transport object of Category.
 */
public class CategoryEto extends AbstractEto implements Category {

  private static final long serialVersionUID = 1L;

  private String name;

  private String language;

  private long languageId;

  /**
   * The constructor.
   */
  public CategoryEto() {

    super();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public String getLanguage() {

    return this.language;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public void setLanguage(String language) {

    this.language = language;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public long getLanguageId() {

    return this.languageId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setLanguageId(long languageId) {

    this.languageId = languageId;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
    CategoryEto other = (CategoryEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    return true;
  }
}
