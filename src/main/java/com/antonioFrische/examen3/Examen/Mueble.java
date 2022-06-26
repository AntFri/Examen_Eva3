package com.antonioFrische.examen3.Examen;

import java.util.Comparator;
import java.util.Objects;

public abstract class Mueble {
    private static int N_IDAUTONUMBER = 10000;
    private final int id;
    private String nombre;
    private double precio;
    private double alto;
    private double ancho;
    private double profundo;
    private int stock;

    public Mueble(String nombre, double precio, double alto, double ancho, double profundo, int stock) {
        this.id = ++N_IDAUTONUMBER;
        this.nombre = nombre;
        this.precio = precio;
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getAlto() {
        return alto;
    }

    public double getAncho() {
        return ancho;
    }

    public double getProfundo() {
        return profundo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int unidadesVendidas) {
        this.stock = this.stock - unidadesVendidas;
    }

    public abstract double calcPrecioEnvio(double kmDistancia);

    @Override
    public String toString() {
        return "Mueble{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", alto=" + alto +
                ", ancho=" + ancho +
                ", profundo=" + profundo +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mueble mueble = (Mueble) o;
        return id == mueble.id && Double.compare(mueble.precio, precio) == 0 && Double.compare(mueble.alto, alto) == 0 && Double.compare(mueble.ancho, ancho) == 0 && Double.compare(mueble.profundo, profundo) == 0 && stock == mueble.stock && Objects.equals(nombre, mueble.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, alto, ancho, profundo, stock);
    }

    public static class compareNombre implements Comparator<Mueble> {

        @Override
        public int compare(Mueble o1, Mueble o2) {
            return o1.getNombre().compareToIgnoreCase(o2.getNombre());
        }
    }
}
