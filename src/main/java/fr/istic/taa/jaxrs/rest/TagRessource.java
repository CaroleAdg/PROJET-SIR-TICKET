package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.dto.UserDto;
import fr.istic.taa.jaxrs.dao.generic.TagDao;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.Tag;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/tags")
@Produces({"application/json"})

public class TagRessource {
	TagDao tdao = new TagDao();

	  @GET
	  @Path("/{tagId}")
	  public Tag getTagById(@PathParam("tagId") Long tagId)  {
		  Tag t =  tdao.findOne(tagId);
	      return t;
	  }
	  
	  @POST
	  @Consumes("application/json")
	  public Response addTag(
	      @Parameter(description = "Tag object that needs to be added to the store", required = true) Tag t) {
		  Tag tag = new Tag();
		  tag.setTag_name(t.getTag_name());
		  tdao.save(tag);
	    return Response.ok().entity(tag).build();
	  }
	  
	  @PUT
	  @Consumes("application/json")
	  @Path("/{tagId}")
	  public Response updateTag(
			@PathParam("tagId") Long  id_tag,
			@Parameter(description = "Tag object that needs to be updated to the store", required = true) Tag tag) {
		  	Tag t = tdao.findOne(id_tag);
		  	if(t==null) {
		  		return Response.status(Response.Status.NOT_FOUND).entity("Le tag ayant l'identifiant" +id_tag+"n'existe pas" ).build();
		  	}
		  	t.setTag_name(t.getTag_name());
		  	tdao.save(t);
		    return Response.ok().entity(tag).build();
	  }
	  
	  @DELETE
	  @Path("/{tagId}")
	  public Response deleteTag(
		  @PathParam("tagId") Long  id_tag) {
		  Tag t = tdao.findOne(id_tag);
		  	if(t==null) {
		  		return Response.status(Response.Status.NOT_FOUND).entity("Le tag ayant l'identifiant " +id_tag+" n'existe pas" ).build();
		  	}
		  	tdao.delete(t);
		  	return Response.ok().entity("Le tag ayant l'identifiant "+id_tag+" a bien été supprimé" ).build();
	  }
	  
	  
}
