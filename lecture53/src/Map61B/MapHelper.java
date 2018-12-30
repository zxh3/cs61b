package Map61B;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.Assert.*;

public class MapHelper {
    public static <K extends Comparable<K>, V> K maxKey(ArrayMap<K, V> m) {
        if (m.size() == 0)
            return null;
        List<K> keyList = m.keys();
        K largest = keyList.get(0);
        for (K k : keyList) {
            if (k.compareTo(largest) > 0)
                largest = k;
        }
        return largest;
    }

    @Test
    public void testMaxKey() {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("aaa", 1);
        m.put("zzz", 2);
        m.put("ccc", 3);
        org.junit.Assert.assertEquals((String) MapHelper.maxKey(m), "zzz");
        System.out.println(MapHelper.maxKey(m));
    }
}
