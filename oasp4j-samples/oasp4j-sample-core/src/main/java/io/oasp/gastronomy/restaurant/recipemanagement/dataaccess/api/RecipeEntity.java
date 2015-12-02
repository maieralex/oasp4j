package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.Recipe;

import javax.persistence.*;
import java.util.Set;

/**
 * The {@link ApplicationPersistenceEntity persistent entity} for a recipe.
 *
 * @author pdung
 */
@Entity(name = "Recipe")
@Table(name = "Recipe")
public class RecipeEntity extends ApplicationPersistenceEntity implements Recipe {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private String language;

  private Money price;

  private Long imageId;

  private String author;

  private String categories;

  private Integer portions;

  private Set<RecipeIngredientEntity> recipeIngredients;

  private String difficulty;

  private Integer prepTimeMinutes;

  private Integer cookTimeMinutes;

  private Long calories;

  private String cookingInstructions;

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
   * @param name the name of this recipe.
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

    return this.imageId;
  }

  @Override
  public void setImageId(Long imageId) {

      this.imageId = imageId;
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
   *
   * @return language return the language of a recipe.
     */
  public String getLanguage() {
    return language;
  }

  /**
   *
   * @param language set a new language of a recipe
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   *
   * @return author return the author of a recipe.
     */
  public String getAuthor() {
    return author;
  }

  /**
   *
   * @param author set a new author of a recipe.
     */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   *
   * @return portions return the portion quantity of a recipe.
     */
  public Integer getPortions() {
    return portions;
  }

  /**
   *
   * @param portions set a new quantity of portions of a recipe.
     */
  public void setPortions(Integer portions) {
    this.portions = portions;
  }

  /**
   *
   * @return categories return the categories of a recipe.
     */
  public String getCategories() {
    return categories;
  }

  /**
   *
   * @param categories set new categories of a recipe.
     */
  public void setCategories(String categories) {
    this.categories = categories;
  }

  /**
   *
   * @return ingredients return the ingredients of a recipe.
     */
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "recipe")
  public Set<RecipeIngredientEntity> getIngredients() {
    return recipeIngredients;
  }

  /**
   *
   * @param recipeIngredients set new ingredients of a recipe.
     */
  public void setIngredients(Set<RecipeIngredientEntity> recipeIngredients) {
    this.recipeIngredients = recipeIngredients;
  }

  /**
   *
   * @return difficulty return the difficulty of a recipe.
     */
  public String getDifficulty() {
    return difficulty;
  }

  /**
   *
   * @param difficulty set a new difficulty of a recipe.
     */
  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  /**
   *
   * @return cookTimeMinutes return the time it takes to cook a recipe.
     */
  public Integer getCookTimeMinutes() {
    return cookTimeMinutes;
  }

  /**
   *
   * @param cookTimeMinutes set the time it takes to cook a recipe.
     */
  public void setCookTimeMinutes(Integer cookTimeMinutes) {
    this.cookTimeMinutes = cookTimeMinutes;
  }

  /**
   *
   * @return prepTimeMinutes return the time it takes to prepare everything for a recipe.
     */
  public Integer getPrepTimeMinutes() {
    return prepTimeMinutes;
  }

  /**
   *
   * @param prepTimeMinutes set the time it takes to prepare everything for a recipe.
     */
  public void setPrepTimeMinutes(Integer prepTimeMinutes) {
    this.prepTimeMinutes = prepTimeMinutes;
  }

  /**
   *
   * @return calories return the amount of calories of a recipe.
     */
  public Long getCalories() {
    return calories;
  }

  /**
   *
   * @param calories set the amount of calories of a recipe.
     */
  public void setCalories(Long calories) {
    this.calories = calories;
  }

  /**
   *
   * @return cookingInstructions return the instructions to cook a recipe.
     */
  public String getCookingInstructions() {
    return cookingInstructions;
  }

  /**
   *
   * @param cookingInstructions set the instructions to cook a recipe.
     */
  public void setCookingInstructions(String cookingInstructions) {
    this.cookingInstructions = cookingInstructions;
  }

}
