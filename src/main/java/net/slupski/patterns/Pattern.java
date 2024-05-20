package net.slupski.patterns;

import java.util.function.Consumer;

public abstract class Pattern implements Consumer<Integer>{

    @Override
    public void accept(Integer index) {
        Utils.printIndex(index);
        example();
    }
    
    abstract void example();
    
}
