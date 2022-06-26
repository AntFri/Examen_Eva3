package com.antonioFrische.examen3.Examen;

public class MuebleClasico extends Mueble{
    private double pesoKG;
    private TipoMadera tipoMadera;

    public MuebleClasico(String nombre, double precio, double alto, double ancho, double profundo, int stock, double pesoKG, TipoMadera tipoMadera) {
        super(nombre, precio, alto, ancho, profundo, stock);
        this.pesoKG = pesoKG;
        this.tipoMadera = tipoMadera;
    }

    public double getPesoKG() {
        return pesoKG;
    }

    public TipoMadera getTipoMadera() {
        return tipoMadera;
    }

    @Override
    public double calcPrecioEnvio(double kmDistancia) {
        return (0.10 * this.pesoKG * kmDistancia)+30;
    }

    @Override
    public String toString() {
        return "MuebleClasico{" + super.toString() +
                "pesoKG=" + pesoKG +
                ", tipoMadera=" + tipoMadera +
                '}';
    }
}
