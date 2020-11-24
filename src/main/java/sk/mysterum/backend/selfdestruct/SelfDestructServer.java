package sk.mysterum.backend.selfdestruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SelfDestructServer {
    private static final String HOST = "localhost";
    private static final int PORT = 4999;
    private static final String CODE_PASSWORD = "937168425";

    public static void main(String[] args) throws IOException {

        SelfDestruct sd = new SelfDestructService();

        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket s = serverSocket.accept();
        System.out.println("Client Connected");

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));

        out.println("Hello MagSG");

        while (true) {

            String request = bufferedReader.readLine();

            if (request.contains("self_destruct_start")){

                out.println("Launch Code?");

                if (bufferedReader.readLine().contains(CODE_PASSWORD)){

                    out.println("Are you absolutely sure you want to delete everything?");

                    if (bufferedReader.readLine().contains("yes")){ sd.destroyEverything(); }
                    //TODO deleting

                }

            }


            if (request.contains("quit")){break;}
        }
        s.close();
        serverSocket.close();
    }
}
