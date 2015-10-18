package io.oasp.gastronomy.restaurant.recipemanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;

public interface Recipe extends ApplicationEntity {

  public String getName() ;

  public void setName(String name) ;

  public String getDescription() ;

  public void setDescription(String description) ;

  public Money getPrice() ;

  public void setPrice(Money price) ;

}
