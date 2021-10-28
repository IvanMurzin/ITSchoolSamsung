public class Main {

    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static void printArray(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int k = 1;
        int[][] a = new int[5][5];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = k;
                ++k;
            }
        printArray(a);
        System.out.println();
        System.out.println();
        int n = a.length;
        int m = a[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; --j) {
                System.out.print(a[j][i] + "\t");
            }
            System.out.println();
        }
    }
}