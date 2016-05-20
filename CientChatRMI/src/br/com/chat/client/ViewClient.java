package br.com.chat.client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ViewClient extends javax.swing.JFrame {

    String nome;

    public ViewClient() {
        initComponents();
        startCleint();
        writeUserPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btEnviar = new javax.swing.JToggleButton();
        tfMensage = new javax.swing.JTextField();
        lbDigite = new javax.swing.JLabel();
        spUser = new javax.swing.JScrollPane();
        ltusur = new javax.swing.JList<>();
        spLog = new javax.swing.JScrollPane();
        taLog = new javax.swing.JTextArea();
        lbsituacaoClient = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/chat/image/comment_new.gif"))); // NOI18N
        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        tfMensage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMensageKeyReleased(evt);
            }
        });

        lbDigite.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lbDigite.setForeground(new java.awt.Color(0, 0, 255));
        lbDigite.setText("Digite...");

        spUser.setViewportView(ltusur);

        taLog.setEditable(false);
        taLog.setColumns(20);
        taLog.setRows(5);
        spLog.setViewportView(taLog);

        lbsituacaoClient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbsituacaoClient.setForeground(new java.awt.Color(51, 0, 255));
        lbsituacaoClient.setText("lbsituacaoClient");

        jMenu1.setText("Arquivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfMensage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbDigite)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spLog, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spUser, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(lbsituacaoClient, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbsituacaoClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spUser, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(spLog))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDigite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMensage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        if (!"".equals(tfMensage.getText())) {
            enviar();
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    private void tfMensageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMensageKeyReleased
        if (evt.getKeyCode() == 10) {
            if (!"".equals(tfMensage.getText())) {
                enviar();
            }
        }
    }//GEN-LAST:event_tfMensageKeyReleased

    public void releasesConecxão() {
//        remoteServer.liberaConexao(idClient)
    }

//    public void 

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void enviar() {
        String mensage = taLog.getText() + nome + " diz: "
                + tfMensage.getText() + "\n ";
        taLog.setText(mensage);
        tfMensage.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewClient().setVisible(true);
            }
        });
    }

    private void writeUserPanel() {
        nome = "inicial";
        while (("inicial".equals(nome)) || ("".equals(nome))) {
            nome = JOptionPane.showInputDialog(" Infomo o seu nome por favor:");
        }
        String[] users = {nome};
        ltusur = new JList<>(users);
        ltusur.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        spUser.setViewportView(ltusur);
    }

    private void startCleint() {
        try {
            Client client = new Client();
            client.startClient();
            lbsituacaoClient.setText("Cliente conectado!");
        } catch (RemoteException ex) {
            lbsituacaoClient.setText("Sevidor não encontrado na rede local!");
            JOptionPane.showMessageDialog(null, " Sevidor não encontrado na rede local!");
        } catch (IOException ex) {
            lbsituacaoClient.setText("Cliente deconectado!");
            Logger.getLogger(ViewClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            lbsituacaoClient.setText("Cliente deconectado!");
            JOptionPane.showMessageDialog(null, " Sevidor não encontrado na rede local!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btEnviar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lbDigite;
    private javax.swing.JLabel lbsituacaoClient;
    private javax.swing.JList<String> ltusur;
    private javax.swing.JScrollPane spLog;
    private javax.swing.JScrollPane spUser;
    private javax.swing.JTextArea taLog;
    private javax.swing.JTextField tfMensage;
    // End of variables declaration//GEN-END:variables

}
