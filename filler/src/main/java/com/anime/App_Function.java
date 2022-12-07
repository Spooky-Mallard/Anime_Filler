package com.anime;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class App_Function {
    String animePath;
    String DOWNLOADSPath;
    String dubbedPath;
    String subbedPath;
    String currentAnime;
    String seasonsName;
    String to_path;
    char currentLetter;


    File AnimeFolder;

    List<File> Anime_in_Downloads_Dubbed;
    List<File> Anime_in_Downloads_Subbed;

    public App_Function(String anime_path){
        this.AnimeFolder = new File(anime_path);
        this.dubbedPath = anime_path+"/Dubbed";
        this.subbedPath = anime_path+"/Subbed";
        this.DOWNLOADSPath = anime_path+"/DOWNLOADS";
        this.Anime_in_Downloads_Dubbed = new ArrayList<File>();
        this.Anime_in_Downloads_Subbed = new ArrayList<File>();
    }

    public void search_for_anime(File Downloads){
        File[] files = Downloads.listFiles();

        for (File file : files){
            String path = file.getAbsolutePath();
            if (path.contains("English Dubbed")){
                Anime_in_Downloads_Dubbed.add(file);
            }
            else if(path.contains("English Subbed")){
                Anime_in_Downloads_Subbed.add(file);
            }
        }
    }

    public void getAnime_name(String Anime) {
        this.currentAnime = Anime.substring(0, Anime.indexOf(" Episode") );
        if (currentAnime.contains("Season")){
            this.seasonsName = currentAnime.substring(currentAnime.indexOf("Season"), currentAnime.length());
            this.currentAnime = currentAnime.substring(0, currentAnime.indexOf(" Season"));
        }
    }

    public void getCurrentLetter() {
        this.currentLetter = currentAnime.charAt(0);
    }

    public void checkDir(String dir){
        File path = new File(dir);
        if ((path.exists()) == false){
            path.mkdir();
        }
    }

    public void moveAnime(Path moveFrom_path, Path moveTo_path) throws Exception{
        Files.move(moveFrom_path, moveTo_path, StandardCopyOption.REPLACE_EXISTING);

    }

    public void Move_Dubbed_Anime(RESULTSLIST_CLASS ResultsList) throws Exception{
        for (File Anime: Anime_in_Downloads_Dubbed){
            getAnime_name(Anime.getName());
            getCurrentLetter();
            checkDir(dubbedPath+"/"+currentLetter);

            if (seasonsName==null){
                to_path = dubbedPath + "/" + currentLetter + "/" + currentAnime;
            }
            else{
                to_path = dubbedPath + "/" + currentLetter + "/" + currentAnime + "/" + currentAnime+" "+seasonsName;
            }
            checkDir(to_path);
            
            Path moveTo_path = (new File(to_path+"/"+Anime.getName())).toPath();
            Path moveFrom_path = Anime.toPath();

            moveAnime(moveFrom_path, moveTo_path);

            System.out.println("Done "+Anime.getName());
            ResultsList.log.add("Done "+Anime.getName());
            ResultsList.updateUI();

        }
    }
    
    public void Copy_Subbed_Anime(RESULTSLIST_CLASS ResultsList) throws Exception{
        for (File Anime: Anime_in_Downloads_Subbed){
            getAnime_name(Anime.getName());
            getCurrentLetter();
            checkDir(subbedPath+"/"+currentLetter);

            String to_path = subbedPath+"/"+currentLetter+"/"+currentAnime;
            checkDir(to_path);
            
            Path moveTo_path = (new File(to_path+"/"+Anime.getName())).toPath();
            Path moveFrom_path = Anime.toPath();

            moveAnime(moveFrom_path, moveTo_path);

            System.out.println("Done "+Anime.getName());
            ResultsList.log.add("Done "+Anime.getName());
            ResultsList.updateUI();

        }   
    }
}
