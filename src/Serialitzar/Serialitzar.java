package Serialitzar;

import java.io.*;
import java.util.Arrays;

public class Original {
    public static void main(String[] args) {
        Empleat[] personal = new Empleat[1];
        Empleat e1 = new Empleat("Ivan", 41, 1);
        personal[0] = e1;

        if (args.length > 0) {
            //directori es el primer argument
            String nom_directori = args[0];
            //Serialitzar
            //creem un tipus File anomenat directory amb direcció de l'argument on volem que vagi l'arxiu + arxiuSerialitzat.ser
            File directory = new File(nom_directori + "arxiuSerialitzat.ser");
            //Creem objectOutputStream i instanciem un nou objecte
            try {
                ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(directory));
                //escriure arraylist dintre del nou arxiu
                writeFile.writeObject(personal);
                writeFile.close();

//                Desserialitzar
//                Creem objectInputStream i instanciem un nou objecte
                ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(directory));
                //Emmagatzemem en altre array,fem casting i utilitzem readfile amb el mètode readObject
                Empleat[] personal2 = (Empleat[]) readFile.readObject();
                //mostrem per pantalla el nou arrayList personal2
                System.out.println(Arrays.toString(personal2));

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("La direcció on posar l'arxiu no existeix o és incorrecta");
        }

    }

}

//    static class Empleat implements Serializable {
//
//        private final String nom;
//
//        private final int edat;
//
//        private final int numEmpleat;
//
//        public Empleat(String nom, int edat, int numEmpleat){
//            this.nom = nom;
//            this.edat=edat;
//            this.numEmpleat = numEmpleat;
//
//        }
//
//        @Override
//        public String toString() {
//            return "Empleat{" +
//                    "nom='" + nom + '\'' +
//                    ", edat=" + edat +
//                    ", numEmpleat=" + numEmpleat +
//                    '}';
//        }
//
//    }
//    }

