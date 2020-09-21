package Task2;

import Task1.SampleCollectionArray;
import Task1.SampleCollectionLinkedList;

public class Box<T extends Fruit> {
    private SampleCollectionArray<T> boxFruit = new SampleCollectionArray<>();
//    private SampleCollectionLinkedList<T> boxFruit = new SampleCollectionLinkedList();
    public void putFruit(T fruit) {
        boxFruit.add(fruit);
    }

    public float getWeight() {
        if (boxFruit.size() == 0) {
            return 0;
        }
        float weight = 0;
        for (int i = 0; i < boxFruit.size(); i++) {
            weight += boxFruit.get(i).getWeight() * boxFruit.get(i).getCount();
        }
        return weight;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box<? super T> box) {
        for (int i = 0; i < boxFruit.size(); i++) {
            box.putFruit(this.boxFruit.get(i));
        }
        this.boxFruit.clear();
    }
}
