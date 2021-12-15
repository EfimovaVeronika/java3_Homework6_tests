import java.util.Arrays;



public class ArrMethods {

    public static void main(String[] args) {


        int[] arr4 = new int[] {4, 0, 0, 0};
        System.out.println(Arrays.toString(remainArrLastFour(arr4)));

    }

    //Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    // Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    // идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
    // иначе в методе необходимо выбросить RuntimeException.
    //Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    //Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

    public static int[] remainArrLastFour(int[] arr) {
        if(arr.length == 0) {
            throw new RuntimeException("Массив пустой");
        }
        int temp = -1; // т.к. порядковый номер элемента массива не может быть отрицательным
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] == 4) {
                temp = i;
                break;
            }
        }
           if (temp == -1) {
               throw new RuntimeException("Массив не содержит не одной 4");
           }

        return Arrays.copyOfRange(arr, temp + 1 ,arr.length);
    }


//    Написать метод, который проверяет состав массива из чисел 1 и 4.
//    Если в нем нет хоть одной четверки или единицы, то метод вернет false;
//    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//[ 1 1 1 4 4 1 4 4 ] -> true
//[ 1 1 1 1 1 1 ] -> false
//[ 4 4 4 4 ] -> false
//[ 1 4 4 1 1 4 3 ] -> false

    public static boolean oneAndFourArr(int[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("Массив пустой");
        }
        int oneCount = 0;
        int fourCount = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 1 && arr[i] != 4) {
                return false;
            }
            if (arr[i] == 1) {
                    oneCount++;
            }
            if (arr[i] == 4) {
                    fourCount++;
            }
        }

        return oneCount != 0 && fourCount != 0;
    }
}
