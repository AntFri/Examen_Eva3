package com.antonioFrische.examen3.Examen;

import com.antonioFrische.examen3.Libs.AnsiColor;
import com.antonioFrische.examen3.Libs.Configure;
import com.antonioFrische.examen3.Libs.Lib;
import com.github.javafaker.Faker;

import java.util.*;

public class ExamenMain {
    static ArrayList<StringBuilder> menus = new ArrayList<>();
    static TiendaMueble tienda = new TiendaMueble();
    public ExamenMain(){
        generarMenus();
        if(Configure.DEBUG){
            generarMueblesAleatorio();
        }
        operationes(Lib.mostraMenu(menus.get(0),0,3));
    }

    private void operationes(int opcion){
        switch (opcion){
            case 1:
                venderMuebles();
                break;
            case 2:

                break;
            case 3:

                break;
            case 0:
                System.out.println("Has salido del programa");
        }
    }

    private void venderMuebles() {
        System.out.println(Arrays.toString(tienda.getCatalogos().toArray()));
        StringBuilder eligCatalo = new StringBuilder("elige un catalogo");
        ArrayList<Mueble> muebles = tienda.getCatalogos().get(Lib.mostraMenu(eligCatalo, 0, tienda.getCatalogos().size() - 1)).getMuebles();
        System.out.println(Arrays.toString(muebles.toArray()));
        StringBuilder eligMueble = new StringBuilder("Elige el mueble que quieres vender(Codigo del mueble)");
        Mueble mueblaAVender = muebles.get(Lib.mostraMenu(eligMueble, 10000, 99999));
        StringBuilder cantidadElegir = new StringBuilder("Cuantos quieres comprar");
        int canidad = Lib.mostraMenu(cantidadElegir, 1, 100);
        if (mueblaAVender.getStock() >= canidad) {
            System.out.println(mueblaAVender);
            double kmdistanci = Lib.askDouble("Existe Stock, Por favor introduce KM de distancia hasta la adresse de envio");
            double preciofinal = mueblaAVender.calcPrecioEnvio(kmdistanci);
            System.out.printf("El precio final es: %.2f", preciofinal);
            mueblaAVender.setStock(canidad);
            tienda.putMueble(mueblaAVender, canidad);
        }
    }

    public static void generarMenus () {
            menus.add(Lib.generateMEnu("1. Vender Muebles|2. Busquedas| 3. Estadisticas| ---------------- |0. salir"));
            menus.add((Lib.generateMEnu("1. por tipo|2. Por stock| ---------------- |0. volver al menu principal")));

    }



    private void generarMueblesAleatorio () {
        Faker genador = new Faker();
        for (int i = 0; i < Configure.NUM_MAX_ALETORIO; i++) {
            String nombre = genador.name().firstName();
            double precio = Lib.randomDouble(100, 5000);
            double alto = Lib.randomDouble(0.50, 2.50);
            double ancho = Lib.randomDouble(0.30, 1.80);
            double profundo = Lib.randomDouble(0.20, 2.80);
            int stock = Lib.randomInt(1, 5);
            double peso = Lib.randomDouble(20.5, 200.50);
            TipoMadera[] maderaAELegir = TipoMadera.values();
            TipoMadera madera = maderaAELegir[Lib.randomInt(0, maderaAELegir.length-1)];
            MuebleClasico nuevoMueble = new MuebleClasico(nombre, precio, alto, ancho, profundo, stock, peso, madera);
            int catalgoAleatorio = Lib.randomInt(0, tienda.getCatalogos().size() - 1);
            tienda.getCatalogos().get(catalgoAleatorio).addMuebles(nuevoMueble);
        }

        for (int i = 0; i < Configure.NUM_MAX_ALETORIO; i++) {
            String nombre = genador.name().firstName();
            double precio = Lib.randomDouble(100, 5000);
            double alto = Lib.randomDouble(0.50, 2.50);
            double ancho = Lib.randomDouble(0.30, 1.80);
            double profundo = Lib.randomDouble(0.20, 2.80);
            int stock = Lib.randomInt(1, 5);
            AnsiColor[] coloresAElegir = AnsiColor.values();
            AnsiColor color = coloresAElegir[Lib.randomInt(0, coloresAElegir.length-1)];
            MuebleAuxiliare nuevoMueble = new MuebleAuxiliare(nombre, precio, alto, ancho, profundo, stock, color);
            int catalgoAleatorio = Lib.randomInt(0, tienda.getCatalogos().size() - 1);
            tienda.getCatalogos().get(catalgoAleatorio).addMuebles(nuevoMueble);
        }
    }

}
