package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.common.api.RecipeIngredient;

import javax.persistence.*;


/**
 *
 * Created by pascaldung on 01.12.15.
 */
@Entity(name = "Recipe_Ingredient")
@Table(name = "Recipe_Ingredient")
public class RecipeIngredientEntity extends ApplicationPersistenceEntity implements RecipeIngredient{

  private static final long serialVersionUID = 1L;

  RecipeEntity recipe;

  IngredientEntity ingredient;

  String measuringUnit;

  Double amount;

  Integer position;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "pk_recipe")
  public RecipeEntity getRecipe() {
    return recipe;
  }

  public void setRecipe(RecipeEntity recipe) {
    this.recipe = recipe;
  }

  @Override
  @Transient
  public Long getRecipeId() {
    if(this.recipe != null){
      return this.recipe.getId();
    }
    return null;
  }

  @Override
  public void setRecipeId(Long recipeId) {

    if(recipeId == null) {
      this.recipe = null;
    }
    else {
      RecipeEntity newRecipe = new RecipeEntity();
      newRecipe.setId(recipeId);
      this.recipe = newRecipe;
    }

  }

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "pk_ingredient")
  public IngredientEntity getIngredient() {
    return ingredient;
  }

  public void setIngredient(IngredientEntity ingredient) {
    this.ingredient = ingredient;
  }

  public String getMeasuringUnit() {
    return measuringUnit;
  }

  public void setMeasuringUnit(String measuringUnit) {
    this.measuringUnit = measuringUnit;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }
}
