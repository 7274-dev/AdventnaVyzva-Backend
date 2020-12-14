package sk.mysterum.backend.services.autoupdate;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Elevator {

    private static void startProccess(){
        String[] cmd = new String[] {"deploy.sh"};
        ProcessBuilder processBuilder = new ProcessBuilder(cmd);

        try {
            Process p = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = null;
            while ((s = reader.readLine()) != null){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Daemon Elevator is running");
        System.out.println("                            ,-.\n" +
                "       ___,---.__          /'|`\\          __,---,___\n" +
                "    ,-'    \\`    `-.____,-'  |  `-.____,-'    //    `-.\n" +
                "  ,'        |           ~'\\     /`~           |        `.\n" +
                " /      ___//              `. ,'          ,  , \\___      \\\n" +
                "|    ,-'   `-.__   _         |        ,    __,-'   `-.    |\n" +
                "|   /          \\\\_  `   .    |    ,      _//          \\   |\n" +
                "\\  |           \\ \\`-.___ \\   |   / ___,-'/ /           |  /\n" +
                " \\  \\           | `._   `\\\\  |  //'   _,' |           /  /\n" +
                "  `-.\\         /'  _ `---'' , . ``---' _  `\\         /,-'\n" +
                "     ``       /     \\    ,='/ \\`=.    /     \\       ''\n" +
                "             |__   /|\\_,--.,-.--,--._/|\\   __|\n" +
                "             /  `./  \\\\`\\ |  |  | /,//' \\,'  \\\n" +
                "            /   /     ||--+--|--+-/-|     \\   \\\n" +
                "           |   |     /'\\_\\_\\ | /_/_/`\\     |   |\n" +
                "            \\   \\__, \\_     `~'     _/ .__/   /\n" +
                "             `-._,-'   `-._______,-'   `-._,-'");
        while (true){
            startProccess();
            Thread.sleep(7200000);
        }
    }
}
