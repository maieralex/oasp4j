package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.gastronomy.restaurant.recipemanagement.common.api.Category}s.
 *
 */
public class CategorySearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String language;

  /**
   * The constructor.
   */
  public CategorySearchCriteriaTo() {

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
   *
   * @return language return the language.
     */
  public String getLanguage() {
    return language;
  }

  /**
   *
   * @param language set the language
     */
  public void setLanguage(String language) {
    this.language = language;
  }


}
