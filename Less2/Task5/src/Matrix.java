import java.util.Scanner;

public class Matrix {
    //private static String a;

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число строк массива: ");
        int m = in.nextInt();
        System.out.print("Введите число столбцов массива: ");
        int n = in.nextInt();
        Scanner in2 = new Scanner(System.in);
        String[][] matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Введите элемент [" + i + "][" + j + "]: ");
                String a = in2.nextLine();
                matrix[i][j] = a;
            }
        }
        System.out.println("Введенный массив:");
        for (int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%10s", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
