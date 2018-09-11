import java.util.Scanner;

public class StringSort {
    private static String[] createList() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число элементов массива: ");
        int count = in.nextInt();
        Scanner in2 = new Scanner(System.in);
        String[] list = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Введите " + (i + 1) + "-ый элемент массива: ");
            String a = in2.nextLine();
            list[i] = a;
        }
        return list;
    }

    private static void bubbleSort(String[] arr) {
        String max;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1].length() > arr[j].length()) {
                    max = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = max;
                }
            }
        }
    }

    public static void main (String[] args) {

        String[] list = createList();
        System.out.print("Введенный массив: {");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println("\b\b}");

        bubbleSort(list);
        System.out.print("Отсортированный массив:");
        System.out.print("{");
        for (String aList : list) {
            System.out.print(aList + ", ");
        }
        System.out.print("\b\b}");
    }
}
