package org.example;

public class Main {
    public static void main(String[] args) {

//        1)Написать программу которая вычислит и выведет на экран площадь треугольника если
//        известны его стороны (sideA = 0.3, sideB = 0.4, sideC = 0.5). Для вычисления
//        использовать формулу Герона
        double sideA = 0.3;
        double sideB = 0.4;
        double sideC = 0.5;
        double p = (sideA + sideB + sideC) / 2;
        double square = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        System.out.println("Площадь треугольника = " + square);

//        2)Стоимость яблока составляет 2$. Покупатель приобретает 6 яблок. Напишите
//        программу которая вычислит и выведет на экран сумму которую должен уплатить
//        покупатель за покупку
        int price = 2;
        int count = 6;
        int sum = price * count;
        System.out.println("Сумма покупки = " + sum);

//        3)Один литр топлива стоит 1.2$. Ваш автомобиль тратит на 100 км пути 8 литров топлива.
//        Вы собрались в поездку в соседний город. Расстояние до этого города составляет 120
//        км. Вычислите и выведите на экран сколько вам нужно заплатить за топливо для
//        поездки.
        double gasolinePrice = 1.2;
        double distanceToCity = 120;
        double gasolineConsumptionPer100km = 8;
        double fuelNeeded = (gasolineConsumptionPer100km / 100) * distanceToCity;
        double costOfTrip = fuelNeeded * gasolinePrice;
        System.out.println("Стоимость поездки = " + costOfTrip);
    }
}
