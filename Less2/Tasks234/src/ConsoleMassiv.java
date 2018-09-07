import java.util.Arrays;
import java.util.Scanner;

public class ConsoleMassiv {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число элементов массива: ");
        int count = in.nextInt();
        int[] list = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Введите " + i + "-ый элемент массива: ");
            int a = in.nextInt();
            list[i] = a;
        }

        System.out.print("Введенный массив: {");
        for (int i = 0; i < count; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println("\b\b}");

        Arrays.sort(list);
        System.out.println("Максимальный элемент массива: " + list[list.length - 1]);
        System.out.println("Минимальный элемент массива: " + list[0]);
    }
}
