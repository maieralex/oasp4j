package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.Ingredient;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@link ApplicationPersistenceEntity Entity} that represents the {@link Ingredient} related to one or multiple
 * {@Recipe recipes}.
 *
 *
 * Created by pascaldung on 01.12.15.
 */
@Entity(name = "Ingredient")
@Table(name = "Ingredient")
public class IngredientEntity extends ApplicationPersistenceEntity implements Ingredient {

  private static final long serialVersionUID = 1L;

  private String name;

  /**
   * Returns the name of this ingredient.
   *
   * @return name the name of the ingredient.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of this recipe.
   *
   * @param name the name of this special.
   */
  public void setName(String name) {
    this.name = name;
  }
}
