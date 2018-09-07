import java.util.Scanner;

public class List5elements {
    public static void main(String[] args) {

        String[] listString = new String[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Введите " + i + "-ый элемент массива: ");
            String a = sc.nextLine();
            listString[i] = a;
        }
        System.out.print("Введенный массив: {");
        for (int i = 0; i < 5; i++) {
            System.out.print(listString[i] + ", ");
        }
        System.out.println("\b\b}");
    }
}
