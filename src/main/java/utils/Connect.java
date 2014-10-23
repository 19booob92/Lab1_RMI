package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public abstract class Connect {

    private int port = 9999;
    private String ip = "127.0.0.1";

    public void checkConnections() throws IOException {
        ServerSocket socket = new ServerSocket(port);
        System.out.println("Read");

        try {
            Socket client = socket.accept();
            read(client);
        } finally {
            socket.close();
            checkConnections();
        }
    }

    public abstract void checkRequest(String inputMessage);


    private void read(Socket client) {

        StringBuffer inputString = new StringBuffer();

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            String readLine;

            while ((readLine = input.readLine()) != null) {
                inputString.append(readLine);
                inputString.append("\n");
            }

            input.close();
            System.out.println("Got message: " + inputString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Thread invoke = new Thread() {

            @Override
            public void run() {
                checkRequest(inputString.toString());
            }
        };
        invoke.start();

    }

    protected void write(String message, int port) {
        try {
            Socket socket = new Socket(ip, port);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println(message);

            writer.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
