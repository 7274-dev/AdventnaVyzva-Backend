package sk.mysterum.backend.selfdestruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SelfDestructClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 4999;

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        String serverResponse = input.readLine();

        socket.close();
    }

}
