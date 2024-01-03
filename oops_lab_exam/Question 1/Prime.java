import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {
        
        generatePrime t1 = new generatePrime();
        checkPrime t2 = new checkPrime();

        t1.start();
        t1.setPriority(10);
        t2.start();
        
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class threadGetPrime1 extends Thread {
    @Override
    public void run() {
        for (int i = 2; i < 50; i++) {
            if (i == 2 || i == 3) {
                System.out.println(i + " ");
                continue;
            }

            int flag = 1;
            for (int j = 2; j < 50; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }

            if (flag == 1) {
                System.out.println(i + " ");
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class threadGetPrime2 extends Thread {
    @Override
    public void run() {
        for (int i = 51; i < 100; i++) {
            int flag = 1;
            for (int j = 2; j < 50; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }

            if (flag == 1) {
                System.out.println(i + " ");
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class checkPrime extends Thread {
    @Override
    public void run() {
        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for (int i = 2; i < a / 2; i++) {
            if (a % i == 0) {
                System.out.println("Not a Prime");
                break;
            }

            if (i > a / 2)
                System.out.println("Is Prime");
        }

        sc.close();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class generatePrime extends Thread {
    @Override
    public void run() {
        threadGetPrime1 t1 = new threadGetPrime1();
        threadGetPrime2 t2 = new threadGetPrime2();

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
