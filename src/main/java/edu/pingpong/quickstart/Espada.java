package edu.pingpong.quickstart;
import javax.persistence.*;

@Entity
@Table(name = "Espada")
public class Espada {
    @Id
    private String nombre;
    @Column
    private Float longitud;
    @Column
    private boolean afilada;
    @ManyToOne
    @JoinColumn(name = "herrero")
    public Herrero herrero;

    public Espada(String nombre, Float longitud, boolean afilada) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.afilada = afilada;
    }

    public Espada() {
    }

    public String getNombre() {
        return nombre;
    }

    public Float getLongitud() {
        return longitud;
    }

    public boolean isAfilada() {
        return afilada;
    }

    public void setAfilada(boolean afilada) {
        this.afilada = afilada;
    }

    public void afilar(){
        setAfilada(true);
    }

    public void atacar(){
        setAfilada(false);
    }
}
