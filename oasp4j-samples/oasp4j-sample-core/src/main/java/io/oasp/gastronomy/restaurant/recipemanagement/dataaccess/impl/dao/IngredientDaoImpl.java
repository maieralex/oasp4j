package io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.impl.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.IngredientEntity;
import io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao.IngredientDao;

import javax.inject.Named;
import java.util.List;

/**
 * This is the implementation of {@link io.oasp.gastronomy.restaurant.recipemanagement.dataaccess.api.dao.IngredientDao}.
 */
@Named
public class IngredientDaoImpl extends ApplicationDaoImpl<IngredientEntity>implements IngredientDao {

  /**
   * The constructor.
   */
  public IngredientDaoImpl() {

    super();
  }

  @Override
  public Class<IngredientEntity> getEntityClass() {

    return IngredientEntity.class;
  }

  @Override
  public List<IngredientEntity> findAllIngredients() {

    return findAll();
  }
}
