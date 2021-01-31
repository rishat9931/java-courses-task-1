package ru.sber.courses.arrays;

public class Array {

    public static void main(String[] args) {
        System.out.println("======= конструктор ===========");
        ArrayUtils arrayUtils = new ArrayUtils(new int[]{1, 2, 4});
        arrayUtils.printArray();

        System.out.println("======= добавление в конец ===========");
        arrayUtils.addItemEnd(10);
        arrayUtils.printArray();

        System.out.println("======= добавление в любое место ===========");
        arrayUtils.addItemIndex(109, 0);
        arrayUtils.printArray();

        System.out.println("======= удаление элемента массива по индексу ===========");
        arrayUtils.removeItem(0);
        arrayUtils.printArray();

        System.out.println("======= изменения значения по его индексу===========");
        arrayUtils.changeItem(3245,3);
        arrayUtils.printArray();

        System.out.println("======= вывод длины массива ===========");
        System.out.println(arrayUtils.arrayLength());


        System.out.println("======= вывод макс/мин значения");
        System.out.println("max: "+arrayUtils.findMaxItem()+", min :"+arrayUtils.findMinItem());

        System.out.println("=======функцию сортировки массива (по возрастанию без изменения исходного массива)");
        arrayUtils.sortAsc();
        arrayUtils.printArray();

        System.out.println("=======функцию сортировки массива (по убыванию без изменения исходного массива)");
        arrayUtils.sortDesc();
        arrayUtils.printArray();


        System.out.println("======= заполнения массива одинаковыми элементами===========");
        arrayUtils.fillArrayEqualItem(32463);
        arrayUtils.printArray();

    }


}
