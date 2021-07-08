package com.java;

import org.junit.Test;

/**
 * Description:
 * User: chenbin-pc
 * Date: 2018-05-09
 * Time: 10:24
 */
public class Charter02Test {

    @Test
    public void testStr() {
        System.out.println(System.currentTimeMillis());
    }

    void arrTraverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("value=" + arr[i]);
        }
    }

}
