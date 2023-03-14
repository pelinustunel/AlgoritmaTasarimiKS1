import java.util.Random;
// 4. Soru Cevabı
public class Main {
    public static void main(String[] args) {

        int array[] = new int[10000];
        int lenght = array.length;

        for(int i = 0; i< lenght; i++){
            Random random = new Random();
            int number = random.nextInt();
            array[i] = number;
        }


        long beginning1 = System.currentTimeMillis();

        // Quick Sort algoritmasının çağırılıp kullanılması.
        quickSort(array,0, lenght-1);

        long end1 = System.currentTimeMillis();

        long beginning2 = System.currentTimeMillis();

        //BruteForce için Bubble Sort algoritmasını kullandım.
        BubbleSort(array);

        long end2 = System.currentTimeMillis();

        // BruteForce ve Quick Sort Çalışma Süreleri
        long quickGecenZaman = end1 - beginning1;
        System.out.print("QuickSort ile geçen zaman: " + quickGecenZaman);
        System.out.println();
        long bubbleGecenZaman = end2 - beginning2;
        System.out.print("BruteForce ile geçen zaman: " + bubbleGecenZaman);

    }

    // Quick Sort da dizinin sıralanması
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

    //BruteForce için kullanılan Bubble Sort fonksiyonu
    public static void BubbleSort(int[] array){

        if(array == null || array.length == 0)
            return;

        int length = array.length;
        for (int j = 0; j < length - 1 ; j++) {
            for (int k = 0; k <length - j - 1 ; k++) {

                if(array[k] > array[k + 1]){

                    int swap = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = swap;
                }
            }
        }
    }
}