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

  private Money priceFrom;

  private Money priceTo;

  private Long imageId;

  private String author;

  private Long[] categories;

  private Integer portions;

  private String difficulty;

  private Integer prepTimeMinutes;

  private Integer cookTimeMinutes;

  private Long calories;

  private String cookingInstructions;

  private String searchString;

  private Integer ratingFrom;

  private Integer ratingTo;

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

    return this.name;
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

    return this.description;
  }

  /**
   * @param description description to be set
   */
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return priceFrom
   */
  public Money getPriceFrom() {

    return this.priceFrom;
  }

  /**
   * @param priceFrom new value of {@link #priceFrom}.
   */
  public void setPriceFrom(Integer priceFrom) {

    this.priceFrom = new Money(priceFrom);
  }

  /**
   * @return priceTo
   */
  public Money getPriceTo() {

    return this.priceTo;
  }

  /**
   * @param priceTo new value of {@link #priceTo}.
   */
  public void setPriceTo(Integer priceTo) {

    this.priceTo = new Money(priceTo);
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

    return this.language;
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

    return this.author;
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

    return this.portions;
  }

  /**
   *
   * @param portions set the portions
   */
  public void setPortions(Integer portions) {

    this.portions = portions;
  }

  /**
   * @return categories
   */
  public Long[] getCategories() {

    return this.categories;
  }

  /**
   * @param categories new value of {@link #categories}.
   */
  public void setCategories(Long[] categories) {

    this.categories = categories;
  }

  /**
   *
   * @return difficulty
   */
  public String getDifficulty() {

    return this.difficulty;
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

    return this.cookTimeMinutes;
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

    return this.prepTimeMinutes;
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

    return this.calories;
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

    return this.cookingInstructions;
  }

  /**
   *
   * @param cookingInstructions set the cookingInstructions
   */
  public void setCookingInstructions(String cookingInstructions) {

    this.cookingInstructions = cookingInstructions;
  }

  /**
   * @return ratingFrom
   */
  public Integer getRatingFrom() {

    return this.ratingFrom;
  }

  /**
   * @param ratingFrom new value of {@link #ratingFrom}.
   */
  public void setRatingFrom(Integer ratingFrom) {

    this.ratingFrom = ratingFrom;
  }

  /**
   * @return ratingTo
   */
  public Integer getRatingTo() {

    return this.ratingTo;
  }

  /**
   * @param ratingTo new value of {@link #ratingTo}.
   */
  public void setRatingTo(Integer ratingTo) {

    this.ratingTo = ratingTo;
  }

  /**
   *
   * @return searchString
   */
  public String getSearchString() {

    return this.searchString;
  }

  /**
   *
   * @param searchString set the searchString
   */
  public void setSearchString(String searchString) {

    this.searchString = searchString;
  }

}
