public class ScienceCat extends Cat{


    @Override
    public void meow() {
        super.move();
        System.out.println("F=ma");
    }

    public void science(){
        System.out.println(10*10);
    }


}
