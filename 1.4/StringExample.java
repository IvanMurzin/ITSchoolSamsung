package code;

public class StringExample {

    public static void main(String[] args) {
        String pelmeni = "I love Pelmeni!!!";
        System.out.println(pelmeni.contains("Pelmeni"));
        System.out.println(pelmeni.endsWith("!!!"));
        System.out.println(pelmeni.indexOf("love"));
        System.out.println(pelmeni.replace("love", "hate"));
        System.out.println(pelmeni.toUpperCase());
        System.out.println(pelmeni.toLowerCase());
        String num = "123";
        int a = Integer.parseInt(num);
    }
}
