public class Counter extends Register {

    public Counter(int size, int value) {
        super(size, value);
    }

    public void reduceByOne() {
        this.value = this.value - 1;
    }

    public int isZero() {
        int result = 1;
        // 1 & ~counter(0) & ~counter(1) & ~counter(2) & ...
        for (int i = 0; i < size; i++) {
            result = result & ~getBit(i);
        }
        return result;
    }
}
