package com.antonioFrische.examen3.Examen;

import com.antonioFrische.examen3.Libs.Configure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Catalogo {
    private static int N_IDAUTONUM = 0;
    private final int id;
    private String nombre;
    private int anyo;
    private ArrayList<Mueble> muebles;

    public Catalogo(String nombre, int anyo, ArrayList<Mueble> muebles) {
        this.id = ++N_IDAUTONUM;
        this.nombre = nombre;
        this.anyo = anyo;
        this.muebles = muebles;
    }

    public Catalogo(String nombre, int anyo) {
        this.id = ++N_IDAUTONUM;
        this.nombre = nombre;
        this.anyo = anyo;
        this.muebles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnyo() {
        return anyo;
    }

    public ArrayList<Mueble> getMuebles() {
        return muebles;
    }

    public void addMuebles(Mueble mueble) {
        muebles.add(mueble);
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anyo=" + anyo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalogo catalogo = (Catalogo) o;
        return id == catalogo.id && Objects.equals(nombre, catalogo.nombre) && Objects.equals(anyo, catalogo.anyo) && Objects.equals(muebles, catalogo.muebles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, anyo, muebles);
    }

    public static class compareAnyo implements Comparator<Catalogo>{

        @Override
        public int compare(Catalogo o1, Catalogo o2) {
            return o1.getAnyo() - o2.getAnyo();
        }
    }

}
