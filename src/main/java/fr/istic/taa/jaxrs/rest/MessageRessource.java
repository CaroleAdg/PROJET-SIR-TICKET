package fr.istic.taa.jaxrs.rest;

import java.util.ArrayList;
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

import fr.istic.dto.MessageDto;
import fr.istic.dto.MsgDto;
import fr.istic.dto.SupportDto;
import fr.istic.dto.TicketDto;
import fr.istic.dto.TicketTag;
import fr.istic.dto.UserDto;
import fr.istic.taa.jaxrs.dao.generic.MessageDao;
import fr.istic.taa.jaxrs.dao.generic.TicketDao;
import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.Message;
import fr.istic.taa.jaxrs.domain.Support;
import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;


@Path("/messages")
@Produces({"application/json"})
public class MessageRessource {
	MessageDao mdao = new MessageDao();
	TicketDao tdao= new TicketDao();
	UserDao udao= new UserDao(); 


  @GET
  @Path("/{messageId}")
  public MsgDto getMessageById(@PathParam("messageId") Long id_message)  {
  Message msg =  mdao.findOne(id_message);
  if(msg!=null) {
	  return new MsgDto(msg);
  }
  else return null;
  
  }
  @GET
  @Path("/ticket/{ticketId}")
  public Response getMessageByTicket(@PathParam("ticketId") Long id_ticket)  {
	  try {
		  List<MsgDto> messages= new ArrayList<MsgDto>();
		   for(Message m: this.mdao.findTicketMessages(id_ticket))
			   messages.add(new MsgDto(m));
		   return Response.ok().entity(messages).build();
	 }catch(Exception e)
	  { 
		 return Response.status(500).entity("erreur serveur").build();  
	}
  }
  
  @POST
  @Consumes("application/json")
  public Response addMessage(
	      @Parameter(description = "Message object that needs to be added to the store", required = true) MessageDto mdto) {
	  	  Long idNew = mdto.getId_Ticket();
	  	  Ticket newTicket= tdao.findOne(idNew);
	  	  
	  	  User user =  this.udao.findOne(mdto.getUserId());
	  	  
	  	
	  	  if(newTicket==null) {
	  		return Response.status(Response.Status.BAD_REQUEST).entity("Le ticket n'est pas valide").build();
	  	  }
	  	 if(user==null) {
		  		return Response.status(Response.Status.BAD_REQUEST).entity("L'utilisateur n'existe pas").build();
		  	  }
	  	  
		  Message message= new Message();
		  message.setComment(mdto.getComment());
		  message.setTicket(newTicket);
		  message.setUser(user);
		  mdao.save(message);
		  return Response.ok().entity(new MsgDto(message)).build();
		 
	  }
  
  @PUT
  @Consumes("application/json")
  @Path("/{MessageId}")
  public Response updateMessage(
	@PathParam("MessageId") Long messageId,
	@Parameter(description = "Message object that needs to be updated to the store", required = true) MessageDto mdto
	) {
	Message m =  this.mdao.findOne(messageId);
	if(m==null) {
		return Response.status(Response.Status.NOT_FOUND).entity("Aucun message n'a pour identifiant "+messageId).build();
	}	
	Ticket ticket =  this.tdao.findOne(mdto.getId_Ticket());
	if(ticket==null) {
		return Response.status(Response.Status.NOT_FOUND).entity("Aucun ticket ne possède l'identifiant "+mdto.getId_Ticket()).build();
	}
	
	mdto.setComment(mdto.getComment());
	mdto.setId_Ticket(ticket.getId_ticket());
	mdao.update(m);
	return Response.ok().entity("okay").build();
	
  }
  @DELETE
  @Path("/{MessageId}")
  public Response deleteMessage(
		  @PathParam("MessageId") Long messageId) {
	  Message m =  this.mdao.findOne(messageId);
	  if(m==null) {
		  return Response.status(Response.Status.NOT_FOUND).entity("Aucun message n'a pour identifiant "+messageId).build();
	  }
	  mdao.delete(m);
	  return Response.ok().entity("Le message ayant pour identifiant "+messageId+"a bien été supprimé").build();
	  
  }
}
