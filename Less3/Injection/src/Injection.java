import java.util.Arrays;
import java.util.Scanner;

public class Injection {

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

        int[] result = mergesort(list);

        System.out.print("Отсортированный массив: {");
        for (int i = 0; i < count; i++) {
            System.out.print(result[i] + ", ");
        }
        System.out.println("\b\b}");
    }

    public static int[] mergesort(int[] array) {
        int[] buffer1 = Arrays.copyOf(array, array.length);
        int[] buffer2 = new int[array.length];
        int[] result = mergesortIner(buffer1, buffer2, 0, array.length);
        return result;
    }

    public static int[] mergesortIner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return  buffer1;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortIner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortIner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2] ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
