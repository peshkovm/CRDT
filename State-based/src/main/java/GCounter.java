import java.io.Serializable;
import java.util.Arrays;

public class GCounter implements Serializable {
    public static final long serialVersionUID = -3194758578089882370L;
    private int[] arr;
    int id;

    GCounter(int n, int id) {
        arr = new int[n];
        this.id = id;
    }

    public void increment() {
        arr[id]++;
    }

    public int value() {
        return Arrays.stream(arr).sum();
    }

    public void merge(GCounter counter1) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.max(arr[i], counter1.arr[i]);
    }
}
