public class trading {
        public interface Tradeable {
                void buy(int quantity);

                void sell(int quantity);
        }

        public class Stock implements Tradeable {
                private int totalQuantity;

                @Override
                public void buy(int quantity) {

                        System.out.println();
                        this.totalQuantity += quantity;
                        System.out.println("Stock Bought!!" + '\n' + "Amount Bought : " + quantity);
                        System.out.println(this.toString());
                        System.out.println();
                }

                @Override
                public void sell(int quantity) {
                        this.totalQuantity -= quantity;
                }

                public Stock(int quantity) {

                        System.out.println();
                        this.totalQuantity = quantity;
                        System.out.println("Stock Sold!!" + '\n' + "Amount Sold : " + quantity);
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

        public static void main(String[] args) {
                // Instantiate the Trading Class
                trading trader = new trading();

                Stock s1 = trader.new Stock(100);

                s1.buy(20);
                s1.sell(40);
                s1.buy(60);

        }
}
