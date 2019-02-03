package sarch;

import java.util.Arrays;

/**
 * 二分查找
 * @Author : Heper
 * @Time : 2018/10/15 15:20
 */
public class BinarySearch {

    /**
     *
     * @param key 要查找的元素
     * @param a 数组
     * @return 在数组当中的位次,第一个元素的位次为0
     */
    public static int rank(int key,int[] a){
        //定义数组的开始和结尾
        int low=0;
        int high = a.length-1;
        //当开始端与结尾端没有在一个地方，就继续进行查找
        while(low<=high){
            //判断中间的元素与要查找的key的大小关系
            int mid =low+(high-low)/2;
            //判断与key的关系
            if(key<a[mid]){ high=mid-1; }
            else if(key>a[mid]){ low=mid+1; }
            else{ return mid; }
        }
        //low与high碰面了,退出了循环,说明没有查找到相应的元素,返回-1
        return -1;
    }

    /**
     * 测试一下二分查找
     * @param args
     */
    public static void main(String[] args){
        int[] whiteList ={22,31,17};
        //二分查找的基础是排序好的数据
        Arrays.sort(whiteList);
        int position=rank(17,whiteList);
        System.out.println(position);
    }
}
