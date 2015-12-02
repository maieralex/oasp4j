package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.Category;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The {@link ApplicationPersistenceEntity persistent entity} for a category.
 */
@Entity(name = "Category")
@Table(name = "Category")
public class CategoryEntity extends ApplicationPersistenceEntity implements Category {

  private static final long serialVersionUID = 1L;

  private String name;

  private String language;

  /**
   * Returns the name of this category.
   *
   * @return name the name of the category.
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * Sets the name of this category.
   *
   * @param name the name of this category.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * Returns the language of this category.
   *
   * @return language the language of the category.
   */
  @Override
  public String getLanguage() {

    return this.language;
  }

  /**
   * Sets the language of this category.
   *
   * @param language the language of this category.
   */
  @Override
  public void setLanguage(String language) {

    this.language = language;
  }

}
