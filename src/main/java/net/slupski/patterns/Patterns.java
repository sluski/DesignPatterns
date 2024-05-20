package net.slupski.patterns;

public class Patterns {
    
    public static void main(String[] args) {
        var factoryPattern = new AbstractFactory();
        var prototypePattern = new Prototype();
        var builderPattern = new Builder();
        var singletonPattern = new Singleton();
        var chainOfResponsibility = new ChainOfResponsibility();
        factoryPattern.accept(1);
        prototypePattern.accept(2);
        builderPattern.accept(3);
        singletonPattern.accept(4);
        chainOfResponsibility.accept(5);
    }
    
}
