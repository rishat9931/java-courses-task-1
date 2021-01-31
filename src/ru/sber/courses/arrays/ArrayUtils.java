package ru.sber.courses.arrays;

import java.util.Arrays;

public class ArrayUtils {

    private int[] arr = null;
    /**
     * Необходимо реализовать класс в конструктор которого передается целочисленный массив.
     */
    public ArrayUtils(int[] arr) {
        this.arr = arr;
    }

    /**
     * * добавление элемента в массив (в конец)
     */
    public void addItemEnd(int item) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = item;
        this.arr = newArr;
    }
    /**
     * * добавление элемента в массив (в определенную позицию) (здесь идет сдвиг массива вправо)
     */
    public void addItemIndex(int item, int index) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        //при добавление в любое место, можем добавить в конец, поэтому считаем передаем index-1
        if(checkArrIndex(index-1)) {
            boolean added = false;
            for (int i = 0; i < newArr.length; i++) {
                if(i==index){
                    newArr[i] = item;
                    added = true;
                }
                else if(added){
                    newArr[i] = arr[i-1];
                }
            }
            this.arr = newArr;
        }

    }

    /**
     * функцию вывод количества элементов в массиве
     */
    public int arrayLength(){
        return arr.length;
    }
    /**
     * удаление элемента массива по индексу
     * */
    public void removeItem(int index){
        if(checkArrIndex(index)){
            int[] newArr = new int[arr.length-1];
            for (int i = 0; i < newArr.length; i++) {
                if(i>=index){
                    newArr[i] = arr[i+1];
                }
                else {
                    newArr[i] = arr[i];
                }
            }
            this.arr = newArr;
        }

    }
    /**
     * изменения значения по его индексу
     * */

    public void changeItem(int item, int index){
        if(checkArrIndex(index)) {
            int[] newArr = Arrays.copyOf(arr, arr.length);
            newArr[index] = item;
            this.arr = newArr;
        }
    }
    /**
     * функция вывода на экран всего массива
     * здесь можно было принимать в принципе любой массив, но пока следуем четко по заданию
     */

    public void printArray(){
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("[" + arr[i]);
            } else if (i == arr.length - 1) {
                System.out.print(","+arr[i] + "]");

            } else {
                System.out.print(","+arr[i]);

            }
        }
        System.out.println();
    }

    /**
     * функцию заполнения массива одинаковыми элементами
     * */
    public void fillArrayEqualItem(int item){
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = item;
        }
    }

    /**
     * функцию вывода максимального элемента (полагаем что массив всегда заполнен, проверки делать не стал)
     * */
    public int findMaxItem(){
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>maxValue){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
    /**
     * функцию вывода минимального элемента
     * */
    public int findMinItem(){
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<minValue){
                minValue = arr[i];
            }
        }
        return minValue;
    }

    /**
     * функцию сортировки массива (по возрастанию и убыванию без изменения исходного массива)
     */
    public void sortAsc(){
        Arrays.sort(arr);
    }
    /**
     * а здесь по приколу, как будто мы только начали ботать джаву
     * */
    public void sortDesc(){
        for (int i = 0; i < arr.length / 2; i++) {
            int item = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = item;
        }

    }

    public boolean checkArrIndex(int index) {
        boolean checked = index < arr.length;
        if(!checked){
            System.out.println("Невозможно изменить/добавить/удалить элемент = "+index+" , так как переданный индекс выходит за рамки массива. Массив не изменился!");
        }
        return checked;
    }
}
