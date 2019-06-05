import java.util.LinkedList;
import java.util.List;

public class Deduplicate {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(3);
        System.out.println(linkedList.size());

        List<Integer> deduplicate = new Deduplicate().deduplicate(linkedList);
        System.out.println(deduplicate.size());
    }

    public List<Integer> deduplicate(LinkedList<Integer> source) {
        source.sort(Integer::compareTo);
        int size = source.size() - 1;
        for (int i = 0; i < size; i++) {
            while (i < size && source.get(i).compareTo(source.get(i + 1)) == 0) {
                source.remove(i + 1);
                size--;
            }
        }
        return source;
    }
}
