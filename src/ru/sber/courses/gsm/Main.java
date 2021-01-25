package ru.sber.courses.gsm;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Формат данных - C(CODE_CAR)_гос номер-Пробег-(доп. параметр)
        String[] transportsIn = {
                "C100_1-100",
                "C200_1-120-1200",
                "C300_1-120-30",
                "C400_1-80-20",
                "C100_2-50",
                "C200_2-40-1000",
                "C300_2-200-45",
                "C400_2-10-20",
                "C100_3-10",
                "C200_3-170-1100",
                "C300_3-150-29",
                "C400_3-100-28",
                "C100_1-300",
                "C200_1-100-750",
                "C300_1-32-15"
        };

        /**
         * инициализация списка транспортов
         */
        ArrayList<Transport> transportArrayList = new ArrayList<>();

        /**
         * транспорт с разбиением на параметры
         * */
        for(String tr:transportsIn)
        {
            Transport transport = new Transport();
            String[] carInfoCode = tr.split("_");
            for (int j = 0; j < carInfoCode.length; j++) {
                switch (j) {
                    case 0:
                        transport.code = carInfoCode[j];
                        break;
                    case 1:
                        String[] carInfo = carInfoCode[j].split("-");
                        for (int i = 0; i < carInfo.length; i++) {
                            switch (i) {
                                case 0:
                                    transport.key = carInfo[i];
                                    break;
                                case 1:
                                    transport.mileage = Float.parseFloat(carInfo[i]);
                                    break;
                                case 2:
                                    transport.addInfo = Integer.parseInt(carInfo[i]);
                                    break;
                            }
                        }
                        break;
                }


            }

            transportArrayList.add(transport);
        }

        Transports transports = new Transports(transportArrayList);

        /**
         * Общая стоимость расхродов на ГСМ
         * */
        System.out.println("=====================1.0=====================================");
        System.out.println("Общая стоимость расхродов на ГСМ: "+ transports.getAllRate());
        System.out.println("=============================================================");

        // c принимающим на вход параметром Она не нужна но пусть будет для кучи :).  Общая стоимость расхродов на ГСМ для класса.
        System.out.println();
        System.out.println("=====================2.0.0===================================");
        System.out.println("Общая стоимость расхродов на ГСМ для класса авто C100: "+ transports.getTransportClassifierRate("C100"));
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("Общая стоимость расхродов на ГСМ для класса авто C200: "+ transports.getTransportClassifierRate("C200"));
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("Общая стоимость расхродов на ГСМ для класса авто C300: "+ transports.getTransportClassifierRate("C300"));
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("Общая стоимость расхродов на ГСМ для класса авто C400: "+ transports.getTransportClassifierRate("C400"));
        System.out.println("=============================================================");


        // выводит в разрезе класса в map
        Map<String, Float> transportClassifierRate = transports.getAllTransportClassifierRate();
        System.out.println();
        System.out.println("=====================2.0.1===================================");
        System.out.println("Общая стоимость расхродов на ГСМ для всех классов авто в разрезе классов: "+ transportClassifierRate);
        System.out.println("=============================================================");

        /**
         * Тип авто имеющий наибольшую стоимость расходов
         * */
        System.out.println();
        System.out.println("=====================3.0.0===================================");
        System.out.println("Тип авто имеющий наибольшую стоимость расходов: "+ transports.maxRate(transportClassifierRate));
        System.out.println("=============================================================");

        /**
         * Тип авто имеющий наибольшую стоимость расходов
         * */
        System.out.println();
        System.out.println("=====================4.0.0===================================");
        System.out.println("Тип авто имеющий наименьшую стоимость расходов: "+ transports.minRate(transportClassifierRate));
        System.out.println("=============================================================");


        /**
         * ввоод с клавиатуры кода авто
         * */

        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        int index = 0;

        ArrayList<Transport> sortTransportClassifer = transports.getTransportClassifierCode(inputStr);
        if(sortTransportClassifer.isEmpty()){
            System.out.println("Транспортное средство с кодом: "+inputStr+ " не найдено");
        }
        else {
            System.out.println("Список транспортных с  кодом: "+inputStr+ ": ");
            for (Transport item:sortTransportClassifer){
                index++;
                System.out.println(index+". гос. номер: "+item.key+", пробег: "+item.mileage+" доп. инфо:"+item.addInfo);
            }
        }

    }

}
