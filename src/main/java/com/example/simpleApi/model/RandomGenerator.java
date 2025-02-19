package com.example.simpleApi.model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.amqp.AbstractRabbitListenerContainerFactoryConfigurer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RandomGenerator {
    public String generateRandomLetters(int n){
        int l = 97, r = 122; // border in ascii a-z
        Random random = new Random();
        StringBuilder sb = new StringBuilder(n);
        for(int i =0; i < n; i++)
            sb.append((char) (random.nextInt(r-l) + l)); // random number entre (0 et 97-122) + 97
        return sb.toString();
    }

    public String generateRandomWords(){ // faire avec le nom du fichier
        try{
            File f = new File("src/main/resources/top-10_000-french-words.txt");
            Scanner sc = new Scanner(f);
            StringBuilder sb = new StringBuilder();
            while(sc.hasNextLine()){
                sb.append(sc.nextLine().concat("\n"));
            }
            sc.close();
            return sb.toString();

        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getTopFrenchWords(){
        try{
            File f = new File("src/main/resources/top-10_000-french-words.txt");
            Scanner sc = new Scanner(f);
            ArrayList<String> jsonList = new ArrayList<>();
            while(sc.hasNextLine()){
                jsonList.add(sc.nextLine());
            }
            return jsonList;
        } catch (FileNotFoundException e) {
            // TODO: gérer proprement les exception avec joli message et status
            throw new RuntimeException(e);
        }
    }

    public String generateRandomWords(int n){
        try{
            List<String> dict = getTopFrenchWords();
            String words = "";
            Random r = new Random();
            for(int i =0; i< n; i++){
                words = words.concat(dict.get(r.nextInt(dict.size()-1)).concat(" "));
            }
            return words;
        }catch (RuntimeException e){
            return e.toString();
        }

    }
    // TODO: faire une methode pour générer phrases bullshit
    // trier les différents mots: verbes, nom, adjectifs,...
    // nom + verbe + liaison + ...
}
