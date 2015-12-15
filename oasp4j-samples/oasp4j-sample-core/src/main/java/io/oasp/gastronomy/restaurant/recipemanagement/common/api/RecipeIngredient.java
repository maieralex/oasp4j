package io.oasp.gastronomy.restaurant.recipemanagement.common.api;

import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.IngredientEntity;

/**
 * Created by pascaldung on 01.12.15.
 */
public interface RecipeIngredient {

  public Long getRecipeId();

  public void setRecipeId(Long recipeId);

  public IngredientEntity getIngredient();

  public void setIngredient(IngredientEntity ingredient);

  public String getMeasuringUnit();

  public void setMeasuringUnit(String measuringUnit);

  public Double getAmount();

  public void setAmount(Double amount);

  public Integer getPosition();

  public void setPosition(Integer position);
}


