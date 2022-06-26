package com.antonioFrische.examen3.Examen;

import java.util.ArrayList;
import java.util.HashMap;

public class TiendaMueble {
    private ArrayList<Catalogo> catalogos;
    private HashMap<Mueble,Integer> historicoVentas;
    public TiendaMueble(){
        catalogos =  new ArrayList<>();
        historicoVentas = new HashMap<>();
        ordenarCatalogos();
        genrarCatalogos();
    }
    public  ArrayList<Catalogo> getCatalogos() {
        return catalogos;
    }

    public  HashMap<Mueble, Integer> getHistoricoVentas() {
        return historicoVentas;
    }

    public void putMueble(Mueble mueble, int cantidad){
        if(historicoVentas.containsKey(mueble)){
            cantidad = historicoVentas.get(mueble);
            historicoVentas.put(mueble,++cantidad);
        }else{
            historicoVentas.put(mueble,cantidad);
        }
    }
    private void ordenarCatalogos () {
        for (Catalogo catalogo : catalogos) {
            catalogo.getMuebles().sort(new Mueble.compareNombre());
        }
    }

    public void genrarCatalogos () {
        catalogos.add(new Catalogo("Invierno", 2021));
        catalogos.add(new Catalogo("Primavera", 2022));
        catalogos.add(new Catalogo("Verano", 2022));
        catalogos.sort(new Catalogo.compareAnyo());
    }
}
