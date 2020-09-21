package Task1;

public interface SampleCollection<T> {
    int size();

    void add(T item);

    void remove(int index);

    T get(int index);

    void clear();
}
