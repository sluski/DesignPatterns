package net.slupski.patterns;


public class Template extends Pattern {

    @Override
    void example() {
         BaseGameLoader wowLoader = new WowGameLoader();
         BaseGameLoader witcherLoader = new WitcherGameLoader();
         
         wowLoader.load();
         witcherLoader.load();
    }
    
}

abstract class BaseGameLoader {
    
    final void load() {
        loadLocalData();
        createObjects();
        clearTemporaryFiles();
    }
    
    abstract void loadLocalData();
    abstract void createObjects();
    
    void clearTemporaryFiles() {
        System.out.println("Clearing temporary files...");
    }
}

class WowGameLoader extends BaseGameLoader {

    @Override
    void loadLocalData() {
        System.out.println("Loading local data for Wow");
    }

    @Override
    void createObjects() {
        System.out.println("Creating objects for Wow");
    }

}

class WitcherGameLoader extends BaseGameLoader {

    @Override
    void loadLocalData() {
        System.out.println("Loading local data for Witcher");
    }

    @Override
    void createObjects() {
        System.out.println("Creating objects for Witcher");
    }

}