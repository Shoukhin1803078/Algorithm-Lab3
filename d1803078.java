package algorithm.lab;

import java.io.File;
import java.util.Scanner;

public class d1803078 {
static long count1=0;
static long count2=0;

    static void merge(int a[], int x, int y, int z) {
        int n1 = y - x + 1;
        int n2 = z - y;

        int temp1[] = new int[n1];
        int temp2[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            temp1[i] = a[x + i];
        }
        for (int j = 0; j < n2; ++j) {
            temp2[j] = a[y + 1 + j];
        }

        int i = 0, j = 0;
        int k = x;
        while (i < n1 && j < n2) {
            count1 += 2;
            if (temp1[i] <= temp2[j]) {
                count1++;
                a[k] = temp1[i];
                i++;
            } else {
                a[k] = temp2[j];
                j++;
            }
            k++;
        }
count1++;
        while (i < n1) {
            a[k] = temp1[i];
            i++;
            k++;
            count1++;
        }

        while (j < n2) {
            a[k] = temp2[j];
            j++;
            k++;
            count1++;
        }
    }

   static void Mergesort(int arr[], int l, int r) {
        if (l < r) {
            count1++;
            int m = (l + r) / 2;
            Mergesort(arr, l, m);
            Mergesort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void printArray(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
     static  int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            count2++;
            if (arr[j] <= pivot) 
            {
                count2 += 1;
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
       
        count2 += 1;
       

        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
 
  static void quicksort(int arr[], int low, int high) 
    { 
        if (low < high) 
        {   
            count2++;
            int pi = partition(arr, low, high); 
            quicksort(arr, low, pi-1); 
            quicksort(arr, pi+1, high); 
        } 
    } 
 
  
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        File f = new File("tenthousand_value.txt");
        try {
            Scanner sc = new Scanner(f);
            int a[];
            int b[];
            while (sc.hasNext()) {
                String s = sc.nextLine();
                int n = Integer.valueOf(s);
                a = new int[n];
            
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.valueOf(sc.next());
                }
                System.out.println("Previous Array is:");
                printArray(a);
                
                Mergesort(a, 0, a.length - 1);
             
                System.out.println("\n Sorted array by Merge sort is:");
                printArray(a);
               
            }
        } catch (Exception e) {
            System.out.println("Exceptions found");
        }
        try {
            Scanner sc1 = new Scanner(f);
           
            int b[];
            while (sc1.hasNext()) {
                String s = sc1.nextLine();
                int n1 = Integer.valueOf(s);
           
               b = new int[n1];
                for (int i = 0; i < n1; i++) {
                   b[i] = Integer.valueOf(sc1.next());
                }
               
                 quicksort(b, 0, n1-1); 
                System.out.println("\nSorted array by Quick sort is:");
                printArray(b);
             
            }
        } catch (Exception e) {
            System.out.println("Exceptions found");
        }
        System.out.println("Number of exchange operation in Merge sort is:"+count1);
        System.out.println("Number of exchange operation in Quick sort is:"+count2);
    }
}
