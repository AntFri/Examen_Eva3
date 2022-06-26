package com.antonioFrische.examen3;

import com.antonioFrische.examen3.Examen.ExamenMain;
import com.antonioFrische.examen3.Examen.Mueble;
import com.antonioFrische.examen3.Examen.MuebleClasico;
import com.antonioFrische.examen3.Examen.TipoMadera;
import com.antonioFrische.examen3.Libs.Lib;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;

public class MainProject {
    public static void main(String[] args) {
        Faker fake = new Faker();
        for( int i = 0; i < 30; i++) {
            System.out.println(fake.company().name());
        }
    }
}
