package ex2;

import java.io.IOException;
import java.io.File;
import java.util.Arrays;

public class ListAlfabeticament2 {
    //    Afegeix a la classe de l’exercici anterior, la funcionalitat de llistar un arbre de directoris
//    amb el contingut de tots els seus nivells (recursivament) de manera que s'imprimeixin en pantalla
//    en ordre alfabètic dins de cada nivell, indicant a més si és un directori (D) o un fitxer (F), i la seva última data de modificació.
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            //directori es el primer argument
            String nom_directori = args[0];
            //creem un tipus File amb direccció de l'argument
            File directory = new File(nom_directori);
            //Si no es directory ho escrivim
            if (!directory.isDirectory()) {
                System.out.println(nom_directori + " is not a directory.");
                return;
            }
            listDirectoryTree(directory, 0);

        } else {
            System.out.println("No hi ha cap directori");
        }
        //exemple : "/home/ivan/Escritorio/"
    }

    private static void listDirectoryTree(File directory, int nivell) {
        //Creem array tipus Files afegim directory a l'array
        File[] files = directory.listFiles();
        //ordenem array
        Arrays.sort(files);
        //recorrem amb un for l'array files
        for (File file : files) {
            String prefix = "";
            for (int i = 0; i < nivell; i++) {
                prefix += "    ";
            }
            //Si es arxiu posem una F
            if (file.isFile()) {
                System.out.println(prefix + "- " + file.getName() + " (F) ");
                //Si es directori posem una D
            } else if (file.isDirectory()) {
                System.out.println(prefix + "+ " + file.getName() + " (D) ");
                listDirectoryTree(file, nivell + 1);
            }
        }

    }

}





