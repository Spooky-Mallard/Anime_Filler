package com.anime;

import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class App_Function_Test {
    /**
     * Rigorous Test :-)
     */
    App_Function app_class = new App_Function("D:/Anime");

    @Test
    public void getting_the_anime_name() {
        app_class.getAnime_name("Chainsaw Man Episode 7 English Dubbed - Watch cartoons online, Watch anime online, English dub anime.mp4");
        assertEquals("Chainsaw Man",app_class.currentAnime);
    }
    
    @Test
    public void getting_the_season_name() {
        app_class.getAnime_name(
                "Chainsaw Man Season 2 Episode 7 English Dubbed - Watch cartoons online, Watch anime online, English dub anime.mp4");
        assertEquals("Season 2", app_class.seasonsName);
    }
    
    @Test
    public void getting_the_first_letter() {
        app_class.getAnime_name("Chainsaw Man Episode 7 English Dubbed - Watch cartoons online, Watch anime online, English dub anime.mp4");
        app_class.getCurrentLetter();
        assertEquals('C', app_class.currentLetter);
    }
}
