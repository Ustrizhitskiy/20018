import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ParseWithScanner {
    public static void main (String args[]) throws IOException {
        File fileFrom = new File("FromThisFile.txt");
        if (fileFrom.createNewFile()) {
            System.out.println("FromThisFile.txt файл создан в корневой папке проекта.");
        } else System.out.println("Файл FromThisFile.txt уже существует в корневой папке проекта.");

        String appendText = "Добавляем пять слов в файл";
        String fileSeparator = System.getProperty("FromThisFile.txt");
        if (fileSeparator != null) {
            System.out.println(fileSeparator + fileFrom);
        } else System.out.println(fileFrom);
        appendUsingFileWriter(fileFrom, appendText);

        String fileName = "FromThisFile.txt";
        Path path = Paths.get(fileName);
        Scanner textScanner = new Scanner(path);
        String thirdWord = "";
        int k = 0;
        while (textScanner.hasNext()) {
            textScanner.next();
            if (k == 1) thirdWord = textScanner.next();
            k++;
        }

        File fileTo = new File("ToThisFile.txt");
        if (fileTo.createNewFile()) {
            System.out.println("ToThisFile.txt файл создан в корневой папке проекта.");
        } else System.out.println("Файл ToThisFile.txt уже существует в корневой папке проекта.");

        String appendTextTo = thirdWord;
        String fileSeparatorTo = System.getProperty("ToThisFile.txt");
        if (fileSeparatorTo != null) {
            System.out.println(fileSeparatorTo + fileTo);
        } else System.out.println(fileTo);
        appendUsingFileWriter(fileTo, appendTextTo);
    }

    private static void appendUsingFileWriter(File fileSeparator, String appendText) {
        try {
            FileWriter writer = new FileWriter(fileSeparator, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(appendText);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
