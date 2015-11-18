package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.impl.dao;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.RecipeEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao.RecipeDao;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * This is the implementation of {@link RecipeDao}.
 */
@Named
public class RecipeDaoImpl extends ApplicationDaoImpl<RecipeEntity>implements RecipeDao {

  /**
   * The constructor.
   */
  public RecipeDaoImpl() {

    super();
  }

  @Override
  public Class<RecipeEntity> getEntityClass() {

    return RecipeEntity.class;
  }

  @Override
  public List<RecipeEntity> findAllRecipes() {
    return findAll();
  }

  @Override
  public PaginatedListTo<RecipeEntity> findRecipes(RecipeSearchCriteriaTo criteria) {

    RecipeEntity recipe = Alias.alias(RecipeEntity.class);
    EntityPathBase<RecipeEntity> alias = Alias.$(recipe);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(recipe.getName()).eq(name));
    }

    String description = criteria.getDescription();
    if (description != null) {
      query.where(Alias.$(recipe.getDescription()).eq(description));
    }

    String language = criteria.getLanguage();
    if (language != null) {
      query.where(Alias.$(recipe.getLanguage()).eq(language));
    }

    Money price = criteria.getPrice();
    if (price != null) {
      query.where(Alias.$(recipe.getPrice()).eq(price));
    }

    Long imageId = criteria.getImageId();
    if (imageId != null) {
      query.where(Alias.$(recipe.getImageId()).eq(imageId));
    }

    return findPaginated(criteria, query, alias);
  }
}