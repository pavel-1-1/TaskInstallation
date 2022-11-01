package inputOutputStreams.taskInstallation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        StringBuilder stringLog = new StringBuilder();

        stringLog.append(createCatalog("C://D//Games//src"));
        stringLog.append(createCatalog("C://D//Games//res"));
        stringLog.append(createCatalog("C://D//Games//savegames"));
        stringLog.append(createCatalog("C://D//Games//temp"));

        stringLog.append(createCatalog("C://D//Games//src//main"));
        stringLog.append(createCatalog("C://D//Games//src//test"));

        Myfile myfile = (n) -> {
            File file = new File(n);
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Date date = new Date();
            if (file.isFile()) {
                return "файл-" + n + " true" + " : " + date + "\n";
            } else {
                return "файл-" + n + " false" + " : " + date + "\n";
            }
        };

        stringLog.append(myfile.createFile("C://D//Games//src//main//Main.java"));
        stringLog.append(myfile.createFile("C://D//Games//src//main//Utils.java"));

        stringLog.append(createCatalog("C://D//Games//res//drawable"));
        stringLog.append(createCatalog("C://D//Games//res//vectors"));
        stringLog.append(createCatalog("C://D//Games//res//icons"));

        stringLog.append(myfile.createFile("C://D//Games//temp//temp.txt"));
        try (FileWriter writer = new FileWriter("C://D//Games//temp//temp.txt", false)) {
            writer.append(stringLog);
        } catch (IOException ignored) {

        }


    }

    private static String createCatalog(String newCatalog) {
        File catalog = new File(newCatalog);
        Date date = new Date();
        catalog.mkdir();
        if (catalog.isFile()) {
            return "папка-" + newCatalog + " true" + " : " + date + "\n";
        } else {
            return "папка-" + newCatalog + " false" + " : " + date + "\n";
        }
    }
}

interface Myfile {
    String createFile(String n);
}
