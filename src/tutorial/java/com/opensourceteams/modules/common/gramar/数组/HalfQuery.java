package com.opensourceteams.modules.common.gramar.数组;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/25  下午10:26
 * 功能描述: 折半查找,二分查找
 */

public class HalfQuery {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {3,9,5,5,10,1};
        int[] newArray = ArraySortSelect.arraySortSelectAsc(array);
        ArraySortSelect.println(newArray);

        ArraySortSelect.println(halfQuery(array,5));

    }


    /**
     *
     * @param array
     * @param value
     * @return  -2 是找不到
     */
    public static int halfQuery(int[] array ,int value){
        int a = 0 ;
        int b = array.length - 1;
        int m = (a + b) / 2 ;

        while (a >= b){

            m = (a + b) / 2 ;

            if(array[m] == value){
                return m;
            }else if(array[m] < value){
                a = m +1 ;
            }else if(array[m] > value){
                b = m - 1;
            }
        }
        return -2;
    }
}
