/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otmlibrary;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static boolean crearArchivoVacio(String ruta) {
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

    public static boolean crearArchivoVacio(File archivo) {
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

    public static boolean borrar(String ruta, boolean recursivo) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            if (archivo.isFile()) {
                archivo.delete();
                return true;
            } else if (archivo.isDirectory() && recursivo) {
                File[] listaArchivos = archivo.listFiles();
                for (File x : listaArchivos) {
                    if (x.isFile()) {
                        x.delete();
                    } else {
                        boolean check = x.delete();
                        if (check == false) {
                            borrar(x.getPath(), true);
                        }
                    }
                }
                archivo.delete();
                return true;
            } else {
                boolean check = archivo.delete();
                return check;
            }
        }
        return false;
    }

    public static boolean borrar(File archivo, boolean recursivo) {
        if (archivo.exists()) {
            if (archivo.isFile()) {
                archivo.delete();
                return true;
            } else if (archivo.isDirectory() && recursivo) {
                File[] listaArchivos = archivo.listFiles();
                for (File x : listaArchivos) {
                    if (x.isFile()) {
                        x.delete();
                    } else {
                        boolean check = x.delete();
                        if (check == false) {
                            borrar(x.getPath(), true);
                        }
                    }
                }
                archivo.delete();
                return true;
            } else {
                boolean check = archivo.delete();
                return check;
            }
        }
        return false;
    }

    public static boolean copiar(String archivoOriginal, String archivoCopia) {
        int byteActual = 0;
        try {
            FileInputStream fInput = new FileInputStream(archivoOriginal);
            FileOutputStream fOutput = new FileOutputStream(archivoCopia, false);
            BufferedInputStream bInput = new BufferedInputStream(fInput);
            BufferedOutputStream bOutput = new BufferedOutputStream(fOutput);
            while (byteActual != -1) {
                byteActual = bInput.read();
                if (byteActual != -1) {
                    bOutput.write(byteActual);
                } else {
                    bOutput.close();
                    bInput.close();
                    fOutput.close();
                    fInput.close();
                    return true;
                }
            }
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
}
