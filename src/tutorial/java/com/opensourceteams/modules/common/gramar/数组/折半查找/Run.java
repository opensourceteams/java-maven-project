package com.opensourceteams.modules.common.gramar.数组.折半查找;

/**
 * 日期: 2016-08-22  21:27
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run {


    public static void main(String[] args) {
        int[] array = { 3,5,11,17,21,23,28,30,32,50};
        System.out.println(array.length);
        int isExist = splitHalf(array,5,0,array.length - 1);
        System.out.println("isExist : "+isExist);

    }


    public static int splitHalf(int[] arrayData,int searchData,int start,int end){
        int index = (start + end)/2;
        int data = arrayData[index];
        if(start > end ){
            return -1;
        }
        if(data == searchData){
            return index;
        }else{
            if(data < searchData){
                return splitHalf(arrayData,searchData,index+1,end);
            }else{
                return splitHalf(arrayData,searchData,start,index-1);
            }
        }
    }
}
