package edu.pingpong.quickstart;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Herrero")
public class Herrero {
    @Id
    @Column(unique = true)
    private String nombre;

    @Column
    private String localidad;

    @JsonIgnore
    @OneToMany(mappedBy = "herrero")
    public Set<Espada> espadas = new HashSet<Espada>();

    public Herrero(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public Herrero() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public Set<Espada> getEspadas() {
        return espadas;
    }

    public Espada getEspada(String nombre){
        return espadas.stream().filter(x -> x.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public Espada afilar(String nombre){
        Espada espada = getEspada(nombre);
        espada.afilar();
        return espada;
    }
}
