package io.oasp.gastronomy.restaurant.recipemanagement.logic.impl.usecase;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.CategoryEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategoryEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategorySearchCriteriaTo;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.usecase.UcFindCategory;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.base.usecase.AbstractRecipeUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

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
  @Override
  //RolesAllowed(PermissionConstants.FIND_RECIPE)
  @PermitAll
  public List<CategoryEto>  findCategories(String language) {
    CategorySearchCriteriaTo csc = new CategorySearchCriteriaTo();

    csc.setLanguage(language);
    PaginatedListTo<CategoryEntity> categories = getCategoryDao().findCategories(csc);

    List<CategoryEntity> categoryList = categories.getResult();

    return getBeanMapper().mapList(categoryList, CategoryEto.class);
  }
}
