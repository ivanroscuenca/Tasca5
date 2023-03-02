import java.io.*;
import java.util.Arrays;

public class ListAlfabeticament4 {
    //Afegeix la funcionalitat de llegir qualsevol fitxer TXT i
    // mostra el seu contingut per consola.
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            //directori es el primer argument
            String nom_directori = args[0];
            //creem un tipus File anomenat directory amb direcció de l'argument
            File directory;
            directory = new File(nom_directori);

            //llavors fem la funcionalitat de llegir qualsevol fitxer TXT .
            try {
                //Creem objecte fileReader i bufferedReader
                FileReader lectura = new FileReader(directory);
                BufferedReader bufferLectura = new BufferedReader(lectura);
                //Llegim fitxer i mostrem per pantalla mentre no estigui buit el que llegim
                String CurrentLine;
                while ((CurrentLine = bufferLectura.readLine()) != null) {
                    System.out.println(CurrentLine);
                }
                //Tanquem el stream
                bufferLectura.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

         } else {
        System.out.println("No hi ha cap directori");
        }
    }
 // exemple : /home/ivan/Escritorio/Tasca5/src/list4.txt
}



