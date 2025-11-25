import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 2};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (current.isEmpty() || array[i] > current.get(current.size() - 1)) {
                current.add(array[i]);
            } else {
                addSubsequences(current, result);
                current.clear();
                current.add(array[i]);
            }
        }
        addSubsequences(current, result); // סיום עם הרצף האחרון

        // הדפסה של כל תתי־הרצפים עם פסיקים ובסוגריים מרובעים
        for (List<Integer> seq : result) {
            System.out.println(seq);
        }
    }

    private static void addSubsequences(List<Integer> seq, List<List<Integer>> result) {
        for (int len = seq.size(); len >= 2; len--) {
            result.add(new ArrayList<>(seq.subList(0, len)));
        }
    }
}
