package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl.usecase;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategoryEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindCategory;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase.AbstractRecipeUc;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import java.util.List;

/**
 * Use case implementation for getting categories.
 */
@Named
@UseCase
public class UcFindCategoryImpl extends AbstractRecipeUc implements UcFindCategory {

  @Override
  @RolesAllowed(PermissionConstants.FIND_RECIPE)
  public List<CategoryEto> findAllCategories() {

    return getBeanMapper().mapList(getCategoryDao().findAllCategories(), CategoryEto.class);
  }

  @Override
  //RolesAllowed(PermissionConstants.FIND_RECIPE)
  @PermitAll
  public CategoryEto findCategory(Long id) {
    return getBeanMapper().map(getCategoryDao().findOne(id), CategoryEto.class);
  }
}
