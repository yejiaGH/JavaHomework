package com.yejia.FindMax;

import java.util.Random;

/**
 * Created by yejiapc on 15/12/7.
 */
public class FindMax {

    public static void main(String[] args){

        int[] numbers = new int[10];

        for(int i=0; i<numbers.length;i++){
            // 生成100以内的随机数
            int rand = new Random().nextInt(100);
            // 将生成的随机数填入数组
            numbers[i] = rand;
            System.out.println(numbers[i]);
        }

        // 调用查找最大数方法
        int max = findMax(numbers);
        System.out.println("最大数是"+max);
    }

    // 查找最大数方法
    private static int findMax(int[] array){

        // temp用来保存查找最大数的结果并作为返回值, 初始值是第一个元素
        int temp = array[0];

        for(int i=1; i<array.length;i++){
            // 将数组中的值依次与保存的值比较，将较大数赋给temp
            if(array[i] > temp){
                temp = array[i];
            }
        }

        return temp;
    }
}
