package sk.mysterum.backend.selfdestruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SelfDestructServer {

    private static final int PORT = 4999;
    private static final String CODE_PASSWORD = "937168425";

    public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(PORT);
        Socket client = listener.accept();
        System.out.println("[SERVER]: Client Connected");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        listener.close();
        client.close();
    }
}
