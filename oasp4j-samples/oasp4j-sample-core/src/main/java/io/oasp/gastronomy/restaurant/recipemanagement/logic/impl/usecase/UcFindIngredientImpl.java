package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl.usecase;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.IngredientEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindIngredient;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase.AbstractRecipeUc;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import java.util.List;

/**
 * Use case implementation for getting ingredients.
 */
@Named
@UseCase
public class UcFindIngredientImpl extends AbstractRecipeUc implements UcFindIngredient {

  @Override
  @RolesAllowed(PermissionConstants.FIND_RECIPE)
  public List<IngredientEto> findAllIngredients() {

    return getBeanMapper().mapList(getIngredientDao().findAllIngredients(), IngredientEto.class);
  }
}
