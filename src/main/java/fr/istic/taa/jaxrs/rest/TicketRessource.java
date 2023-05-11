package fr.istic.taa.jaxrs.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.dto.TicketDto;
import fr.istic.dto.TicketPPDto;
import fr.istic.dto.TicketTag;
import fr.istic.taa.jaxrs.dao.generic.TicketDao;
import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/tickets")
@Produces({"application/json"})

public class TicketRessource {
	
	TicketDao tdao= new TicketDao();
	UserDao udao= new UserDao(); 

	  
	  @GET
	  @Path("/{ticketId}")
	  public Response getTicketById(@PathParam("ticketId") Long TicketId)  {
	     Ticket t = tdao.findOne(TicketId);
	     if(t!=null)
	      return Response.ok().entity(new TicketTag(t)).build();
	     else return Response.status(Response.Status.NOT_FOUND).entity("Aucun ticket n'a pour identifiant "+TicketId).build();
	  }
	  

	  @GET
	  @Path("/")
	  public Response getTickets()  {
		  try {
			   List<TicketDto> list = new ArrayList<>();
			   for(Ticket t: this.tdao.findAll())
				   list.add(new TicketDto(t));
			   
			   return Response.ok().entity(list).build();
		 }catch(Exception e)
		  { 
			 return Response.status(500).entity("erreur serveur").build();  
		}
		 
	  }

	  @POST
	  @Consumes("application/json")
	  public Response addTicket(
	      @Parameter(description = "Ticket object that needs to be added to the store", required = true) TicketPPDto tdto) {
		  Ticket ticket= new Ticket();
		  ticket.setLabel(tdto.getLabel());
		  User user =  this.udao.findOne(tdto.getUserId());
		  if(user!=null) {
			  ticket.setUser(user);
			  tdao.save(ticket);
			  return Response.ok().entity("SUCCES").build();
		  }
		  else
		    return Response.status(500).entity("userId invalide").build();  
	  }
	  
	  @PUT
	  @Consumes("application/json")
	  @Path("/{TicketId}")
	  public Response updateTicket(
		@PathParam("TicketId") Long ticketId,
		@Parameter(description = "Ticket object that needs to be updated to the store", required = true) TicketPPDto tdto
		) {
		Ticket t =  this.tdao.findOne(ticketId);
		if(t==null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Aucun ticket n'a pour identifiant "+ticketId).build();
		}	
		User user =  this.udao.findOne(tdto.getUserId());
		if(user==null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Aucun utilisateur ne possède l'identifiant"+tdto.getUserId()).build();
		}
		
		t.setLabel(tdto.getLabel());
		t.setUser(user);
		tdao.save(t);
		return Response.ok().entity(tdto).build();
		
	  }
	  @DELETE
	  @Path("/{TicketId}")
	  public Response deleteTicket(
			  @PathParam("TicketId") Long ticketId) {
		  Ticket t =  this.tdao.findOne(ticketId);
		  if(t==null) {
			  return Response.status(Response.Status.NOT_FOUND).entity("Aucun ticket n'a pour identifiant "+ticketId).build();
		  }
		  tdao.delete(t);
		  return Response.ok().entity("Le ticket ayant pour identifiant "+ticketId+"a bien été supprimé").build();
		  
	  }
}
