import java.util.Random;
// 1. Soru Cevabı
public class Main {

    // QuickSort ile dizinin sıralandığı fonksiyon
    public static int divide(int[] array, int left, int right){

        int pivot = array[right];
        int j = (left - 1);

        for(int k = left; k < right; k++){
            if(array[k] <= pivot){
                j++;
                int swap = array[j];
                array[j] = array[k];
                array[k] = swap;
            }
        }
        int swap = array[j + 1];
        array[j + 1] = array[right];
        array[right] = swap;

        return j+1;
    }
    public static void quickSort(int array[],int left, int right){
        if(left < right){
            int pivot = divide(array,left,right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    public static void main(String[] args) {


        int array[] = new int[10000];
        int n = array.length;

        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int number = random.nextInt();
            array[i] = number;
        }

        long beginning1 = System.currentTimeMillis();

        System.out.println("BruteForce ile En Büyük Değer "+
                BruteForceFindMaximum(array));

        long end1 = System.currentTimeMillis();

        long beginning2 = System.currentTimeMillis();

       /* Quick sort ile sıralarken dizi sıralandıktan sonraki en büyük eleman en sonda olacağı
        için En büyük değeri ekrana bastırırken array[n - 1] yaparak sondaki elemanı aldım.
         */
        quickSort(array,0, n-1);
        System.out.println("Quick Sort ile En Büyük Değer: " + array[n - 1]);

        long end2 = System.currentTimeMillis();

        long quickRunningTime = end2 - beginning2;
        System.out.print("QuickSort ile Geçen Zaman: " + quickRunningTime);
        System.out.println();
        long bruteForceRunningTime = end1 - beginning1;
        System.out.print("BruteForce ile Geçen Zaman: " + bruteForceRunningTime);
    }

    // BruteForce ile maximum elemanın bulunması
    static int BruteForceFindMaximum(int array[])
    {
        int maximum = array[0];
        int j;
        int m = array.length;
        for (j = 1; j < m; j++) {
            if (array[j] > maximum) {
                maximum = array[j];
            }
        }
        return maximum;
    }

}