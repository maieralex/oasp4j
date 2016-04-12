package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Category.
 */
public class CategoryCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private CategoryEto category;

  /**
   * @return category
   */
  public CategoryEto getCategory() {

    return category;
  }

  /**
   * @param category the category to be set
   */
  public void setCategory(CategoryEto category) {

    this.category = category;
  }
}
