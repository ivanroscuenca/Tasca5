package Nivell2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


import java.io.BufferedWriter;
        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.Arrays;

public class Parametritzant {
//    Executa l'exercici 3 del nivell anterior parametritzant tots els mètodes en un fitxer de configuració.
//    Pots utilitzar un fitxer Java Properties, o bé la llibreria Apache Commons Configuration si ho prefereixes.
//    De l'exercici anterior, parametritza el següent:
//    Directori a llegir.
//    Nom i directori del fitxer TXT resultant.

    public static void main(String[] args) throws IOException {

        if (args.length == 2) {
            //nom_directori es el primer argument, directori a llegir
            String nom_directori = args[0];
            //exemple : "/home/ivan/Escritorio/"
            //DiriNom_fitxer es el segon argument, directori on es guardará i el nom
            String DiriNom_fitxer = args[1];
            //exemple : "/home/ivan/Escritorio/Tasca5/src/Nivell2/llistaDirandFiles.txt"
            //creem un tipus File amb direcció de l'argument
            File directory = new File(nom_directori);
            //Si no es directory ho escrivim
            if (!directory.isDirectory()) {
                System.out.println(nom_directori + " is not a directory.");
                return;
            }
            //truquem a listDirectoryTree
            listDirectoryTree(directory,DiriNom_fitxer);

        } else {
            System.out.println("Els directoris no son correctes");
        }

    }

    //El mètode té 2 parametres com diu l'exercici
    private static void listDirectoryTree(File directory,String nom_fitxer) {
        //Creem array tipus Files afegim directory a l'array
        File[] files = directory.listFiles();
        //ordenem array
        Arrays.sort(files);
        int nivell=0;
        //recorrem amb un for l'array files
        for (File file : files) {
            String prefix = "";
            for (int i = 0; i < nivell; i++) {
                prefix += "    ";
            }
            //llavors s’ha de guardar en un fitxer segons ruta i nom dit per paràmetre a l'inici.
            try {
                //Creem objecte fileWriter i bufferedWriter
                FileWriter escritura = new FileWriter(nom_fitxer, true);
                BufferedWriter bufferescritura = new BufferedWriter(escritura);

                //Si es arxiu posem una F
                if (file.isFile()) {
                    escritura.write(prefix + "- " + file.getName() + " (F) \n");
                    //Si es directori posem una D
                } else if (file.isDirectory()) {
                    escritura.write(prefix + "+ " + file.getName() + " (D) \n");

                }
                escritura.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
