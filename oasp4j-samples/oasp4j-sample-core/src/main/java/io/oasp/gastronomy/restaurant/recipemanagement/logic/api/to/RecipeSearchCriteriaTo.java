package io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.gastronomy.restaurant.recipemanagement.common.api.Recipe}s.
 *
 */
public class RecipeSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private String language;

  private Money price;

  private Long imageId;

  private String author;

  private String categories;

  private Integer portions;

  private String ingredients;

  private String difficulty;

  private Integer prepTimeMinutes;

  private Integer cookTimeMinutes;

  private Long calories;

  private String cookingInstructions;

  /**
   * The constructor.
   */
  public RecipeSearchCriteriaTo() {

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
   * @return description
   */
  public String getDescription() {

    return description;
  }

  /**
   * @param description description to be set
   */
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return price
   */
  public Money getPrice() {

    return price;
  }

  /**
   * @param price price to be set
   */
  public void setPrice(Money price) {

    this.price = price;
  }

  /**
   * @return ImageId
   */
  public Long getImageId() {

    return this.imageId;
  }

  /**
   * @param imageId imageId to be set
   */
  public void setImageId(Long imageId) {

    this.imageId = imageId;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Integer getPortions() {
    return portions;
  }

  public void setPortions(Integer portions) {
    this.portions = portions;
  }

  public String getCategories() {
    return categories;
  }

  public void setCategories(String categories) {
    this.categories = categories;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public Integer getCookTimeMinutes() {
    return cookTimeMinutes;
  }

  public void setCookTimeMinutes(Integer cookTimeMinutes) {
    this.cookTimeMinutes = cookTimeMinutes;
  }

  public Integer getPrepTimeMinutes() {
    return prepTimeMinutes;
  }

  public void setPrepTimeMinutes(Integer prepTimeMinutes) {
    this.prepTimeMinutes = prepTimeMinutes;
  }

  public Long getCalories() {
    return calories;
  }

  public void setCalories(Long calories) {
    this.calories = calories;
  }

  public String getCookingInstructions() {
    return cookingInstructions;
  }

  public void setCookingInstructions(String cookingInstructions) {
    this.cookingInstructions = cookingInstructions;
  }

}
