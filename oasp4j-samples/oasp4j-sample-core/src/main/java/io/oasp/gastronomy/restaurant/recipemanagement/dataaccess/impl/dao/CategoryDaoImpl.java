package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.impl.dao;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;
import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.CategoryEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao.CategoryDao;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.CategorySearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import javax.inject.Named;
import java.util.List;

/**
 * This is the implementation of {@link CategoryDao}.
 */
@Named
public class CategoryDaoImpl extends ApplicationDaoImpl<CategoryEntity>implements CategoryDao {

  /**
   * The constructor.
   */
  public CategoryDaoImpl() {

    super();
  }

  @Override
  public Class<CategoryEntity> getEntityClass() {

    return CategoryEntity.class;
  }

  @Override
  public List<CategoryEntity> findAllCategories() {
    return findAll();
  }

  @Override
  public PaginatedListTo<CategoryEntity> findCategories(CategorySearchCriteriaTo criteria) {

    CategoryEntity category = Alias.alias(CategoryEntity.class);
    EntityPathBase<CategoryEntity> alias = Alias.$(category);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(category.getName()).eq(name));
    }

    String language = criteria.getLanguage();
    if (language != null) {
      query.where(Alias.$(category.getLanguage()).eq(language));
    }

    return findPaginated(criteria, query, alias);
  }
}
