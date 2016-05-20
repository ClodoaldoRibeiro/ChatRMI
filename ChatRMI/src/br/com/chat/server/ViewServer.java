package br.com.chat.server;

import java.rmi.RemoteException;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class ViewServer extends javax.swing.JFrame {

    private static Server server;
    private String logServidorMensager = "";

    public ViewServer() {
        initComponents();
        server = null;
        lbSituacaoServer.setText("Servidor Parado, :)");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnServerStatus = new javax.swing.JPanel();
        btServerStatus = new javax.swing.JButton();
        lbSituacaoServer = new javax.swing.JLabel();
        pnUsersConnected = new javax.swing.JPanel();
        spUsersConnected = new javax.swing.JScrollPane();
        pnLogServer = new javax.swing.JPanel();
        spLogServer = new javax.swing.JScrollPane();
        taLogServer = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setLocationByPlatform(true);
        setResizable(false);

        pnServerStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Situação do Servidor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        btServerStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/chat/image/PlayAzulPNG.png"))); // NOI18N
        btServerStatus.setName("btServerStatus"); // NOI18N
        btServerStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btServerStatusActionPerformed(evt);
            }
        });

        lbSituacaoServer.setFont(new java.awt.Font("Calibri", 2, 12)); // NOI18N
        lbSituacaoServer.setForeground(new java.awt.Color(51, 51, 51));
        lbSituacaoServer.setText("lbSituacaoServer");
        lbSituacaoServer.setName("lbSituacaoServer"); // NOI18N

        javax.swing.GroupLayout pnServerStatusLayout = new javax.swing.GroupLayout(pnServerStatus);
        pnServerStatus.setLayout(pnServerStatusLayout);
        pnServerStatusLayout.setHorizontalGroup(
            pnServerStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnServerStatusLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lbSituacaoServer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnServerStatusLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(btServerStatus)
                .addGap(116, 116, 116))
        );
        pnServerStatusLayout.setVerticalGroup(
            pnServerStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnServerStatusLayout.createSequentialGroup()
                .addComponent(lbSituacaoServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btServerStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnUsersConnected.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuários Conectados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        javax.swing.GroupLayout pnUsersConnectedLayout = new javax.swing.GroupLayout(pnUsersConnected);
        pnUsersConnected.setLayout(pnUsersConnectedLayout);
        pnUsersConnectedLayout.setHorizontalGroup(
            pnUsersConnectedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spUsersConnected, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );
        pnUsersConnectedLayout.setVerticalGroup(
            pnUsersConnectedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spUsersConnected)
        );

        pnLogServer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log do Servidor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        taLogServer.setEditable(false);
        taLogServer.setColumns(20);
        taLogServer.setRows(5);
        spLogServer.setViewportView(taLogServer);

        javax.swing.GroupLayout pnLogServerLayout = new javax.swing.GroupLayout(pnLogServer);
        pnLogServer.setLayout(pnLogServerLayout);
        pnLogServerLayout.setHorizontalGroup(
            pnLogServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spLogServer)
        );
        pnLogServerLayout.setVerticalGroup(
            pnLogServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spLogServer, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Configurações");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnServerStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnLogServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnUsersConnected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnUsersConnected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(pnServerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnLogServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btServerStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btServerStatusActionPerformed

        if (server == null) {
            try {
                server = new Server();
                server.startServer();
                if (server.situationServer == SituationServer.START) {
                    getUsersConnected();
                    btServerStatus.setIcon(new ImageIcon(getClass().getResource("/br/com/chat/image/StopAzulPNG.png")));
                    lbSituacaoServer.setText("Servidor em Execução...");
                }
                loadLogServer(logServidorMensager + server.getLogServer() + " \n");;
            } catch (RemoteException ex) {
                if (server == null) {
                    System.err.println("Erro ao tentar obter servidor!");
                }
            }
        } else {
            server.stopServer();
            server.situationServer = SituationServer.STOP;
            getUsersConnected();
            logServidorMensager += server.getLogServer() + "\n";;
            loadLogServer(logServidorMensager);
            server = null;
            lbSituacaoServer.setText("Servidor Parado, :)");
            btServerStatus.setIcon(new ImageIcon(getClass().getResource("/br/com/chat/image/PlayAzulPNG.png")));
        }
    }//GEN-LAST:event_btServerStatusActionPerformed

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
            java.util.logging.Logger.getLogger(ViewServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewServer().setVisible(true);
            }
        });
    }

    private void loadLogServer(String log) {
        taLogServer.setText(log);
    }

    private void getUsersConnected() {

        if (server.situationServer != SituationServer.STOP) {
            String[] users = server.getUser();
            
            listUsersConnected = new JList<>(users);
            listUsersConnected.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            spUsersConnected.setViewportView(listUsersConnected);
        } else {
            listUsersConnected = new JList<>();
        }
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btServerStatus;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbSituacaoServer;
    private javax.swing.JPanel pnLogServer;
    private javax.swing.JPanel pnServerStatus;
    private javax.swing.JPanel pnUsersConnected;
    private javax.swing.JScrollPane spLogServer;
    private javax.swing.JScrollPane spUsersConnected;
    private javax.swing.JTextArea taLogServer;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JList<String> listUsersConnected;
}
