/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Computador;
import io.dropwizard.jersey.params.LongParam;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;


@Path("/computador")
@Produces(MediaType.APPLICATION_JSON)
public class ComputadorResource {
    private final List<Computador> computador;
    private int proximoId;
    
    public ComputadorResource() {
        proximoId = 1;
        computador = new ArrayList<>();
        computador.add(new Computador(proximoId++, "Lenovo", "Intel", 123, 345));
        }
    
    @POST
    public Computador create(Computador pc) {
        pc.setId(proximoId++);
        this.computador.add(pc);
        return pc;
    }
    
    @GET
    public List<Computador> read() {
        return computador;
    }
    
    @PUT
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam idParam, Aplicativo app) {
        long id = idParam.get();
        
        for(Computador pc: computador) {
            if(pc.getId() == id) {
                pc.setMarca(pc.getMarca());
                pc.setProcessador(pc.getProcessador());
                pc.setQtd_ram(pc.getQtd_ram());
                pc.setTam_disco(pc.getTam_disco());
                return Response.ok().build();
            }
        }
        throw new WebApplicationException("Computador com id=" + id 
                                          + " não encontrado!", 404);
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam idParam) {
        long id = idParam.get();
        
        for(Computador p: computador) {
            if(p.getId() == id) {
                computador.remove(p);
                return Response.ok().build();
            }
        }
        throw new WebApplicationException("Computador com id=" + id 
                                          + " não encontrado!", 404);
    }
}


