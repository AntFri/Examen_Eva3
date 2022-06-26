package com.antonioFrische.examen3.Examen;

import com.antonioFrische.examen3.Libs.AnsiColor;

public class MuebleAuxiliare extends Mueble{
    private AnsiColor color;

    public MuebleAuxiliare(String nombre, double precio, double alto, double ancho, double profundo, int stock, AnsiColor color) {
        super(nombre, precio, alto, ancho, profundo, stock);
        this.color = color;
    }

    public AnsiColor getColor() {
        return color;
    }

    @Override
    public double calcPrecioEnvio(double kmDistancia) {
        return getAlto()*getAncho()*getProfundo()*kmDistancia;
    }

}
