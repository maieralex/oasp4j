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

  /**
   *
   * @return author
     */
  public String getAuthor() {
    return author;
  }

  /**
   *
   * @param author set the author
     */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   *
   * @return portions
     */
  public Integer getPortions() {
    return portions;
  }

  /**
   *
   * @param portions set the portions
     */
  public void setPortions(Integer portions) {
    this.portions = portions;
  }

  /**
   *
   * @return categories
     */
  public String getCategories() {
    return categories;
  }

  /**
   *
   * @param categories set the categories
     */
  public void setCategories(String categories) {
    this.categories = categories;
  }

  /**
   *
   * @return ingredients
     */
  public String getIngredients() {
    return ingredients;
  }

  /**
   *
   * @param ingredients set the ingredients
     */
  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  /**
   *
   * @return difficulty
     */
  public String getDifficulty() {
    return difficulty;
  }

  /**
   *
   * @param difficulty set the difficulty
     */
  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  /**
   *
   * @return cookTimeMinutes
     */
  public Integer getCookTimeMinutes() {
    return cookTimeMinutes;
  }

  /**
   *
   * @param cookTimeMinutes set the cookTimeMinutes
     */
  public void setCookTimeMinutes(Integer cookTimeMinutes) {
    this.cookTimeMinutes = cookTimeMinutes;
  }

  /**
   *
   * @return prepTimeMinutes
     */
  public Integer getPrepTimeMinutes() {
    return prepTimeMinutes;
  }

  /**
   *
   * @param prepTimeMinutes set the prepTimeMinutes
     */
  public void setPrepTimeMinutes(Integer prepTimeMinutes) {
    this.prepTimeMinutes = prepTimeMinutes;
  }

  /**
   *
   * @return calories
     */
  public Long getCalories() {
    return calories;
  }

  /**
   *
   * @param calories set the calories
     */
  public void setCalories(Long calories) {
    this.calories = calories;
  }

  /**
   *
   * @return cookingInstructions
     */
  public String getCookingInstructions() {
    return cookingInstructions;
  }

  /**
   *
   * @param cookingInstructions set the cookingInstructions
     */
  public void setCookingInstructions(String cookingInstructions) {
    this.cookingInstructions = cookingInstructions;
  }

}
