package base.sort.code;

import java.util.Comparator;

/**
 * 比较器
 */
public class SortComparable implements Comparator<Student> {
    /**
     * 默认时小 -> 大
     * return 负数，意味着第一个参数应该放在前面
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.id < o2.id) {
            return -1;
        } else if (o1.id > o2.id) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Student {
    public int id;
}