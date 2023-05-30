import java.util.Arrays;
import java.util.Random;
import java.lang.*;
import java.util.stream.*;


public class Main {
    public static int[] arr = {-1, 1, 0, -2, 2, 3, -3, 12, 3, -14, 2, 1};



    public static int[] generateArray(int size) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt();
        }
        return arr;
    }

    public static int maxIndex() {
        //наибольший индекс
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void sorted(){
        //Сортировка пузырьком
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void naimChet(){
        //наименьшее четное
        int res = IntStream.of(arr)
                .filter(x -> (x % 2) == 0)
                .min()
                .orElse(-1);
        System.out.println("Наименьшее четное: " + res);

        int res1 = IntStream.of(arr)
                .filter(x -> (x % 2) == 1)
                .max()
                .orElse(-1);
        System.out.println("Наименьшее нечетное: " + res1);
    }

    public static void chetAndNechetKolichestvo() {
        //кол-во четных и нечетных
        int ctr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                ctr++;
        }
        System.out.println("Кол-во четных: " + ctr);
        System.out.println("Кол-во не четных : " + (arr.length - ctr));
    }

    public static void poloshOtrizatelKolichestvo(){
        //кол-во положительных и отрицательных
        int negative = 0;
        long sum = 0L;
        int positive = 0;
        for (int i : arr) {
            if (i < 0) negative++;
            if (i > 0) {
                positive++;
                try {
                    sum += arr[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Кол-во отрицательных элементов: " + negative);
        System.out.println("Кол-во положительных элементов: " + positive);
        System.out.println("Сумма положительных элементов: " + sum);
    }

    public static void maxNechet(){

        int max = 0;

        for (int i = 0; i < 10; i++)
            if (arr[i] % 2 != 0 && arr[i] > max)
                max = arr[i];

        System.out.println("Набольший нечетный: " + max);

    }


    public static void main(String[] args) {
        //удаляет повторяющиеся элементы
        arr = Arrays.stream(arr).distinct().toArray();
        sorted();
        System.out.println("Наибольший индекс: " + maxIndex());
        naimChet();
        chetAndNechetKolichestvo();
        maxNechet();
    }
}









