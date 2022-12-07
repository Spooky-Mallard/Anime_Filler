package com.anime;

import java.io.File;
import java.nio.file.Files;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main 
{
    public static File APPDB = new File("./APP_DB.txt");

    public static void main( String[] args ) throws Exception
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                Filler_Panel main_window = new Filler_Panel();
                frame.add(main_window);
                frame.pack();
                frame.setVisible(true);
                // frame.setResizable(false);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
            }
        });
        
        
    }

    public static void run_program(RESULTSLIST_CLASS ResultsList) throws Exception{
        App_Function Anime_Filler = new App_Function(Files.readString(APPDB.toPath()));
        
        Anime_Filler.search_for_anime(new File(Anime_Filler.DOWNLOADSPath));
        
        Anime_Filler.Move_Dubbed_Anime(ResultsList);
    }
}
