package edu.pingpong.quickstart;
import javax.inject.Inject;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EspadaService {
    @Inject
    EspadaRepository repository;
    @Inject
    HerreroRepository herreroRepository;

    public Espada postEspada(Espada espada){
        repository.postEspada(espada);
        return espada;
    }

    public Optional<Espada> getEspadaNombre(String nombre){
        return repository.getEspadaNombre(nombre);
    }

    public Optional<Espada> getEspadaLongitud(Float longitud){
        return repository.getEspadaLongitud(longitud);
    }

    public List<Espada> deleteEspada(String nombre){
        return repository.deleteEspada(nombre);
    }

    public Herrero afilarEspadaNombre(String herreroNombre, String espadaNombre){
        Herrero herrero = herreroRepository.afilarEspadaNombre(herreroNombre);
        herreroRepository.persist(herrero);
        repository.persist(herrero.afilar(espadaNombre));
        return herrero;
    }
    public Espada atacarEsapadaNombre(String nombre){
        return repository.atacarEspadaNombre(nombre);
    }
    public List<Espada> getListaEspada(){
        return repository.getListaEspada();
    }

    public List<Herrero> getHerrero(){
        return herreroRepository.get();
    }
}
