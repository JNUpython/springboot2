package com.shanguigu;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.shanguigu
 * @Description: TODO
 * @date Date : 2019-06-02 22:10
 */

public class SortTest {

    private static final Logger logger = LoggerFactory.getLogger(SortTest.class);

    private static int[] numsInt = {1, 0, -2, 9, 8};

    // 排序：

    /**
     * 冒泡排序：邻近数据比较，将最大或者最小的数据玩前或者后移动
     */
    @Test
    public void bubbleMin() {
        logger.info("原始数据: {}", numsInt);
        for (int index = 0; index < numsInt.length - 1; index++) {
            for (int jndex = numsInt.length - 1; jndex > index; jndex--) {
                if (numsInt[jndex] < numsInt[jndex - 1]) {
                    // 临近比较：遍历将最小放在前面
                    int tmp = numsInt[jndex];
                    numsInt[jndex] = numsInt[jndex - 1];
                    numsInt[jndex - 1] = tmp;
                }
            }
            logger.info("{}: {}", index, numsInt);
        }
    }

    @Test
    public void bubbleMax() {
        logger.info("原始数据: {}", numsInt);
        for (int index = numsInt.length - 1; index >= 0 ; index--) {
            for (int jndex = 0; jndex < index; jndex++) {
                if (numsInt[jndex] > numsInt[jndex + 1]) {
                    // 临近比较：遍历将最大放在后面
                    int tmp = numsInt[jndex];
                    numsInt[jndex] = numsInt[jndex + 1];
                    numsInt[jndex + 1] = tmp;
                }
            }
            logger.info("{}: {}", index, numsInt);
        }
    }

    /**
     * 选择排序：遍历将最小或者最大的，依次丢在一个容器里面
     */

    /**
     * way1:插入排序：遍历数据，将数据有序的放入容器中，相比前面选择排序，将数据放入容器中时，需要与容器中的数据进行比较计算
     * way2: 从第二个开始将其和前面的元素进行比较，插入到该插入的位置
     */
    @Test
    public void insert() {
        // 利用list插入特性
        List<Integer> numsList = new ArrayList<>();
        logger.info("原始数据: {}", numsInt);
        numsList.add(numsInt[0]);
        for (int index = 1; index < numsInt.length; index++) {
            for (int jndex = 0; jndex < numsList.size(); jndex++) {
                if (numsList.get(jndex) > numsInt[index]) {
                    // 找到比自身大的位置插入
                    numsList.add(jndex, numsInt[index]);
                    break;
                }
                if (jndex == numsList.size() - 1) {
                    // 尾部插入
                    numsList.add(numsList.size(), numsInt[index]);
                    break;
                }
            }
            logger.info("{}: {}", index, numsList);
        }
    }

    /**
     *
     */
    @Test
    public void shell(){
        int gap = 1;
        while (gap < numsInt.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < numsInt.length; i++) {
                int tmp = numsInt[i];
                int j = i - gap;
                while (j >= 0 && numsInt[j] > tmp) {
                    numsInt[j + gap] = numsInt[j];
                    j -= gap;
                }
                numsInt[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
    }
}
