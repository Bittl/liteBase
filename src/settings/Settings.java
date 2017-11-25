package settings;

import java.io.File;

public class Settings {

    private static String filename = "Settings.set";
    private static File settings;


    public void createFile(){
        settings = new File(filename);

    }



}
