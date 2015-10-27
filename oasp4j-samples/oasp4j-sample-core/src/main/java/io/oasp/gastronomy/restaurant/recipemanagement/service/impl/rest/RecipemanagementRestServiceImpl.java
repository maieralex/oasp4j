package io.oasp.gastronomy.restaurant.recipemanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.transaction.annotation.Transactional;

import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.Recipemanagement;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.RecipeSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service class for REST calls in order to execute the methods in {@link Recipemanagement}.
 *
 */
@Path("/recipemanagement/v1")
@Named("RecipemanagementRestService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class RecipemanagementRestServiceImpl {

  private Recipemanagement recipemanagement;

  /**
   * This method sets the field <tt>recipemanagement</tt>.
   *
   * @param recipeManagement the new value of the field recipemanagement
   */
  @Inject
  public void setRecipemanagement(Recipemanagement recipeManagement) {

    this.recipemanagement = recipeManagement;
  }

  /**
   * Delegates to {@link Recipemanagement#findRecipe}.
   *
   * @param id the ID of the {@link RecipeEto}
   * @return the {@link RecipeEto}
   */
  @GET
  @Path("/recipe/{id}/")
  public RecipeEto getRecipe(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("recipe not found");
    }
    return this.recipemanagement.findRecipe(idAsLong);
  }

  /**
   * Delegates to {@link Recipemanagement#saveRecipe}.
   *
   * @param recipe the {@link RecipeEto} to be saved
   * @return the recently created {@link RecipeEto}
   */
  @POST
  @Path("/recipe/")
  public RecipeEto saveRecipe(RecipeEto recipe) {

    return this.recipemanagement.saveRecipe(recipe);
  }

  /**
   * Delegates to {@link Recipemanagement#deleteRecipe}.
   *
   * @param id ID of the {@link RecipeEto} to be deleted
   */
  @DELETE
  @Path("/recipe/{id}/")
  public void deleteRecipe(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("recipe not found");
    }
    this.recipemanagement.deleteRecipe(idAsLong);
  }

  /**
   * Delegates to {@link Recipemanagement#findRecipeEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding recipes.
   * @return the {@link PaginatedListTo list} of matching {@link RecipeEto}s.
   */
  @POST
  @Path("/recipe/search")
  public PaginatedListTo<RecipeEto> findRecipesByPost(RecipeSearchCriteriaTo searchCriteriaTo) {

    return this.recipemanagement.findRecipeEtos(searchCriteriaTo);
  }

}
