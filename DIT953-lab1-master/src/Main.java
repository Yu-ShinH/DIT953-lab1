public class Main {
    public static void main(String[]args){
        Ferry f = new Ferry(3, 100, 20000);
        f.load(new Volvo240());
        f.load(new Saab95());
        f.load(new Truck(10, 2000));
        f.load(new Volvo240());
        Volvo240 v = (Volvo240) f.unload();


    }
}
