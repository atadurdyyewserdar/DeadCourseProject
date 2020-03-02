package javaapplication5;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication5.Connection.ClientConnection;
import javaapplication5.GUI.UserGui;
import javax.swing.SwingUtilities;

public class main {

    public static void main(String[] args) {
        try {
            Socket connSocket = new Socket("localhost", 10998);
            ClientConnection clientConnection = new ClientConnection(connSocket);
            clientConnection.initConnection();
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(UserGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(UserGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(UserGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(UserGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    UserGui userGui = new UserGui(clientConnection);
                    userGui.setVisible(true);
                }
            });
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
