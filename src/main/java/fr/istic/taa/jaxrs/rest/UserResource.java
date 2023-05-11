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
import fr.istic.dto.UserPPDto;
import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/users")
@Produces({"application/json"})
public class UserResource {
	  UserDao dao= new UserDao();
	
	  @GET
	  @Path("/{userId}")
	  public UserDto getUserById(@PathParam("userId") Long  id_user)  {
	    User u =  dao.findOne(id_user);
	    return new UserDto(u);
	  }

	  @POST
	  @Consumes("application/json")
	  public Response addUser(
	      @Parameter(description = "User object that needs to be added to the store", required = true) UserPPDto udto) {
		  User user= new User();
		  user.setFirst_name(udto.getFirst_name());
		  user.setLast_name(udto.getLast_name());
		  user.setEmail(udto.getEmail());
		  user.setPassword(udto.getPassword());
	    dao.save(user);
	    return Response.ok().entity(new UserPPDto(user)).build();
	  }
	  
	  @PUT
	  @Consumes("application/json")
	  @Path("/{userId}")
	  public Response updateUser(
			@PathParam("userId") Long  id_user,
			@Parameter(description = "User object that needs to be updated to the store", required = true) UserPPDto udto) {
		  	User u = dao.findOne(id_user);
		  	if(u==null) {
		  		return Response.status(Response.Status.NOT_FOUND).entity("L'utilisateur avec l'identifiant" +id_user+"n'existe pas" ).build();
		  	}
		  	u.setFirst_name(udto.getFirst_name());
		  	u.setLast_name(udto.getLast_name());
		  	u.setEmail(udto.getEmail());
			u.setPassword(udto.getPassword());
		  	dao.save(u);
		    return Response.ok().entity(new UserPPDto(u)).build();
	  }
	  
	  @DELETE
	  @Path("/{userId}")
	  public Response deleteUser(
		  @PathParam("userId") Long  id_user) {
		  User u = dao.findOne(id_user);
		  	if(u==null) {
		  		return Response.status(Response.Status.NOT_FOUND).entity("L'utilisateur ayant l'identifiant " +id_user+" n'existe pas" ).build();
		  	}
		  	dao.delete(u);
		  	return Response.ok().entity("L'utilisateur ayant l'identifiant "+id_user+" a bien été supprimé" ).build();
	  }
	  
	  

}
