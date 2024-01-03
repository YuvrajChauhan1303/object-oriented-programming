public class Trading {

    // Creating an Interface
    public interface Tradeable {
        void buy(int quantity);
        void sell(int quantity);
    }

    public static class Stock implements Tradeable {
        private int totalQuantity;

        public void buy(int quantity) {
            synchronized (this) {
                this.totalQuantity += quantity;
                System.out.println("Stock Bought!!\nAmount Bought: " + quantity);
                System.out.println(this.toString());
                System.out.println();
            }
        }

        public void sell(int quantity) {
            synchronized (this) {
                this.totalQuantity -= quantity;
                System.out.println("Stock Sold!!\nAmount Sold: " + quantity);
                System.out.println(this.toString());
                System.out.println();
            }
        }

        public Stock(int quantity) {
            this.totalQuantity = quantity;
            System.out.println("Stock Initialized!!\nInitial Quantity: " + quantity);
            System.out.println(this.toString());
            System.out.println();
        }

        public int getTotalQuantity() {
            return totalQuantity;
        }

        @Override
        public String toString() {
            return "Total Stock Quantity =" + totalQuantity;
        }
    }

    public static class TradingThread extends Thread {
        private Tradeable tradeable;
        private int quantity;
        private int threadNumber;

        public TradingThread(Tradeable tradeable, int quantity, int i) {
            this.tradeable = tradeable;
            this.quantity = quantity;
            this.threadNumber = i;
        }

        public void sellThread(int quantity) {
            tradeable.sell(quantity);
        }

        public void buyThread(int quantity) {
            tradeable.buy(quantity);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Using Thread: " + threadNumber);
                if (threadNumber % 2 == 0) {
                    this.buyThread(quantity);
                } else {
                    this.sellThread((quantity / 2));
                }

                try{
                        Thread.sleep(2000);
                }catch (InterruptedException e){

                }
            }
        }
    }

    public static void main(String[] args) {
        Stock stock = new Stock(100);

        TradingThread[] threads = new TradingThread[2];

        for (int i = 0; i < 2; i++) {
            threads[i] = new TradingThread(stock, 10, i + 1);
            threads[i].start();
        }
    }
}
