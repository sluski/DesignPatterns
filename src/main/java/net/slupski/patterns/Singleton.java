package net.slupski.patterns;


public class Singleton extends Pattern {

    @Override
    void example() {
        var instance1 = SingletonClass.getInstance("instance1");
        System.out.println(instance1.toString()); // should be text = "instance1
        var instance2 = SingletonClass.getInstance("instance2");
        System.out.println(instance2.toString()); // should be text = "instance1"
        instance2.setText("instance2 text2");
        System.out.println(instance2.toString()); // should be text = "instance2 text2"
        instance1.setText("instance1 text2");
        System.out.println(instance2.toString()); // should be text = "instance1 text2"
    }

}

class SingletonClass {

    private static SingletonClass instance;

    private String text;

    private SingletonClass(String initializeValue) {
        this.text = initializeValue;
    }

    public static SingletonClass getInstance(String initializeValue) {
        var localInstance = SingletonClass.instance;
        if (localInstance == null) {
            synchronized (SingletonClass.class) {
                if (localInstance == null) {
                    localInstance = new SingletonClass(initializeValue);
                }
            }
        }
        return localInstance;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "SingletonClass{" + "text=" + text + '}';
    }

}
