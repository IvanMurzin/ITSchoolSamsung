public class Main {
    
    public static void printArray(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] a = new int[n][n];
        int x = 0;
        int y = n - 1;
        int k = 1;

        while (k <= n * n) {
            for (int i = 0; i < a.length; i++)
                if (a[x][i] == 0) a[x][i] = k++;


            for (int i = 0; i < a.length; i++)
                if (a[i][y] == 0) a[i][y] = k++;


            for (int i = a.length - 1; i >= 0; i--)
                if (a[y][i] == 0) a[y][i] = k++;


            for (int i = a.length - 1; i >= 0; i--)
                if (a[i][x] == 0) a[i][x] = k++;

            x++;
            y--;
        }

        printArray(a);
    }
}

