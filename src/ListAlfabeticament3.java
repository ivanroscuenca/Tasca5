import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ListAlfabeticament3 {
//    Modifica l’exercici anterior. Ara, en lloc de mostrar el resultat per la pantalla,
//    guarda el resultat en un fitxer TXT.
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
            //llavors s’ha de guardar en un fitxer anomenat listDirandFiles.txt, .
            try {
                //Creem objecte fileWriter i bufferedWriter
                FileWriter escritura = new FileWriter("/home/ivan/Escritorio/Tasca5/src/listDirandFiles.txt", true);
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






