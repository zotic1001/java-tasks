package ru.mail.polis.homework.objects;

import java.util.Arrays;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если массив null или его длина меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * НЕЛЬЗЯ СОРТИРОВАТЬ массив array и его копии
     */
    public static int[] getMaxArray(int[] array, int count) {
        if (array == null || array.length < count) {
            return null;
        }
        // Создание массива для хранения count максимальных элементов
        int[] result = new int[count];
        int[] tempArray = Arrays.copyOf(array, array.length);
        //Если скопировать в result,
        // работать не будет,
        // смысл в том что мы постепенно выбираем,
        // как выбирать без сортировки в тот же массив из которого выбираем, я не знаю
        for (int i = 0; i < count; i++) {
            int maxElement = tempArray[0];
            int maxIndex = 0;
            for (int j = 1; j < tempArray.length; j++) {
                if (tempArray[j] > maxElement) {
                    maxElement = array[j];
                    maxIndex = j;
                }
            }
            // Сохранение максимального элемента в выходном массиве и удаление его из входного массива
            result[i] = maxElement;
            tempArray[maxIndex] = Integer.MIN_VALUE;
        }

        return result;
    }
}
