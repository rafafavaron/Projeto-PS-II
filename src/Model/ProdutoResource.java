/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Produto;
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

@Path("/produto")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    private final List<Produto> produto;
    private int proximoId;
    
    public ProdutoResource() {
        proximoId = 1;
        produto = new ArrayList<>();
        produto.add(new Produto(proximoId++, "Mouse", "Positivo", 12));
        }
    
    @POST
    public Produto create(Produto pd) {
        pd.setId(proximoId++);
        this.produto.add(pd);
        return pd;
    }
    
    @GET
    public List<Produto> read() {
        return produto;
    }
    
    @PUT
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam idParam, Produto app) {
        long id = idParam.get();
        
        for(Produto pd: produto) {
            if(pd.getId() == id) {
                pd.setMarca(pd.getMarca());
                pd.setDescricao(pd.getDescricao());
                pd.setPreco(pd.getPreco());
                return Response.ok().build();
            }
        }
        throw new WebApplicationException("Produto com id=" + id 
                                          + " não encontrado!", 404);
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam idParam) {
        long id = idParam.get();
        
        for(Produto p: produto) {
            if(p.getId() == id) {
                produto.remove(p);
                return Response.ok().build();
            }
        }
        throw new WebApplicationException("Produto com id=" + id 
                                          + " não encontrado!", 404);
    }
}



    
