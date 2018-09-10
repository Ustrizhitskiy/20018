import java.util.Scanner;

public class Bubble {
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

        int max;
        for (int i = 0; i < count; i++) {
            for (int j = 1; j < count - i; j++) {
                if (list[j-1] > list[j]) {
                    max = list[j-1];
                    list[j-1] = list[j];
                    list[j] = max;
                }
            }
        }
        System.out.print("Отсортированный массив: {");
        for (int i = 0; i < count; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println("\b\b}");
    }
}
