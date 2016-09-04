package com.opensourceteams.modules.common.gramar.逻辑控制.n_01_循环;

/**
 * 日期: 2016-09-03  11:58
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run8 {

    public static void main(String[] args) {
        for_i:for (int i = 1 ;i <= 5 ;i ++){
            for_k:for (int k = 1 ;k <= 5 ;k ++){

                for (int j = 1 ;j <= 5 ;j ++){
                    if(j ==3){

                        break  for_k;
                    }
                    System.out.println( "i:"+i  +" k:" +k +"  j:" +j  );
                }
            }

        }
    }

}
