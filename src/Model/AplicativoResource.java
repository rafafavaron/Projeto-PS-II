/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Aplicativo;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.jersey.params.*;
import java.util.*;
import javax.xml.ws.Response;

@Path("/professores")
@Produces(MediaType.APPLICATION_JSON)
public class AplicativoResource {
    private final List<Aplicativo> aplicativo;
    private int proximoId;
    
    public AplicativoResource() {
        proximoId = 1;
        aplicativo = new ArrayList<>();
        aplicativo.add(new Aplicativo(proximoId++, "Teste", "Marcos", 123));
        }
    
    @POST
    public Aplicativo create(Aplicativo app) {
        app.setId(proximoId++);
        this.aplicativo.add(app);
        return app;
    }
    
    @GET
    public List<Aplicativo> read() {
        return aplicativo;
    }
    
    @PUT
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam idParam, Aplicativo app) {
        long id = idParam.get();
        
        for(Aplicativo a: aplicativo) {
            if(a.getId() == id) {
                a.setNome(app.getNome());
                a.setDesenvolvedor(app.getDesenvolvedor());
                a.setNr_Downloads(app.getNr_Downloads());
                return Response.ok().build();
            }
        }
        throw new WebApplicationException("Aplicativo com id=" + id 
                                          + " não encontrado!", 404);
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam idParam) {
        long id = idParam.get();
        
        for(Aplicativo p: aplicativo) {
            if(p.getId() == id) {
                aplicativo.remove(p);
                return Response.ok().build();
            }
        }
        throw new WebApplicationException("Aplicativo com id=" + id 
                                          + " não encontrado!", 404);
    }
}

