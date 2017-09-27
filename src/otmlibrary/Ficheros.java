/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otmlibrary;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author otorradomiguez
 */
public class Ficheros {
    
    public static boolean crearDirectorio(String ruta) {
        File directorio = new File(ruta);        
        if (directorio.exists() == false) {
            return directorio.mkdir();
        } else {
            System.out.println("El directorio ya existe");
            return false;
        }
    }
    
    public static boolean crearDirectorio(File archivo) {
        if (archivo.exists() == false) {
            return archivo.mkdir();
        } else {
            System.out.println("El directorio ya existe");
            return false;
        }
    }

    public static boolean crearArchivo(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists() == false) {
            try {
                archivo.createNewFile();
                return true;
            } catch (IOException ex) {
                System.out.println("Error al crear el archivo");
                return false;
            }
        } else {
            System.out.println("El archivo ya existe");
            return false;
        }
    }
    
    public static boolean crearArchivo(File archivo) {
        if (archivo.exists() == false) {
            try {
                archivo.createNewFile();
                return true;
            } catch (IOException ex) {
                System.out.println("Error al crear el archivo");
                return false;
            }
        } else {
            System.out.println("El archivo ya existe");
            return false;
        }
    }
    
}
