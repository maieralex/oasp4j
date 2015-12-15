package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.impl.dao;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.RecipeEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao.RecipeDao;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

/**
 * This is the implementation of {@link RecipeDao}.
 */
@Named
public class RecipeDaoImpl extends ApplicationDaoImpl<RecipeEntity> implements RecipeDao {

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

    String searchString = criteria.getSearchString();

    if (searchString != null) {
      if (searchString.contains(" ")) {
        String[] searchParams = searchString.split(" ");

        for (String param : searchParams) {
          query.where(Alias.$(recipe.getName()).containsIgnoreCase(param)
              .or(Alias.$(recipe.getDescription()).containsIgnoreCase(param)));
        }
      } else {
        query.where(Alias.$(recipe.getName()).containsIgnoreCase(searchString)
            .or(Alias.$(recipe.getDescription()).containsIgnoreCase(searchString)));
      }
    }

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(recipe.getName()).equalsIgnoreCase(name));
    }

    String description = criteria.getDescription();
    if (description != null) {
      query.where(Alias.$(recipe.getDescription()).equalsIgnoreCase(description));
    }

    String language = criteria.getLanguage();
    if (language != null) {
      query.where(Alias.$(recipe.getLanguage()).equalsIgnoreCase(language));
    }

    Money priceFrom = criteria.getPriceFrom();
    Money priceTo = criteria.getPriceTo();
    if (priceFrom != null && priceTo != null) {
      query.where(Alias.$(recipe.getPrice()).between(priceFrom, priceTo));
    }

    Long imageId = criteria.getImageId();
    if (imageId != null) {
      query.where(Alias.$(recipe.getImageId()).eq(imageId));
    }

    Integer ratingFrom = criteria.getRatingFrom();
    Integer ratingTo = criteria.getRatingTo();
    if (ratingFrom != null && ratingTo != null) {
      query.where(Alias.$(recipe.getRating()).between(ratingFrom, ratingTo));
    }

    String[] categories = criteria.getCategories();
    if (categories != null && categories.length != 0) {
      query.where(Alias.$(recipe.getCategory()).in(Arrays.asList(categories)));
    }

    return findPaginated(criteria, query, alias);
  }
}
