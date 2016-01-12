package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.RecipeIngredient;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 *
 * Created by pascaldung on 01.12.15.
 */
@Entity(name = "Recipe_Ingredient")
@Table(name = "Recipe_Ingredient")
public class RecipeIngredientEntity extends ApplicationPersistenceEntity implements RecipeIngredient {

  private static final long serialVersionUID = 1L;

  private RecipeEntity recipe;

  private IngredientEntity ingredient;

  private String measuringUnit;

  private Double amount;

  private Integer position;

  /**
   *
   * @return entity of the recipe.
     */
  @ManyToOne()
  @JoinColumn(name = "pk_recipe")
  public RecipeEntity getRecipe() {

    return recipe;
  }

  /**
   *
   * @param recipe new entity of the recipe to be set.
     */
  public void setRecipe(RecipeEntity recipe) {

    this.recipe = recipe;
  }

  @Override
  @Transient
  public Long getRecipeId() {
    if (this.recipe != null) {
      return this.recipe.getId();
    }
    return null;
  }

  @Override
  public void setRecipeId(Long recipeId) {

    if (recipeId == null) {
      this.recipe = null;
    } else {
      RecipeEntity newRecipe = new RecipeEntity();
      newRecipe.setId(recipeId);
      this.recipe = newRecipe;
    }

  }

  @Override
  @Transient
  public Long getIngredientId() {
    if (ingredient == null) {
      return null;
    }

    return ingredient.getId();
  }

  @Override
  public void setIngredientId(Long ingredientId) {

    if (ingredientId == null) {
      this.ingredient = null;
    } else {
      IngredientEntity newIngredientEntity = new IngredientEntity();
      newIngredientEntity.setId(ingredientId);
      this.ingredient = newIngredientEntity;
    }
  }

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "pk_ingredient")
  public IngredientEntity getIngredient() {

    return ingredient;
  }

  /**
   *
   * @param ingredient new entity of the ingredient to be set.
     */
  public void setIngredient(IngredientEntity ingredient) {

    this.ingredient = ingredient;
  }

  /**
   *
   * @return Measuring Unit for the ingredient in the recipe.
   */
  public String getMeasuringUnit() {
    return measuringUnit;
  }

  /**
   *
   * @param measuringUnit set new Measuring Unit for the ingredient in the recipe.
   */
  public void setMeasuringUnit(String measuringUnit) {
    this.measuringUnit = measuringUnit;
  }

  /**
   *
   * @return Amount of the ingredient in the recipe.
   */
  public Double getAmount() {
    return amount;
  }

  /**
   *
   * @param amount set new Amount of the ingredient in the recipe.
   */
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  /**
   *
   * @return Position of the ingredient in the recipe.
   */
  public Integer getPosition() {
    return position;
  }

  /**
   *
   * @param position set new Position for the ingredient in the recipe.
   */
  public void setPosition(Integer position) {
    this.position = position;
  }
}
