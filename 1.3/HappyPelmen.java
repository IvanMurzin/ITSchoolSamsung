package code;


public class HappyPelmen {
    public static void main(String[] args) {
        boolean findHappy = true;
        for (int i = 0; findHappy; i++) {
            if (i != 5) System.out.println(i + " пельмень не счастливый :С");
            else {
                System.out.println(i + " пельмень счастливый!!! С;");
                findHappy = false;
            }
        }
    }
}