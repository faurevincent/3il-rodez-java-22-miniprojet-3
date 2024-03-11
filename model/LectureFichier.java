package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

/**
 * Permet la lecture du fichier texte et la récuperation des données nécessaire
 */
public class LectureFichier {

    /**
     * Chemin d'acce du fichier
     */
    private final Path CHEMIN_ACCE = Paths.get(System.getProperty("user.dir"), "mots.txt");

    /**
     * Mots et définitions des mots du fichier texte
     */
    private Map<Integer,Mot> mots;

    /**
     * Nombre de fichier present dans le fichier texte
     */
    private int taille;

    public LectureFichier() {
        this.mots = new TreeMap<>();
        taille = 0;
    }

    /**
     * Lecture du fichier
     */
    public void lecture(){
        int size = 0;

        try(BufferedReader br = Files.newBufferedReader(CHEMIN_ACCE)){
            String chaine;
            while ((chaine = br.readLine()) != null){
                String[] parts = chaine.split("\\s+", 2); // Séparer le mot et la définition
                Mot mot = new Mot(parts[0], parts[1]);
                size++;
                mots.put(size, mot);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        taille = size;
    }

    public Map<Integer, Mot> getMots() {
        return mots;
    }

    public int getTaille() {
        return taille;
    }
}
