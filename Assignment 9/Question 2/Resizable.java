public class Resizable 
{
    public interface ResizeCircle 
    {
        abstract void increaseRadius(int factor);
        abstract void decreaseRadius(int factor);
    }

    class Circle implements ResizeCircle 
    {
        private int radius;

        @Override
        public void increaseRadius(int factor) 
        {
            System.out.println("Increasing by a factor of " + factor + "...");
            this.radius += factor;
        }

        @Override
        public void decreaseRadius(int factor) 
        {
            System.out.println("Decreasing by a factor of " + factor + "...");
            this.radius -= factor;
        }

        public Circle(int radius)
        {
            this.radius = radius;
        }

        public int getRadius()
        {
            return this.radius;
        }
    }

    public static void main(String args[])
    {
        // creating a non-static innerclass
        Resizable resizable = new Resizable();

        Circle circle1 = resizable.new Circle(5);
        Circle circle2 = resizable.new Circle(8);
        
        System.out.println("Original Radius of Circle 1 : " + circle1.getRadius());
        circle1.increaseRadius(10);
        System.out.println("Increased Radius: "  + circle1.getRadius());

        System.out.println("Original Radius of Circle 2 : " + circle2.getRadius());
        circle2.decreaseRadius(5);
        System.out.println("Decreased Radius: "  + circle2.getRadius());
        
    }
    
}
