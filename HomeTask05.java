import java.util.*;

/**
 *Создать словарь HashMap. Обобщение <Integer, String>.
 * Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)
 * Изменить значения дописав восклицательные знаки.
 * *Создать TreeMap, заполнить аналогично.
 * *Увеличить количество элементов до 1000 случайными ключами и общей строкой.
 * **Сравнить время последовательного и случайного перебора тысячи элементов словарей.
 */
public class HomeTask05 {
    public static void main(String[] args) {

        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"white");
        map.put(2,"black");
        map.put(3,"green");
        System.out.println(map);

        for (int i = 1; i < map.size()+1; i++) {
            map.compute(i, (k,v) -> v = v + "!");
        }
        System.out.println(map);

        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"white");
        treeMap.put(2,"black");
        treeMap.put(3,"green");
        System.out.println(treeMap);
        for (int i = 1; i < treeMap.size()+1; i++) {
            treeMap.compute(i, (k,v) -> v = v + "!");
        }
        System.out.println(treeMap);

        map.clear();
        Random rnd = new Random();

        for (int i = 0; i < 1000; i++) {
            map.put(rnd.nextInt(1000), "black");
            for (int j = 0; j < 10; j++) {
                map.putIfAbsent(rnd.nextInt(1000), "black");
            }
        }
        System.out.println(map.size());

        LinkedHashMap linkedHashMap = new LinkedHashMap<>();
        map.forEach((k, v) -> linkedHashMap.put(k, v));
        
        long begin = System.currentTimeMillis();
        Iterator<String> iterMap = map.values().iterator();
        while (iterMap.hasNext()){
            String tmp = iterMap.next();
            System.out.println(tmp);
        }
        long end = System.currentTimeMillis();

        long begin1 = System.currentTimeMillis();
        Iterator<String> iterLinkMap = linkedHashMap.values().iterator();
        while (iterLinkMap.hasNext()){
            String tmp = iterLinkMap.next();
            System.out.println(tmp);
        }
        long end1 = System.currentTimeMillis();

        System.out.println(end-begin);
        System.out.println(end1-begin1);
    }
}
