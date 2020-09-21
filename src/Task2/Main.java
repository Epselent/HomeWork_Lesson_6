package Task2;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        orangeBox.putFruit(orange);
        appleBox.putFruit(apple);
        appleBox.putFruit(apple);
        Box<Fruit> fruitBox = new Box<>();
        System.out.println("weight apple " + appleBox.getWeight());
        System.out.println("weight orange " + orangeBox.getWeight());
        System.out.println("Равен вес коробки яблок и апельсин? " + appleBox.compare(orangeBox));
        appleBox.transfer(fruitBox);
        System.out.println("weight apple " + appleBox.getWeight());
        System.out.println("weight fruit " + fruitBox.getWeight());
    }
}
