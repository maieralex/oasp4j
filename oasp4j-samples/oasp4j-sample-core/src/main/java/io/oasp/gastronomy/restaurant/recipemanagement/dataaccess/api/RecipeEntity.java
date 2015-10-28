package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.oasp.gastronomy.restaurant.general.common.api.BinaryObject;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.BinaryObjectEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.Recipe;

import java.sql.Blob;

/**
 * The {@link ApplicationPersistenceEntity persistent entity} for a recipe.
 *
 * @author pdung
 */
@Entity(name = "Recipe")
@Table(name = "Recipe")
public class RecipeEntity extends ApplicationPersistenceEntity implements Recipe {

  private String name;

  private String description;

  private Money price;

  private BinaryObjectEntity image;

  private static final long serialVersionUID = 1L;

  /**
   * Returns the name of this recipe.
   *
   * @return name the name of the recipe.
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * Sets the name of this recipe.
   *
   * @param name the name of this special.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * Returns the {@link Money price} for the recipe.
   *
   * @return price the {@link Money price} for the recipe.
   */
  @Override
  public Money getPrice() {

    return this.price;
  }

  /**
   * Sets the {@link Money price} for the recipe.
   *
   * @param price the {@link Money price} for the recipe.
   */
  @Override
  public void setPrice(Money price) {

    this.price = price;
  }

  @Override
  public Long getImageId() {
    if(this.image == null) return null;
    return this.image.getId();
  }

  @Override
  public void setImageId(Long imageId) {

    if(imageId == null) this.image = null;
    else {
      BinaryObjectEntity blob = new BinaryObjectEntity();
      blob.setId(imageId);
      this.image = blob;
    }

  }

  /**
   * Returns the Description of this recipe.
   *
   * @return description the Description for the recipe.
   */
  @Override
  public String getDescription() {

    return this.description;
  }

  /**
   * Sets the Description for this recipe.
   *
   * @param description the name for the recipe.
   */
  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * Returns the Image of this recipe.
   *
   * @return image the Image for the recipe.
   */
  public BinaryObjectEntity getImage() {

    return this.image;
  }

  /**
   * Sets the Image for this recipe.
   *
   * @param image the new image for the recipe.
   */
  public void setImage(BinaryObjectEntity image) {

    this.image = image;
  }

}