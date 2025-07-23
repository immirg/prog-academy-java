public class main14 {
    public static void main(String[] args) {
        /*
        Существуют три корабля. На каждом из них 10 ящиков груза. Они одновременно прибыли в порт в котором только два
        дока. Скорость разгрузки 1 ящик в 0.5 сек. Напишите программу которая управляя кораблями позволит им
        правильно разгрузить груз.
         */
        Port port = new Port();
        Ship shipOne = new Ship(port,10, "shipOne");
        Ship shipTwo = new Ship(port,10, "shipTwo");
        Ship shipThree = new Ship(port,10, "shipThree");

        Thread thOne = new Thread(shipOne);
        Thread thTwo = new Thread(shipTwo);
        Thread thThree = new Thread(shipThree);

        thOne.start();
        thTwo.start();
        thThree.start();
    }
}
