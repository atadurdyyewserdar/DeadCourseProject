package javaapplication5.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer implements Runnable {

    private int serverPort = 10998;

    private ServerSocket serverSocket = null;

    private boolean isStopped = false;

    public MultiThreadServer(int port) {
        this.serverPort = port;
    }

    public synchronized void stop() {
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
            System.out.println("Server started...");
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 10999", e);
        }
    }

    @Override
    public void run() {
        openServerSocket();
        while (!isStopped()) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                System.out.println("-------------------");
                System.out.println("Client connected...");
                new Thread(new ClientHandler(clientSocket, "MultiThreaded Server")).start();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadServer server = new MultiThreadServer(10998);
        Thread t = new Thread(server);
        t.start();
    }
}
