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

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while (true) {

            String command = key.readLine();

            out.println(command);

            String serverResponse = in.readLine();
            System.out.println(serverResponse);

            //TODO FINISH RESPONSE

            socket.close();
        }
    }
}
