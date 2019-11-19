package com.chapter_6._1_interfaces.ssozh;

/**
 * 关于接口的几个问题：
 *  1.调用java.lang和同一个package下的接口不需要import，但是其他情况还是需要import的。这里调用同一个package的ISsozhComparable（java.lang.Comparable）接口就不需要import
 *  2.要将某类声明为实现某个接口，需要使用关键字implements
 *  3.如果想直接使用某一个泛型类，则可以先将传入类型转化为Object[] 数组，数组类型不支持多态，只能分别对每个数组元素使用多态
 *  所以再将数组成员转化为接口类ISsozhComparable,然后使用泛型接口的ssozhCompareTo
 *  4.在这里实现接口的是SsozhEmployee类，而使用接口的的静态方法是mergeSort（对应到Arrays.sort静态方法）
 *  5.在使用泛型方法的时候可以使用注释    @SuppressWarnings({"unchecked", "rawtypes"})
 */

public class ComparableTest {
    public static void main(String[] args) {
        SsozhEmployee[] staff = new SsozhEmployee[3];
        staff[0] = new SsozhEmployee("Carl Craker",35000);
        staff[1] = new SsozhEmployee("Harry Hacker",50000);
        staff[2] = new SsozhEmployee("Tommy Tester",40000);
        Object[] aux = staff.clone();
        mergeSort(aux, staff, 0, staff.length, 0);

        // print out info about all SsozhEmployee objs
        for(SsozhEmployee e: staff){
            System.out.println("name=" + e.getName() + ",salary="+e.getSalary());
        }

    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void mergeSort(Object[] src,
                                  Object[] dest,
                                  int low,
                                  int high,
                                  int off) {
        int length = high - low;

        // Insertion sort on smallest arrays
        if (length < 7) {
            for (int i=low; i<high; i++)
                for (int j = i; j>low &&
                        ((ISsozhComparable) dest[j-1]).ssozhCompareTo(dest[j])>0; j--)
                    swap(dest, j, j-1);

            return;
        }

        // Recursively sort halves of dest into src
        int destLow  = low;
        int destHigh = high;
        low  += off;
        high += off;
        int mid = (low + high) >>> 1;
        mergeSort(dest, src, low, mid, -off);
        mergeSort(dest, src, mid, high, -off);

        // If list is already sorted, just copy from src to dest.  This is an
        // optimization that results in faster sorts for nearly ordered lists.
        if (((ISsozhComparable)src[mid-1]).ssozhCompareTo(src[mid]) <= 0) {
            System.arraycopy(src, low, dest, destLow, length);
            return;
        }

        // Merge sorted halves (now in src) into dest
        for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if (q >= high || p < mid && ((ISsozhComparable)src[p]).ssozhCompareTo(src[q])<=0)
                dest[i] = src[p++];
            else
                dest[i] = src[q++];
        }
    }

    private static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
