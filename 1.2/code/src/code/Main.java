package code;

/*
N - количество мостов во время экскурсии
H - высота автобуса
hi - высота каждого моста

5 12
4 6 11 10 14
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int H = scanner.nextInt();
        System.out.println();
        boolean crack = false;
        for (int i = 0; i < N; ++i) {
            int h = scanner.nextInt();
            if (h < H ) {
                System.out.println("Автобус врезался");
                crack = true;
                break;
            }
        }
        if (!crack) System.out.println("Автобус проехал");
    }
}