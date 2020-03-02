package javaapplication5.Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientConnection {

    private Socket connSocket = null;

    private ObjectOutputStream objectOutputStream = null;

    private ObjectInputStream objectInputStream = null;

    public ClientConnection() {
    }

    public void sendMessage(String message) {
        try {
            objectOutputStream.writeUTF(message);
            objectOutputStream.flush();
        } catch (IOException e) {
            System.out.println(e);
            close();
        }
    }

    public void sendObject(Object obj) {
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
        } catch (IOException ex) {
            System.out.println(ex);
            close();
        }
    }

    public Object readObject() {
        Object object = new Object();
        try {
            object = objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.getMessage());
            close();
        }
        return object;
    }

    public String readMessage() {
        String str = "";
        try {
            str = objectInputStream.readUTF();
        } catch (IOException ex) {
            close();
        }
        return str;
    }

    public void consoleConn() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        initConnection();
        String line = "";
        while (!line.equals("Exit")) {
            System.out.print("Enter: ");
            try {
                line = bufferedReader.readLine();
                sendMessage(line);
            } catch (IOException ex) {
                System.out.println(ex.getCause());
            }
        }
        try {
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getCause());
        }
        close();
    }

    public void initConnection() {
        try {
            objectOutputStream = new ObjectOutputStream(connSocket.getOutputStream());
            System.out.println("objectOutputStream");
            objectInputStream = new ObjectInputStream(connSocket.getInputStream());
            System.out.println("objectInputStream");
        } catch (IOException ex) {
            System.out.println("ClientConnection -> initConnection()" + ex.getCause());
        }
    }

    public ClientConnection(Socket socket) {
        connSocket = socket;
        System.out.println("connSocket");
    }

    public void close() {
        if (connSocket != null) {
            try {
                sendMessage("close");
                objectOutputStream.close();
                objectInputStream.close();
                connSocket.close();
                System.out.println("client socket closed");
            } catch (IOException e) {
            }
        }
    }

    public static void main(String[] args) {
        try {
            Socket connSocket = new Socket("localhost", 10998);
            ClientConnection clientConnection = new ClientConnection(connSocket);
            clientConnection.consoleConn();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
