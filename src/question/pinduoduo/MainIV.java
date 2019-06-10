package question.pinduoduo;


import java.util.*;


/**
 * @author Heper
 * @title
 * @date 2019/5/6 19:29
 */
public class MainIV {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = in.nextInt();
        int[][] line = new int[num][2];
        for (int i = 0; i < num; i++) {
            line[i][0] = in.nextInt();
            line[i][1] = in.nextInt();
        }
        ArrayList result = new ArrayList<Integer>();
        //基于起始点进行小->大排序
        Arrays.sort(line, Comparator.comparingInt(o -> o[1]));
        Map<Pair<Integer, Integer>, Integer> map = new HashMap();
        //存放长度为1的线段属于几条线段
        for (int i = 0; i < num; i++) {
            for (int j = line[i][0]; j < line[i][1]; j++) {
                Pair<Integer, Integer> pair = new Pair<>(j, j + 1);
                if (!map.containsKey(pair)) {
                    map.put(pair, 1);
                } else {
                    map.put(pair, map.get(pair) + 1);
                }
            }
        }
        int[] temp = new int[map.keySet().size()];
        int len = 0;
        //找出符合属于k条线段的长度为1的线段
        for (Pair<Integer, Integer> key : map.keySet()) {
            if (map.get(key) >= count) {
                temp[len] = key.getKey();
                len++;
            }
        }
        //找出他们的起始点存放到一个数组当中
        int[] start = new int[len];
        for (int i = 0; i < len; i++) {
            start[i] = temp[i];
        }
        //进行排序
        Arrays.sort(start);
        int[][] res = new int[len][2];
        int resCount = 0;
        int index = 0;
        for (int i = 0; i < start.length; i++) {
            index = i;
            while (index + 1 < start.length && start[index] + 1 == start[index + 1]) {
                index++;
            }
            res[resCount][0] = start[i];
            res[resCount][1] = start[index] + 1;
            resCount++;
            i = index;
        }
        System.out.println(resCount);
        for (int i = 0; i < resCount; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }

    static class Pair<K, V> {

        /**
         * Key of this <code>Pair</code>.
         */
        private K key;

        /**
         * Gets the key for this pair.
         *
         * @return key for this pair
         */
        public K getKey() {
            return key;
        }

        /**
         * Value of this this <code>Pair</code>.
         */
        private V value;

        /**
         * Gets the value for this pair.
         *
         * @return value for this pair
         */
        public V getValue() {
            return value;
        }

        /**
         * Creates a new pair
         *
         * @param key   The key for this pair
         * @param value The value to use for this pair
         */
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * <p><code>String</code> representation of this
         * <code>Pair</code>.</p>
         *
         * <p>The default name/value delimiter '=' is always used.</p>
         *
         * @return <code>String</code> representation of this <code>Pair</code>
         */
        @Override
        public String toString() {
            return key + "=" + value;
        }

        /**
         * <p>Generate a hash code for this <code>Pair</code>.</p>
         *
         * <p>The hash code is calculated using both the name and
         * the value of the <code>Pair</code>.</p>
         *
         * @return hash code for this <code>Pair</code>
         */
        @Override
        public int hashCode() {
            // name's hashCode is multiplied by an arbitrary prime number (13)
            // in order to make sure there is a difference in the hashCode between
            // these two parameters:
            //  name: a  value: aa
            //  name: aa value: a
            return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
        }

        /**
         * <p>Test this <code>Pair</code> for equality with another
         * <code>Object</code>.</p>
         *
         * <p>If the <code>Object</code> to be tested is not a
         * <code>Pair</code> or is <code>null</code>, then this method
         * returns <code>false</code>.</p>
         *
         * <p>Two <code>Pair</code>s are considered equal if and only if
         * both the names and values are equal.</p>
         *
         * @param o the <code>Object</code> to test for
         *          equality with this <code>Pair</code>
         * @return <code>true</code> if the given <code>Object</code> is
         * equal to this <code>Pair</code> else <code>false</code>
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Pair) {
                Pair pair = (Pair) o;
                if (key != null ? !key.equals(pair.key) : pair.key != null) {
                    return false;
                }
                if (value != null ? !value.equals(pair.value) : pair.value != null) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}
