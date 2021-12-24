package com.company;

public class Main {
//    static Integer money = 100;
//
//
//    static class Client implements Runnable {
//        @Override
//        public void run() {
//            synchronized (money) {
//                if (money - 70 > 0) {
//                    System.out.println("Я начал покупать!");
//                    bancomatStaff();
//                    money -= 70;
//                    System.out.println("На счете осталось " + money);
//                } else System.out.println("Недостаточно средств");
//            }
//        }
//
//
//        private void bancomatStaff() {
//            try {
//                Thread.sleep((long) (1000*Math.random())); // имитация работы банкомата
//            } catch (Exception ignored) {
//            }
//        }
//    }


    static class MyHouse {
        boolean pelmeniIsReady = false;

        public void eatPelmeni() {
            try {
                synchronized (this) {
                    while (!pelmeniIsReady) {
                        System.out.println("Я томно жду");
                        wait();
                        System.out.println("Ура! Дождался!");
                    }
                    System.out.println("Омномном");
                }
            } catch (Exception e) {
            }
        }

        public void pelmeniCooked(){
            synchronized (this){
                pelmeniIsReady = true;
                System.out.println("Ура, готово");
                notifyAll();
            }
        }
    }



    static MyHouse myHouse;
    static class MyThread implements Runnable{
        @Override
        public void run() {
            myHouse.eatPelmeni();
        }
    }
        public static void main(String[] args) {
        try {
//        Client Vasya = new Client();
//        Client Petya = new Client();
//        Thread threadVasya = new Thread(Vasya);
//        Thread threadPetya = new Thread(Petya);
//        threadPetya.start();
//        threadVasya.start();
            myHouse = new MyHouse();
            Thread myThread = new Thread(new MyThread());
            myThread.start();
            Thread.sleep(1000);
            myHouse.pelmeniCooked();
        }catch (Exception e){}
        }
    }