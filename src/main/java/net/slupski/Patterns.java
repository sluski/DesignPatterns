package net.slupski;


import net.slupski.patterns.*;

public class Patterns {
    
    public static void main(String[] args) {
        new AbstractFactory().accept(1);
        new Prototype().accept(2);
        new Builder().accept(3);
        new Singleton().accept(4);
        new ChainOfResponsibility().accept(5);
        new Command().accept(6);
        new Template().accept(7);
        new Memento().accept(8);
    }
    
}
