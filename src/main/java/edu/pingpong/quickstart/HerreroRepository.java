package edu.pingpong.quickstart;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class HerreroRepository implements PanacheRepository<Herrero> {
    public List<Herrero> get(){
        return listAll();
    }
    public Herrero afilarEspadaNombre(String herreroNombre){
        return find("nombre", herreroNombre).firstResult();

    }

    public Herrero post(Herrero herrero){
        persist(herrero);
        return herrero;
    }
}
