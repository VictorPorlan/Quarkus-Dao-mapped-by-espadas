package edu.pingpong.quickstart;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/espadas")
public class EspadaResource {

    @Inject
    EspadaService service;

    @GET
    @Path("/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Espada> getEspadaNombre(@PathParam("nombre") String nombre) {
        return service.getEspadaNombre(nombre);
    }

    @GET
    @Path("/longitud/{longitud}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Espada> getEspadaLongitud(@PathParam("longitud") Float longitud) {
        return service.getEspadaLongitud(longitud);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Espada postEspada(Espada espada){
        return service.postEspada(espada);
    }

    @DELETE
    @Path("/{nombre}")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Espada> deleteEspada(@PathParam("nombre")String nombre){
        return service.deleteEspada(nombre);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Espada> getListaEspada() {
        return service.getListaEspada();
    }

    @GET
    @Path("/afilar/{nombreHerrero}/{nombreEspada}")
    public Herrero afilarEspada(@PathParam("nombreEspada")String nombreEspada, @PathParam("nombreHerrero")String nombreHerrero){
        return service.afilarEspadaNombre(nombreHerrero, nombreEspada);
    }

    @GET
    @Path("/atacar/{nombre}")
    public Espada atacarEspada(@PathParam("nombre")String nombre){
        return service.atacarEsapadaNombre(nombre);
    }

    @GET
    @Path("/herreros/lista")
    public List<Herrero> getHerrero() {
        return service.getHerrero();
    }
}