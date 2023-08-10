package singletondesignpattern;

import java.util.Objects;

/**
 * Singleton is a class that demonstrates different types of singleton design patterns.
 */
public class Singleton {

    /**
     * The main method demonstrates the usage of different singleton patterns.
     *
     * @param args Command-line arguments
     * @link https://www.youtube.com/watch?v=VGLjQuEQgkI&list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx
     */
    public static void main(String args[]) {
        // Choose the type of singleton to useq
        SingletonType type = SingletonType.SYNCHRONIZED_SPECIFIC;

        // Create an instance based on the selected type
        SingletonBase instance = null;
        switch (type) {
            case EAGER_INITIALIZATION:
                instance = SingletonEager.getInstance();
                break;
            case LAZY_INITIALIZATION:
                instance = SingletonLazyInitialization.getInstance();
                break;
            case SYNCHRONIZED:
                instance = SingletonSynchronized.getInstance();
                break;
            case SYNCHRONIZED_SPECIFIC:
                instance = SingletonSynchronizedSpecific.getInstance();
                break;
        }

        // Print the address of the instance
        System.out.println(instance);

        // Create another instance using the same type
        SingletonBase instance1 = null;
        switch (type) {
            case EAGER_INITIALIZATION:
                instance1 = SingletonEager.getInstance();
                break;
            case LAZY_INITIALIZATION:
                instance1 = SingletonLazyInitialization.getInstance();
                break;
            case SYNCHRONIZED:
                instance1 = SingletonSynchronized.getInstance();
                break;
            case SYNCHRONIZED_SPECIFIC:
                instance1 = SingletonSynchronizedSpecific.getInstance();
                break;
        }

        // Print the address of the second instance, which should be the same as the first instance
        System.out.println(instance1);
    }
}

/**
 * SingletonType is an enumeration representing different types of singleton patterns.
 */
enum SingletonType {
    /**
     * EAGER_INITIALIZATION represents the singleton pattern with eager initialization.
     */
    EAGER_INITIALIZATION,

    /**
     * LAZY_INITIALIZATION represents the singleton pattern with lazy initialization.
     */
    LAZY_INITIALIZATION,

    /**
     * SYNCHRONIZED represents the singleton pattern with lazy initialization and synchronized getInstance() method.
     */
    SYNCHRONIZED,

    /**
     * SYNCHRONIZED_SPECIFIC represents the singleton pattern with lazy initialization and double-checked locking.
     */
    SYNCHRONIZED_SPECIFIC
}

/**
 * SingletonBase is an abstract class representing the base class for singleton implementations.
 */
abstract class SingletonBase {
    // Common methods or properties for singletons can be defined here
}

/**
 * SingletonEager is a singleton class that follows eager initialization.
 */
class SingletonEager extends SingletonBase {
    private static SingletonEager instance = new SingletonEager();

    /**
     * Private constructor to prevent direct instantiation of the class.
     * This ensures that the class can only be instantiated from within the class itself.
     */
    private SingletonEager() {
        // Initialization code, if any
    }

    /**
     * Returns the instance of SingletonEager.
     *
     * @return The single instance of SingletonEager.
     */
    public static SingletonEager getInstance() {
        return instance;
    }
}

/**
 * SingletonLazyInitialization is a singleton class that follows lazy initialization.
 */
class SingletonLazyInitialization extends SingletonBase {
    private static SingletonLazyInitialization instance;

    private SingletonLazyInitialization() {
    }

    /**
     * Returns the instance of SingletonLazyInitialization.
     *
     * @return The single instance of SingletonLazyInitialization.
     */
    public static SingletonLazyInitialization getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SingletonLazyInitialization();
        }
        return instance;
    }
}

/**
 * SingletonSynchronized is a singleton class that follows lazy initialization and synchronized getInstance() method.
 */
class SingletonSynchronized extends SingletonBase {
    private static SingletonSynchronized instance;

    private SingletonSynchronized() {
    }

    /**
     * Returns the instance of SingletonSynchronized.
     *
     * @return The single instance of SingletonSynchronized.
     */
    public static synchronized SingletonSynchronized getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SingletonSynchronized();
        }
        return instance;
    }
}

/**
 * SingletonSynchronizedSpecific is a singleton class that follows lazy initialization and uses double-checked locking.
 */
class SingletonSynchronizedSpecific extends SingletonBase {
    private static SingletonSynchronizedSpecific instance;

    private SingletonSynchronizedSpecific() {
    }

    /**
     * Returns the instance of SingletonSynchronizedSpecific.
     *
     * @return The single instance of SingletonSynchronizedSpecific.
     */
    public static SingletonSynchronizedSpecific getInstance() {
        if (instance == null)  synchronized (SingletonSynchronizedSpecific.class) {
                if (instance == null) {
                    instance = new SingletonSynchronizedSpecific();
                }
            }
        
        return instance;
    }
}
