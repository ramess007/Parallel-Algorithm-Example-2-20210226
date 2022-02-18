/**
    Sample program to demonstrate fork/join synchronization.
*/

public class ParallelAdd
{ 
   public static final int NUM_THREADS = 4;
   public static final int SIZE = 12;

   public static void main(String[] args)
   {  
      int [] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};
      System.out.println("The total sum is " + sum(array));
   }
   
/**
   Creates multiple threads to add array elements
   @param arr array of values to be added
   @return sum of array values
*/
   public static int sum(int[] arr)
   { 
      int result = 0;
      int gap = arr.length/NUM_THREADS;
      SumThread[] threads = new SumThread[NUM_THREADS];
      for(int i = 0; i < NUM_THREADS; i++)
      {
         threads[i] = new SumThread(arr, i*gap, (i+1)*gap);
         threads[i].start();
      }
      for(int i = 0; i < NUM_THREADS; i++)
      {
         try {
            threads[i].join();
         }
         catch (InterruptedException ex)
         {
            System.out.println(ex);
         }  
         result += threads[i].answer;
      }
      if(gap*NUM_THREADS < arr.length){
         for(int j = gap*NUM_THREADS; j<arr.length;j++)
         {
            result += arr[j];
         }
      }
      return result;
   }   
}