package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractEto;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.Recipe;

import java.util.Set;

/**
 * Entity transport object of Recipe.
 */
public class RecipeEto extends AbstractEto implements Recipe {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private String language;

  private Money price;

  private Long imageId;

  private String author;

  private String category;

  private Integer portions;

  private Set<RecipeIngredientEto> recipeIngredients;

  private String difficulty;

  private Integer prepTimeMinutes;

  private Integer cookTimeMinutes;

  private Long calories;

  private String cookingInstructions;

  private Integer rating;

  private Long categoryId;

  private CategoryEto categoryEntity;

  /**
   * The constructor.
   */
  public RecipeEto() {

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
   * {@inheritDoc}
   */
  @Override
  public String getDescription() {

    return this.description;
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

    return this.price;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPrice(Money price) {

    this.price = price;
  }

  /**
   *
   * @return A set of recipe ingredient ETOs.
     */
  public Set<RecipeIngredientEto> getRecipeIngredients() {

    return recipeIngredients;
  }

  /**
   *
   * @param recipeIngredients set new Set of recipe ingredient ETOs.
     */
  public void setRecipeIngredients(Set<RecipeIngredientEto> recipeIngredients) {
    
    this.recipeIngredients = recipeIngredients;
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
   *
   * {@inheritDoc}
   */
  public String getAuthor() {

    return this.author;
  }

  /**
   *
   * {@inheritDoc}
   */
  public void setAuthor(String author) {

    this.author = author;
  }

  /**
   *
   * {@inheritDoc}
   */
  public Integer getPortions() {

    return this.portions;
  }

  /**
   *
   * {@inheritDoc}
   */
  public void setPortions(Integer portions) {

    this.portions = portions;
  }

  /**
   *
   * {@inheritDoc}
   */
  public String getCategory() {

    return this.category;
  }

  /**
   *
   * {@inheritDoc}
   */
  public void setCategory(String category) {

    this.category = category;
  }

  /**
   *
   * {@inheritDoc}
   */
  public String getDifficulty() {

    return this.difficulty;
  }

  /**
   *
   * {@inheritDoc}
   */
  public void setDifficulty(String difficulty) {

    this.difficulty = difficulty;
  }

  /**
   *
   * {@inheritDoc}
   */
  public Integer getCookTimeMinutes() {

    return this.cookTimeMinutes;
  }

  /**
   *
   * {@inheritDoc}
   */
  public void setCookTimeMinutes(Integer cookTimeMinutes) {

    this.cookTimeMinutes = cookTimeMinutes;
  }

  /**
   *
   * {@inheritDoc}
   */
  public Integer getPrepTimeMinutes() {

    return this.prepTimeMinutes;
  }

  /**
   *
   * {@inheritDoc}
   */
  public void setPrepTimeMinutes(Integer prepTimeMinutes) {

    this.prepTimeMinutes = prepTimeMinutes;
  }

  /**
   *
   * {@inheritDoc}
   */
  public Long getCalories() {

    return this.calories;
  }

  /**
   *
   * {@inheritDoc}
   */
  public void setCalories(Long calories) {

    this.calories = calories;
  }

  /**
   *
   * {@inheritDoc}
   */
  public String getCookingInstructions() {

    return this.cookingInstructions;
  }

  /**
   *
   * {@inheritDoc}
   */
  public void setCookingInstructions(String cookingInstructions) {

    this.cookingInstructions = cookingInstructions;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer getRating() {

    return this.rating;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setRating(Integer rating) {

    this.rating = rating;
  }

  /**
   *
   * @return CategoryEntity.
     */
  public CategoryEto getCategoryEntity() {

    return this.categoryEntity;
  }

  /**
   * Sets the CategoryEntity of a Recipe.
   *
   * @param category new CategoryEntity
   */
  public void setCategoryEntity(CategoryEto category) {

    this.categoryEntity = category;
  }

  /**
   *
   * {@inheritDoc}
   */
  public Long getCategoryId() {
    return categoryId;
  }
  /**
   *
   * {@inheritDoc}
   */
  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
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
