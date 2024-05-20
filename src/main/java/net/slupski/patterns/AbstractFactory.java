package net.slupski.patterns;


public class AbstractFactory extends Pattern {

    @Override
    void example() {
        var restaurant1 = new VegeRestaurant();
        var restaurant2 = new TexMexRestuarant();

        restaurant1.createBurger().printName();
        restaurant2.createFries().printName();
    }

    class TexMexRestuarant implements RestaurantFactory {

        @Override
        public Burger createBurger() {
            return new TexMexBurger();
        }

        @Override
        public Fries createFries() {
            return new TexMexFries();
        }

    }

    class VegeRestaurant implements RestaurantFactory {

        @Override
        public Burger createBurger() {
            return new VegeBurger();
        }

        @Override
        public Fries createFries() {
            return new VegeFries();
        }

    }

    interface RestaurantFactory {

        Burger createBurger();

        Fries createFries();
    }

    interface Fries {

        void printName();
    }

    class TexMexFries implements Fries {

        @Override
        public void printName() {
            System.out.println("Tex Mex fries");
        }

    }

    class VegeFries implements Fries {

        @Override
        public void printName() {
            System.out.println("Vege fires");
        }
    }

    interface Burger {

        void printName();
    }

    class VegeBurger implements Burger {

        @Override
        public void printName() {
            System.out.println("Vege burger");
        }

    }

    class TexMexBurger implements Burger {

        @Override
        public void printName() {
            System.out.println("Tex Mex burger");
        }

    }
}
