public class Cat {

    private int paws = 4;

    public int getPaws() {
        return paws;
    }

    public void setPaws(int newPaws) {
        if (newPaws > 4) {
            System.out.println("Таких котов не бывает");
        } else {
            paws = newPaws;
        }
    }

    String name;

    public void meow() {
        System.out.println("Мяу");
    }

    public int kus(Cat cat) {
        return 7;
    }

    public void move() {
        for (int i = 0; i < paws; i++) {
            System.out.println("1 раз шагнул");
        }
    }
}