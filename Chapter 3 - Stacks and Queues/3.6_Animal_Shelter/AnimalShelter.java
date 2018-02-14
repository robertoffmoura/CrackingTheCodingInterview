import java.util.LinkedList;

/*
An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in LinkedList data structure.
*/

public class AnimalShelter {
    public class Animal {
        String type;
        long timeOfEntrace;
        public Animal(String type, long timeOfEntrace) {
            this.type = type.equals("dog") ? "dog" : "cat";
            this.timeOfEntrace = timeOfEntrace;
        }
    }

    LinkedList<Animal> dogQueue = new LinkedList<Animal>();
    LinkedList<Animal> catQueue = new LinkedList<Animal>();

    void enqueue(String type) {
        Animal animal = new Animal(type, System.currentTimeMillis());
        if (type.equals("dog")) {
            dogQueue.addLast(animal);
        } else {
            catQueue.addLast(animal);
        }
    }

    Animal dequeueDog() {
        return dogQueue.removeFirst();
    }

    Animal dequeueCat() {
        return catQueue.removeFirst();
    }

    Animal dequeueAny() {
        if (dogQueue.isEmpty()) {
            return catQueue.pop();
        }
        if (catQueue.isEmpty()) {
            return dogQueue.pop();
        }
        return (dogQueue.peekFirst().timeOfEntrace < catQueue.peekFirst().timeOfEntrace) ? dogQueue.pop() : catQueue.pop();
    }

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("cat");
        shelter.enqueue("cat");
        shelter.enqueue("dog");
        shelter.enqueue("cat");
        shelter.enqueue("cat");
        shelter.enqueue("dog");
        System.out.println(shelter.dequeueAny().type);
        System.out.println(shelter.dequeueDog().type);
        System.out.println(shelter.dequeueCat().type);
        System.out.println(shelter.dequeueAny().type);
        System.out.println(shelter.dequeueAny().type);
        System.out.println(shelter.dequeueAny().type);
    }
}
