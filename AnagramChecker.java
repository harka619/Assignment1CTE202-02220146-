package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        System.out.println("Enter the number of pairs of strings to check:\t");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            String str1 = input[0];
            String str2 = input[1];

            if (isAnagram(str1, str2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        scanner.close();
    }

    // Check if two strings are anagrams
    public static boolean isAnagram(String s1, String s2) {
        // Remove spaces and convert to lowercase
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        // Check if the lengths of the strings are equal
        if (s1.length() != s2.length()) {
            return false; // If lengths are not equal, they can't be anagrams
        }

        // Convert strings to character arrays and sort them using QuickSort
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        quickSort(charArray1, 0, charArray1.length - 1);
        quickSort(charArray2, 0, charArray2.length - 1);

        // Compare the sorted character arrays
        return Arrays.equals(charArray1, charArray2);
    }

    // QuickSort implementation
    public static void quickSort(char[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partitioning step of QuickSort
    private static int partition(char[] arr, int low, int high) {
        char pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        char temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
