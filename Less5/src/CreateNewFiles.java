import java.io.*;

public class CreateNewFiles {
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

        FileReader fr = new FileReader(fileFrom);
        BufferedReader temp = new BufferedReader(fr);
        String line = temp.readLine();

        String thirdWord = "";
        char space = ' ';
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == space) count++;
            if (count == 2) thirdWord += line.charAt(i + 1);
        }
        System.out.println(thirdWord);

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
