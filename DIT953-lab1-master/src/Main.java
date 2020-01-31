public class Main {
    public static void main(String[]args){

       /* Saab95 s = new Saab95();
        s.incrementSpeed(10);
        System.out.println("direction is: " + s.getDirection());
        System.out.println("x is " + s.getX() + "\ny is " + s.getY());

        for (int i = 0; i < 6; i++) {
            s.turnRight();
            s.move();
            System.out.println(i + 1);
            System.out.println("x is " + s.getX() + "\ny is " + s.getY());
            System.out.println("direction is: " + s.getDirection());
        }

        */
        car s = new Saab95();
        s.setDirection(2*Math.PI + 1);
        System.out.println(s.getDirection());


    }
}
