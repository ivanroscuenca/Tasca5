package ex1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.StreamSupport;
import java.io.File;
import java.util.Arrays;

public class ListAlfabeticament {
//Crea una classe que llisti alfabèticament el contingut d'un directori rebut per paràmetre.
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            final String nom_directori =args[0] ;
            System.out.println("Directoris : ");
            DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(nom_directori));
            StreamSupport.stream(ds.spliterator(),false).sorted(Comparator.comparing(Path::toString)).forEach (p->{
                System.out.println("arxius :" +p);});
            return;
        }else {
            System.out.println("No hi ha cap directori");
        }
    //exemple : "/home/ivan/Escritorio/"
    }
}



