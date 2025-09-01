//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int a[] = {10, 7, 8, 9, 1, 5};
        int n = a.length;

        int[] stack = new int[n];
        int top = -1;

        // Push initial range
        stack[++top] = 0;
        stack[++top] = n - 1;

        while (top >= 0) {
            int high = stack[top--];
            int low = stack[top--];

            int pivot = a[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (a[j] <= pivot) {
                    i++;
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

            int temp = a[i + 1];
            a[i + 1] = a[high];
            a[high] = temp;

            int pi = i + 1;

            // Push subarrays onto stack
            if (pi - 1 > low) {
                stack[++top] = low;
                stack[++top] = pi - 1;
            }
            if (pi + 1 < high) {
                stack[++top] = pi + 1;
                stack[++top] = high;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        }
    }
