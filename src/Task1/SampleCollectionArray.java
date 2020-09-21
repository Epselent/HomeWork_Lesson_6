package Task1;

public class SampleCollectionArray<T> implements SampleCollection<T> {
    private Object[] array = new Object[0];

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        Object[] tmpArray = new Object[array.length + 1];
        for (int i = 0; i < tmpArray.length - 1; i++) {
            tmpArray[i] = array[i];
        }
        tmpArray[array.length] = item;
        array = tmpArray;
    }

    @Override
    public void remove(int index) {
        try {
            Object[] result = new Object[array.length - 1];
            for (int i = 0; i < index; i++) {
                result[i] = array[i];
            }
            for (int i = index + 1; i < array.length; i++) {
                result[i - 1] = array[i];
            }
            array = result;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс указан не верно");
        }
    }

    @Override
    public T get(int index) {
        try {
            return (T) array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс указан не верно");
        }
        return null;
    }

    @Override
    public void clear() {
        Object[] result = new Object[0];
        array = result;
    }
}
