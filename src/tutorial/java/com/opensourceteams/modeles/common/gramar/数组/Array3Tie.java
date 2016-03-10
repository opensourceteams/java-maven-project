package com.opensourceteams.modeles.common.gramar.数组;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/25  下午2:38
 * 功能描述: 三维数组,横向排列,纵向排列
 */

public class Array3Tie {
    public static void main(String[] args) {
        int[][][] array = new int[2][3][4];
        setArrayValue(array);
        System.out.println("纵向的\n");
        outArray(array);
        System.out.println("\n横向的\n");
        outArrayHorizontal(array);

    }

    /**
     * {  {{1,2,3,4},{5,6,7,8},{9,10,11,12}  },{{13,14,15,16},{17,18,19,20},{21,22,23,24}  } }
     * 设置值
     * @param array
     */
    private static void setArrayValue(int[][][] array) {
        int num = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    array[i][j][k] = num;
                    num++;
                }
            }
        }
    }


    /**
     * 纵向输出普通输出
     * <p>
     * 1	2	3	4
     * -----------------
     * 5	6	7	8
     * -----------------
     * 9	10	11	12
     * -----------------
     * <p>
     * ===========
     * 13	14	15	16
     * -----------------
     * 17	18	19	20
     * -----------------
     * 21	22	23	24
     * -----------------
     * <p>
     * ===========
     *
     * @param array
     */
    private static void outArray(int[][][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.print(array[i][j][k] + "\t");
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }

    /**
     * 三维数组 横向输出
     横向打印比较难理解,根据计算机的打印顺序可以发现:
     先打印第一层的第一行的每列,再打印第二层第一行的每列,再打印第三层第一行的每列
     所以最外层循环是行,再往里为层,然后才是列.
     * @param array
     */
    public static void outArrayHorizontal(int[][][] array) {
        for (int j = 0; j < array[0].length; j++) {
            for (int i = 0; i < array.length; i++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.print(array[i][j][k] + "\t");
                }

            }
            System.out.println("\n");
        }
    }
}
