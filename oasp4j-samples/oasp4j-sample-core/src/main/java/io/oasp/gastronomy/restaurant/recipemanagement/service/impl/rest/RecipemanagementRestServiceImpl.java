package io.oasp.gastronomy.restaurant.recipemanagement.service.impl.rest;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.logic.api.to.BinaryObjectEto;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.Recipemanagement;
import io.oasp.gastronomy.restaurant.recipemanagement.logic.api.to.*;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.rowset.serial.SerialBlob;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * The service class for REST calls in order to execute the methods in {@link Recipemanagement}.
 */
@Path("/recipemanagement/v1")
@Named("RecipemanagementRestService")
@Transactional
public class RecipemanagementRestServiceImpl {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(RecipemanagementRestServiceImpl.class);

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
  @PermitAll
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

  /**
   * Returns a {@link List} of all stored {@link CategoryEto}.
   *
   * @return a list of all CategoryEto.
   */
  @GET
  @Path("/categories")
  public List<CategoryEto> getAllCategories() {

    return recipemanagement.findAllCategories();
  }

  /**
   * Returns a {@link List} of all stored {@link CategoryEto} filtered by language.
   *
   * @param language the language of the {@link CategoryEto} to return
   * @return a list of all CategoryEto filtered by language.
   */
  @GET
  @Path("/categories/{language}/")
  public List<CategoryEto> getCategories(@PathParam("language") String language) {

    return recipemanagement.findCategories(language);
  }

  /**
   * Delegates to {@link Recipemanagement#updateRecipePicture(Long, Blob, BinaryObjectEto)}.
   *
   * @param recipeId        which recipe should be updated with a new image.
   * @param binaryObjectEto define the transferObject of the image.
   * @param picture         new data of the image.
   * @throws SQLException if data can't be written into the database.
   * @throws IOException  if the stram can't be accessed.
   */
  @Consumes("multipart/mixed")
  @POST
  @Path("/recipe/{id}/picture")
  public void updateRecipePicture(@PathParam("id") Long recipeId,
                                  @Multipart(value = "binaryObjectEto",
                                    type = MediaType.APPLICATION_JSON) BinaryObjectEto binaryObjectEto,
                                  @Multipart(value = "blob") InputStream picture)
    throws SQLException, IOException {

    Blob blob = new SerialBlob(IOUtils.readBytesFromStream(picture));
    this.recipemanagement.updateRecipePicture(recipeId, blob, binaryObjectEto);
  }

  /**
   * Returns the picture as {@link Byte}.
   *
   * @param recipeId Recipe id of the recipe to load picture of
   * @return {@link Byte}
   * @throws SQLException if can't access database
   * @throws IOException  if stram can't be read
   */
  @GET
  @Path("/recipe/{id}/picture")
  public Response getRecipePicture(@PathParam("id") long recipeId) throws SQLException, IOException {
    RecipeEto recipeEto = this.recipemanagement.findRecipe(recipeId);

    BinaryObjectEto binaryObjectEto = this.recipemanagement.findBinaryObject(recipeEto.getImageId());
    Blob binaryObjectBlob = this.recipemanagement.getBinaryObjectBlob(recipeEto.getImageId());

    if (binaryObjectEto != null && binaryObjectBlob != null) {
      MediaType mediaType = MediaType.valueOf(binaryObjectEto.getMimeType());
      // REVIEW arturk88 (hohwille) we need to find another way to stream the blob without loading into heap.
      // https://github.com/oasp/oasp4j-sample/pull/45
      byte[] pictureBytes = IOUtils.readBytesFromStream(binaryObjectBlob.getBinaryStream());

      Response.ResponseBuilder rBuild = Response.ok(pictureBytes, mediaType);
      return rBuild.build();
    } else {
      Response.ResponseBuilder rBuild = Response.noContent();
      return rBuild.build();
    }
  }

  /**
   * Delegates to {@link Recipemanagement#findRandomRecipes}.
   *
   * @param input    the number of the {@link RecipeEto} to return
   * @param language the language of the {@link RecipeEto} to return
   * @return the {@link RecipeEto}
   */
  @GET
  @Path("/recipe/randomList/{id}/{lang}")
  @PermitAll
  public List<RecipeEto> getAllRandomRecipes(@PathParam("id") String input, @PathParam("lang") String language) {

    int total;
    if (input == null) {
      throw new BadRequestException("missing input");
    }
    try {
      total = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new BadRequestException("Your input is not a number");
    }
    return this.recipemanagement.findRandomRecipes(total, language);
  }

  /**
   * Returns a {@link List} of all stored {@link IngredientEto}.
   *
   * @return a list of all IngredientEto
   */
  @GET
  @Path("/ingredient")
  public List<IngredientEto> getAllIngredients() {

    return recipemanagement.findAllIngredients();
  }

  /**
   * Returns the summed up price for the given ingredients.
   *
   * @param ingredients ingredients for the price calculation
   * @return summed up price
     */
  @POST
  @Path("/price/sum")
  public Money getSummedPrice(Set<RecipeIngredientEto> ingredients) {

    return this.recipemanagement.getSummedPrice(ingredients);
  }

}
