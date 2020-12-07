package sk.mysterum.backend.services.autoupdate;

import org.springframework.beans.factory.annotation.Value;

public class UtilMan {
    //This code will only look for the file in the home directory
    //ONLY FOR LINUX
    @Value("${app.upload.dir:${user.home}}")
    private String homeDir;

    private static String OS = null;

    private static String getOSName(){

        if (OS == null){ OS = System.getProperty("os.name");
            return OS;
        }else {return null;}
    }

    private static boolean isWin(){
        if (getOSName().startsWith("Windows")){
            System.out.println("Sorry, AutoUpdate only works with linux machines.\nIf you want to get upgrades automatically, please consider upgrading to linux machine.\n You can still update automatically");
            return true;
        } else {return false;}
    }

    private static boolean isUnix(){
        if (getOSName().startsWith("Linux")){
            return true;
        } else {return false;}
    }

}
