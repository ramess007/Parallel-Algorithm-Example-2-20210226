//
// Sample Thread subclass to implement parallel addition of array elements
//

public class SumThread extends java.lang.Thread 
{
   int lo;   // will control array access
   int hi;   // will control array access
   int answer;
   int[] arr;

//
// Constructor to initialize low and high indices to be
// manipulated by this thread, as well as array reference
//
   public SumThread(int[] a, int l, int h) 
   { 
      lo = l; 
      hi = h; 
      arr = a;
      answer = 0;
   }

//
// Adds the elements in a fraction of the array indexed lo .. hi
// 
   public void run() 
   { 
      for (int i = lo; i < hi; i++)
         answer += arr[i];
      System.out.println("From " + lo + " to " + hi + " the sum is " + answer);
   }
}

