import java.util.*;

class HeapSort1{

    static void heapSort(int[] arr){
        int n = arr.length;
        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }

        for(int i = n - 1; i > 0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i){

        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] generateRandomArray(int n){

        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++){
            arr[i] = random.nextInt(100000);
        }

        return arr;
    }

    static int[] generateAscendingArray(int n){

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        return arr;
    }
    static int[] generateDescendingArray(int n){

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }

        return arr;
    }
    static boolean isSorted(int[] arr){

        for (int i = 1; i < arr.length; i++) {

            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }

        return true;
    }

    static double measureTime(int[] arr){

        long start = System.nanoTime();
        heapSort(arr);

        long end = System.nanoTime();

        return (end - start) / 1_000_000.0;
    }

    public static void main(String[] args){

        int[] sizes = {
            1000,
            5000,
            10000,
            20000,
            50000
        };

        System.out.println(
            "Size\tRandom(ms)\tAscending(ms)\tDescending(ms)"
        );

        for (int n : sizes) {

            int[] random = generateRandomArray(n);
            int[] ascending = generateAscendingArray(n);
            int[] descending = generateDescendingArray(n);

            double randomTime = measureTime(random);
            double ascendingTime = measureTime(ascending);
            double descendingTime = measureTime(descending);

            boolean randomSorted = isSorted(random);
            boolean ascendingSorted = isSorted(ascending);
            boolean descendingSorted = isSorted(descending);

            System.out.printf(
                "%d\t%.3f\t\t%.3f\t\t%.3f%n",
                n,
                randomTime,
                ascendingTime,
                descendingTime
            );

            System.out.println(
                "Sorted: " +
                randomSorted + ", " +
                ascendingSorted + ", " +
                descendingSorted
            );
        }
    }
}