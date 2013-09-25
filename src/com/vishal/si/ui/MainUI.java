/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vishal.si.ui;

import com.vishal.si.main.ImageRenderer;
import com.vishal.si.main.ReadSDF;
import com.vishal.si.main.Utility;
import com.vishal.si.struct.Drug;
import com.vishal.si.struct.Scaffold;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.smiles.smarts.SMARTSQueryTool;

/**
 *
 * @author Om Sai Ram
 */
public class MainUI extends javax.swing.JFrame {

    TreeMap<String, List<String>> invertedIndexMap;
    TreeMap<String, Drug> drugList;
    DefaultListModel queryResultData = new DefaultListModel();
    TreeMap<String, Scaffold> scaffoldList;
    ImageRenderer renderer = new ImageRenderer();
    SmilesParser sParser = new SmilesParser(DefaultChemObjectBuilder.getInstance());

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        hMapLoaderFrame.setSize(586, 200);
        queryResultList.setCellRenderer(new PanelRenderer());
        loadCachedHMapLoc();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hMapLoaderFrame = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        ssHMapLoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dHMapLoc = new javax.swing.JTextField();
        scfHMapLoc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        queryBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        sdFileChooser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        uniqueSMILE = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        scfStruct = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        scfBMFrame = new javax.swing.JLabel();
        scfLogP = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        scfName = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        queryResultList = new javax.swing.JList();
        status = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        hMapLoaderFrame.setTitle("HMap Loader");
        hMapLoaderFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hMapLoaderFrame.setLocationByPlatform(true);
        hMapLoaderFrame.setResizable(false);

        jLabel3.setText("Substructure HMap:");

        ssHMapLoc.setText("load...");
        ssHMapLoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ssHMapLocMouseClicked(evt);
            }
        });
        ssHMapLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssHMapLocActionPerformed(evt);
            }
        });

        jLabel4.setText("Drug HMap:");

        dHMapLoc.setText("load...");
        dHMapLoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dHMapLocMouseClicked(evt);
            }
        });

        scfHMapLoc.setText("load...");
        scfHMapLoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scfHMapLocMouseClicked(evt);
            }
        });

        jLabel7.setText("Scaffold HMap");

        jButton3.setText("Load");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hMapLoaderFrameLayout = new javax.swing.GroupLayout(hMapLoaderFrame.getContentPane());
        hMapLoaderFrame.getContentPane().setLayout(hMapLoaderFrameLayout);
        hMapLoaderFrameLayout.setHorizontalGroup(
            hMapLoaderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hMapLoaderFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hMapLoaderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hMapLoaderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scfHMapLoc)
                    .addComponent(dHMapLoc)
                    .addComponent(ssHMapLoc))
                .addContainerGap())
            .addGroup(hMapLoaderFrameLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jButton3)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        hMapLoaderFrameLayout.setVerticalGroup(
            hMapLoaderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hMapLoaderFrameLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(hMapLoaderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ssHMapLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(hMapLoaderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dHMapLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(hMapLoaderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(scfHMapLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        hMapLoaderFrame.getAccessibleContext().setAccessibleParent(getRootPane());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel5);

        jMenuItem2.setText("Cannonical smile");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scaffold Interpreter");
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Query box"));

        queryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("input your query here (SMILES,SMARTS) ");

        sdFileChooser.setText("SD File");
        sdFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdFileChooserActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("or  choose an SD file");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        uniqueSMILE.setText("Canonical SMILE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(queryBox, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sdFileChooser))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uniqueSMILE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sdFileChooser))
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(uniqueSMILE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("About the scaffold"));

        scfStruct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("IUPAC Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Bemis Murcko framework:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Log P:");

        scfName.setEditable(false);
        scfName.setBackground(javax.swing.UIManager.getDefaults().getColor("Menu.background"));
        scfName.setColumns(20);
        scfName.setLineWrap(true);
        scfName.setRows(2);
        scfName.setWrapStyleWord(true);
        scfName.setBorder(null);
        scfName.setDoubleBuffered(true);
        jScrollPane2.setViewportView(scfName);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(scfBMFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(scfLogP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scfStruct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(scfStruct, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(scfBMFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(scfLogP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        queryResultList.setModel(queryResultData);
        jScrollPane1.setViewportView(queryResultList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jPanel2);

        status.setForeground(new java.awt.Color(102, 102, 102));
        status.setText("Type in to search ");

        jMenu1.setText("HMaps");

        jMenuItem1.setText("Load");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void queryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queryBoxActionPerformed

    private void sdFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdFileChooserActionPerformed
        File sdFile = Utility.UI.getFile(queryBox, new FileNameExtensionFilter(" SD File (*.sdf) ", "sdf"));
        if (sdFile != null) {
            String smile;
            try {
                smile = ReadSDF.getSmilesFromFile(sdFile);
                smile = ReadSDF.getCanonicalSmiles(smile);
                queryBox.setText(smile);

            } catch (Exception ex) {
                Utility.UI.showInfoMessage(getRootPane(), "Error reading SDF File please check");
            }


        }
    }//GEN-LAST:event_sdFileChooserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        status.setText("Searching... please wait.");

        queryResultData.clear();
        scfLogP.setText("Not found");
        scfBMFrame.setText("Not found");
        scfName.setText("Not found");
        scfStruct.setIcon(null);
        new Thread() {
            @Override
            public void run() {
                if (HMapsLoaded()) {

                    String query = queryBox.getText().trim();

                    renderer.setHeight(scfStruct.getHeight());
                    renderer.setWidth(scfStruct.getWidth());
                    try {
                        scfStruct.setIcon(renderer.getIconFromSmiles(query));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }




                    Scaffold scf = (Scaffold) getQueryIndexFromMap(scaffoldList, query);
                    if (scf != null) {
                        scfName.setText(scf.getIUPACname());
                        scfLogP.setText(String.valueOf(scf.getLogP()));
                        scfBMFrame.setText(scf.getBMframework());
                    } else {
                        status.setText("Scaffold not found in the database!");
                    }

                    List<String> resList = (List<String>) getQueryIndexFromMap(invertedIndexMap, query);
                    if (resList != null) {
//               
                        status.setText(resList.size() + " results found in the database.");
                        for (String res : resList) {
                            try {
                                QueryResultPanel qResultPanel = new QueryResultPanel();
                                Drug resD = drugList.get(res.toLowerCase());
                                qResultPanel.setdName(resD.getName());
                                qResultPanel.setdSMILE(resD.getUniqueSMILE());
                                qResultPanel.setdInd(resD.getIndication());
                                qResultPanel.setdRef(resD.getDrugbankID());
                                renderer.setHeight(qResultPanel.getdStructDimension().height);
                                renderer.setWidth(qResultPanel.getdStructDimension().width);
                                qResultPanel.setdStruct(renderer.getIconFromSmiles(resD.getUniqueSMILE()));





                                queryResultData.addElement(qResultPanel);
//                                queryResultList.repaint();

                            } catch (InvalidSmilesException ex) {
                                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (CDKException ex) {
                                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {
                        Utility.UI.showInfoMessage(getRootPane(), "No drug contains the scaffold provided!");
                        status.setText("Scaffold not found in the database!");
                    }


                    // Utility.UI.showInfoMessage(getRootPane(), res.toString());        
                } else {
                    Utility.UI.showInfoMessage(getRootPane(), "HMaps not loaded!");
                }
            }
        }.start();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void ssHMapLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssHMapLocActionPerformed
        hMapLoaderFrame.setVisible(true);
    }//GEN-LAST:event_ssHMapLocActionPerformed

    private void ssHMapLocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ssHMapLocMouseClicked

        File file = Utility.UI.getFile(hMapLoaderFrame.getRootPane(), new FileNameExtensionFilter(" Cached HashMap files (*.hmap) ", "hmap"));
        if (file != null) {
            ssHMapLoc.setText(file.getAbsolutePath());
        }


    }//GEN-LAST:event_ssHMapLocMouseClicked

    private void dHMapLocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dHMapLocMouseClicked

        File file = Utility.UI.getFile(hMapLoaderFrame.getRootPane(), new FileNameExtensionFilter(" Cached HashMap files (*.hmap) ", "hmap"));
        if (file != null) {
            dHMapLoc.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_dHMapLocMouseClicked

    private void scfHMapLocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scfHMapLocMouseClicked
        File file = Utility.UI.getFile(hMapLoaderFrame.getRootPane(), new FileNameExtensionFilter(" Cached HashMap files (*.hmap) ", "hmap"));
        if (file != null) {
            scfHMapLoc.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_scfHMapLocMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        loadHMaps();
        hMapLoaderFrame.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        hMapLoaderFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cacheHMapLoc();
    }//GEN-LAST:event_formWindowClosing

    private boolean HMapsLoaded() {
        if (invertedIndexMap != null && drugList != null && scaffoldList != null) {
            return true;
        } else {
            return false;
        }
    }

    private Object getQueryIndexFromMap(TreeMap map, String query) {

        if (uniqueSMILE.isSelected()) {
//            System.out.println("map result: "+map.get(query));
            return map.get(query);
        } else {

            SMARTSQueryTool querytool;
            for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
                Entry e = (Entry) it.next();
                try {
                    querytool = new SMARTSQueryTool((String) e.getKey());
                    boolean result = querytool.matches(sParser.parseSmiles(query));
                    if (result == true) {
                        return e.getValue();
                    }
                } catch (CDKException ex) {
                    return null;
                }
            }
            return null;
        }
    }

    private void loadCachedHMapLoc() {
        File cacheFile = new File(Utility.USER_DIR +Utility.FILE_SEPERATOR+ "si.cache");
        if (cacheFile.exists()) {
            Object locs[] =  Utility.getObjectFromFile(cacheFile);
            ssHMapLoc.setText((String)locs[0]);
            dHMapLoc.setText((String)locs[1]);
            scfHMapLoc.setText((String)locs[2]);

            loadHMaps();

        }

    }

    private void cacheHMapLoc() {
        File cacheFile = new File(Utility.USER_DIR +Utility.FILE_SEPERATOR+"si.cache");
        Utility.saveObjectToFile(cacheFile, ssHMapLoc.getText(), dHMapLoc.getText(), scfHMapLoc.getText());
    }

    class PanelRenderer implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList jlist, Object value, int i, boolean isSelected, boolean bln1) {
            QueryResultPanel renderer = (QueryResultPanel) value;
            renderer.setBackground(isSelected ? Color.red : jlist.getBackground());
            return renderer;
        }
    }

    /**
     * @param args the command line argument
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dHMapLoc;
    private javax.swing.JFrame hMapLoaderFrame;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextField queryBox;
    private javax.swing.JList queryResultList;
    private javax.swing.JLabel scfBMFrame;
    private javax.swing.JTextField scfHMapLoc;
    private javax.swing.JLabel scfLogP;
    private javax.swing.JTextArea scfName;
    private javax.swing.JLabel scfStruct;
    private javax.swing.JButton sdFileChooser;
    private javax.swing.JTextField ssHMapLoc;
    private javax.swing.JLabel status;
    private javax.swing.JCheckBox uniqueSMILE;
    // End of variables declaration//GEN-END:variables

    private void loadHMaps() {
        try {
            invertedIndexMap = (TreeMap<String, List<String>>) Utility.getObjectFromFile(new File(ssHMapLoc.getText()))[0];
            drugList = (TreeMap<String, Drug>) Utility.getObjectFromFile(new File(dHMapLoc.getText()))[0];
            scaffoldList = (TreeMap<String, Scaffold>) Utility.getObjectFromFile(new File(scfHMapLoc.getText()))[0];
            status.setText("Loading successfully done!");
        } catch (Exception e) {
            status.setText("Error loading HMaps please check.");
        }
    }
}
