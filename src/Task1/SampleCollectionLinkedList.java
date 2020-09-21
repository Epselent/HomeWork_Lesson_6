package Task1;

public class SampleCollectionLinkedList<T> implements SampleCollection<T> {
    private int size = 0;
    private Header first;
    private Header last;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {

        Header header = new Header(item, size);
        if (first == null) {
            first = header;
            last = header;
        } else {
            header.previous = last;
            last.next = header;
            last = header;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        Header tmp = first;
        if (index < size) {
            while (tmp != null) {
                if (tmp.index == index) {
                    if (tmp.element == first.element) {
                        first = tmp.next;
                        break;
                    }
                    tmp.previous.next = tmp.next;
                    if (tmp.element == last.element) {
                        last = tmp.next;
                        break;
                    }
                    tmp.next.previous = tmp.previous;
                    break;
                }
                tmp = tmp.next;
            }
            tmp.previous = null;
            tmp.next = null;
            tmp.element = null;
            size--;
            changeIndex(index);
        } else {
            System.out.println("Индекс указан не верно");
        }

    }

    @Override
    public T get(int index) {
        Header tmp = first;
        if (index < size) {
            while (tmp != null) {
                if (tmp.index == index) {
                    return ((T) tmp.element);
                }
                tmp = tmp.next;
            }
        } else {
            System.out.println("Индекс указан не верно");
        }
        return null;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private void changeIndex(int index) {
        Header search = first;
        while (search != null) {
            if (search.index > index) {
                search.index--;
            }
            search = search.next;
        }
    }

    class Header<T> {
        int index;
        T element;
        Header next;
        Header previous;

        public Header(T element, int index) {
            this.element = element;
            this.index = index;
        }
    }
}
