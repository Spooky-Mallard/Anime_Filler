package com.anime;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Filler_Panel extends JPanel{
    private JScrollPane jScrollPane1;
    static RESULTSLIST_CLASS ResultsList = new RESULTSLIST_CLASS();

    public Filler_Panel(){
        this.jScrollPane1 = new javax.swing.JScrollPane();

        this.setVisible(true);

        frameInit();

    }

    
    public void frameInit() {

        RUNBUTTON_CLASS RunButton = new RUNBUTTON_CLASS();
        OPTIONSBUTTON_CLASS OptionsButton = new OPTIONSBUTTON_CLASS();
        

        jScrollPane1.setViewportView(ResultsList);


        javax.swing.GroupLayout FillerPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(FillerPanelLayout);
        FillerPanelLayout.setHorizontalGroup(
            FillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FillerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(FillerPanelLayout.createSequentialGroup()
                        .addComponent(RunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OptionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)))
                .addContainerGap())
        );
        FillerPanelLayout.setVerticalGroup(
            FillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FillerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OptionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );
        

    }

    

}

class RUNBUTTON_CLASS extends JButton{
    public RUNBUTTON_CLASS(){
        this.setText("RUN");
        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    RunButtonActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    private void RunButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                          
        // TODO add your handling code here:
        Main.run_program(Filler_Panel.ResultsList);
    }                                         

}

class OPTIONSBUTTON_CLASS extends JButton{
    public OPTIONSBUTTON_CLASS(){
        this.setText("OPTIONS");
        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsButtonActionPerformed(evt);
            }
        });

    }
    private void OptionsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                OPTIONSDIALOGBOX OptionsDialog = new OPTIONSDIALOGBOX();
                OptionsDialog.pack();
                // OptionsDialog.dialogInit();
            }
        });
    } 
}

class RESULTSLIST_CLASS extends javax.swing.JList<String>{
    List<String> log = new ArrayList<String>();

    public RESULTSLIST_CLASS(){
        this.setModel(new javax.swing.AbstractListModel<String>() {
            
            public int getSize() { return log.size(); }
            
            public String getElementAt(int i) { return log.get(i); }
        });
        
    }

}

class OPTIONSDIALOGBOX extends JDialog{
    public OPTIONSDIALOGBOX(){
        
        dialogInit();
    }

    public void dialogInit(){
        this.setRootPane(new JRootPane());
        this.setVisible(true);
        // frame.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel DirectoryLabel = new javax.swing.JLabel();
        DIRECTORYFIELD_CLASS DirectoryField = new DIRECTORYFIELD_CLASS();
        
        DirectoryLabel.setText("ANIME DIRECTORY");

        javax.swing.GroupLayout OptionsDiaLayout = new javax.swing.GroupLayout(this.getRootPane());
        this.getRootPane().setLayout(OptionsDiaLayout);
        OptionsDiaLayout.setHorizontalGroup(
            OptionsDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionsDiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DirectoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DirectoryField, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
        OptionsDiaLayout.setVerticalGroup(
            OptionsDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionsDiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OptionsDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DirectoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DirectoryField, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        
        // this.rootPane.setLayout(OptionsDiaLayout);

    }
}

class DIRECTORYFIELD_CLASS extends JTextField{
    public DIRECTORYFIELD_CLASS(){
        this.setVisible(true);
        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                try {
                    DirectoryFieldActionPerformed(evt);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
    private void DirectoryFieldActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                               
        Files.writeString(Main.APPDB.toPath(), this.getText());
    }   
}
