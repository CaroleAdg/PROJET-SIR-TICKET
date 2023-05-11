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

import fr.istic.dto.SupportDto;
import fr.istic.dto.SupportPPDto;
import fr.istic.dto.TicketDto;
import fr.istic.dto.UserDto;
import fr.istic.taa.jaxrs.dao.generic.SupportDao;
import fr.istic.taa.jaxrs.dao.generic.TagDao;
import fr.istic.taa.jaxrs.domain.Support;
import fr.istic.taa.jaxrs.domain.Tag;
import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/supports")
@Produces({"application/json"})

public class SupportRessource {
	SupportDao sdao = new SupportDao();

	  @GET
	  @Path("/{supportId}")
	  public SupportDto getSupportById(@PathParam("supportId") Long id_user)  {
		  Support s =  sdao.findOne(id_user);
		  if(s!=null) {
			  return new SupportDto(s);
		  }
		  else return null;
	      
	  }
	  
	  @POST
	  @Consumes("application/json")
	  public Response addSupport(
	      @Parameter(description = "Support object that needs to be added to the store", required = true) SupportPPDto sdto) {
		  Support support= new Support();
		  support.setFirst_name(sdto.getFirst_name());
		  support.setLast_name(sdto.getLast_name());
		  support.setEmail(sdto.getEmail());
		  support.setPassword(sdto.getPassword());
		  sdao.save(support);
		  return Response.ok().entity(support).build();
	  }
	  @PUT
	  @Consumes("application/json")
	  @Path("/{id_support}")
	  public Response updateSupport(
			@PathParam("id_support") Long  id_support,
			@Parameter(description = "Support object that needs to be updated to the store", required = true) SupportPPDto sdto) {
		  	Support s = sdao.findOne(id_support);
		  	if(s==null) {
		  		return Response.status(Response.Status.NOT_FOUND).entity("Le support avec l'identifiant" +id_support+"n'existe pas" ).build();
		  	}
		  	s.setFirst_name(sdto.getFirst_name());
		  	s.setLast_name(sdto.getLast_name());
		  	s.setEmail(sdto.getEmail());
		  	s.setPassword(sdto.getPassword());
		  	sdao.save(s);
		    return Response.ok().entity(new SupportDto(s)).build();
	  }
	  
	  @DELETE
	  @Path("/{supportId}")
	  public Response deleteSupport(
		  @PathParam("supportId") Long  id_support) {
		  Support s = sdao.findOne(id_support);
		  	if(s==null) {
		  		return Response.status(Response.Status.NOT_FOUND).entity("Le support ayant l'identifiant " +id_support+" n'existe pas" ).build();
		  	}
		  	sdao.delete(s);
		  	return Response.ok().entity("Le support ayant l'identifiant "+id_support+" a bien été supprimé" ).build();
	  }

}
