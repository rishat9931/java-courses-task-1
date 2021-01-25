package ru.sber.courses.gsm;

import java.util.*;

public class Transports {
    private ArrayList<Transport> transports;

    public Transports(ArrayList<Transport> transports) {
        this.transports = transports;
    }

    /***
     * Стоимость топлива
     * 100 - 46.10
     * 200 - 47.50
     * 300 - 48.90
     * 400 - 48.90
     */
    Map<String, Float> fuelCost = Map.of(
            "C100", 46.10f,
            "C200", 47.50f,
            "C300", 48.9f,
            "C400", 48.9f
    );

    /***
     * Расход топлива на 100 км
     * 100 - 12.5
     * 200 - 12
     * 300 - 11.5
     * 400 - 20
     */

    Map<String, Float> fuelСonsumption = Map.of(
            "C100", 12.5f,
            "C200", 12f,
            "C300", 11.5f,
            "C400", 20f
    );

    private float allRate;
    private float transportClassifierRate;
    private HashMap<String, Float> allTransportClassifierRate = new HashMap<String, Float>();


    public float getAllRate() {
        allRate = 0;
        for (Transport transport : transports) {
            allRate += transport.mileage / 100 * fuelСonsumption.get(transport.code) * fuelCost.get(transport.code);
        }
        return allRate;
    }

    /**
     * пусть будет и этот метод расчета принимающий на вход код авто
     */
    public float getTransportClassifierRate(String transportCode) {
        transportClassifierRate = 0;
        for (Transport transport : transports) {
            if (transportCode.hashCode() == transport.code.hashCode()) {
                transportClassifierRate += transport.mileage / 100 * fuelСonsumption.get(transport.code) * fuelCost.get(transport.code);
            }
        }
        return transportClassifierRate;
    }

    /**
     * метод расчета по расходов в разрере кода авто
     */
    public Map<String, Float> getAllTransportClassifierRate() {
        for (Transport transport : transports) {

            if (allTransportClassifierRate.get(transport.code) != null) {
                allTransportClassifierRate.put(transport.code, allTransportClassifierRate.get(transport.code) + transport.mileage / 100 * fuelСonsumption.get(transport.code) * fuelCost.get(transport.code));
            } else {
                allTransportClassifierRate.put(transport.code, transport.mileage / 100 * fuelСonsumption.get(transport.code) * fuelCost.get(transport.code));
            }

        }
        return allTransportClassifierRate;
    }

    /**
     * поиск максимального значения в мапе  (https://www.baeldung.com/java-find-map-max)
     */
    public <K, V extends Comparable<V>> V maxRate(Map<K, V> map) {
        Map.Entry<K, V> maxEntry = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue()
                    .compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getValue();
    }

    /**
     * поиск минимального значения в мапе
     */
    public <K, V extends Comparable<V>> V minRate(Map<K, V> map) {
        Map.Entry<K, V> minEntry = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (minEntry == null || entry.getValue()
                    .compareTo(minEntry.getValue()) < 0) {
                minEntry = entry;
            }
        }
        return minEntry.getValue();
    }

    /**
     * вывод по коду авто все соответсвующие авто
     */

    private ArrayList<Transport> transportClassifierCode = new ArrayList<>();

    public ArrayList<Transport> getTransportClassifierCode(String transportCode) {
        for (Transport transport : transports) {
            if (transportCode.hashCode() == transport.code.hashCode()) {
                transportClassifierCode.add(transport);
            }
        }
        //сортируем по пробегу и сортируем по доп параметру (пока последовательно)
        Collections.sort(transportClassifierCode, Comparator.comparing(Transport::getMileage));
        Collections.sort(transportClassifierCode, Comparator.comparing(Transport::getAddInfo));
        return transportClassifierCode;

    }

}
