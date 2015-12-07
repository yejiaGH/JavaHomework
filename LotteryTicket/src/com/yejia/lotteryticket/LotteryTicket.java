package com.yejia.lotteryticket;

import java.util.Random;

/**
 * Created by yejiapc on 15/12/7.
 */
public class LotteryTicket {
    static int[] lotteryNumbers = new int[7];

    public static void main(String[] args){

        // 给乐透彩票的7个区位填入随机数，调用generateNumber方法
        for(int i=0; i<lotteryNumbers.length;i++){
            generateNumber(i);
        }

        // 打印开奖结果
        for(int i=0; i<lotteryNumbers.length;i++){
            System.out.print(lotteryNumbers[i] + " | ");
        }
    }

    // 乐透彩票开奖方法，传入表示当前区位索引的参数
    private static void generateNumber(int index){
        // rand 用来保存随机数
        int rand;
        // 表示去重区间开始的区位索引
        int from;

        if(index<5){
            // 前5位产生1~35以内的随机数
            rand = 1+ new Random().nextInt(35);
            from = 0;
        }else{
            // 最后2位产生1~12以内的随机数
            rand = 1+ new Random().nextInt(12);
            from = 5;
        }

        // 判断是否重复，如果不重复，将随机数填入彩票数组；否则继续产生当前区位的随机数
        if(noRepeat(from, index, rand)){
            lotteryNumbers[index] = rand;
        }else{
            generateNumber(index);
        }
    }

    // 检查产生的随机数在指定区位范围之间是否重复
    private static boolean noRepeat(int from, int index, int rand){

        System.out.println("from: "+ from+", index: "+index+", rand: "+ rand);
        for(int i = from; i<index; i++){
            // 如果当前随机数与之前区位的值重复，返回false
            if(lotteryNumbers[i] == rand){
                return false;
            }
        }

        // 遍历结束表示没有重复，返回true
        return true;
    }
}
