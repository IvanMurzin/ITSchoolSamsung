package code;


import java.util.Scanner;

/*
Для игры используются карточки от 1 до N
Одна карточка потерялась
Необходимо найти потерю
1<=N<=10^4

5
1 2 3 4
5

4
3 4 1
2
 */
public class LostCard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = (1 + n) * n / 2;
        for (int i = 0; i < n; i++)
            sum -= in.nextInt();
        System.out.println(sum);



    }
}
// 1 2 3 4
// (a1 + an)/2*n