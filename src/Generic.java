import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Date: 2019/1/23
 * Created by Liuian
 */
class Generic {
    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a)
            c.add(o);
    }

    public static void main(String[] args) {
        String[] strArr = {"a ", "b"};
        Object[] strArr2 = {"a ", "b"};
        List<String> strList = new ArrayList<String>();
        List<Object> strList2 = new ArrayList<Object>();
        fromArrayToCollection(strArr, strList);//编译报错，无法判别T类型
        fromArrayToCollection(strArr2, strList2);//编译不报错，T为Object
    }
}