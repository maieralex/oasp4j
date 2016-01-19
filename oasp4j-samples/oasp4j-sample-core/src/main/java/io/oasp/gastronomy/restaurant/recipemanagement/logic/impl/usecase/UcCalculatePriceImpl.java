package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl.usecase;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeIngredientEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcCalculatePrice;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase.AbstractRecipeUc;

import javax.annotation.security.PermitAll;
import javax.inject.Named;
import java.util.Set;

/**
 * Created by pascaldung on 13.01.16.
 */
@Named
@UseCase
public class UcCalculatePriceImpl extends AbstractRecipeUc implements UcCalculatePrice {

  @Override
  @PermitAll
  public Money getSummedPrice(Set<RecipeIngredientEto> ingredients) {

    Double sum = 0.0;
    Double fixprice = 1.0;

    if (ingredients == null) {
      return new Money(sum);
    }

    for (RecipeIngredientEto ingredientEto
      : ingredients) {

      if(ingredientEto != null)
      sum += ingredientEto.getAmount() * fixprice;
    }

    return new Money(sum);
  }
}
