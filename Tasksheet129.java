interface Animal {
    boolean feed(boolean timeToEat);
    void groom();
    void pet();
}

class Gorilla implements Animal {

    @Override
    public boolean feed(boolean timeToEat) {
        if(timeToEat) {
            System.out.println("Putting gorilla food into the cage.");
            // put gorilla food into cage
            return true;
        } else {
            System.out.println("It's not feeding time yet.");
            return false;
        }
    }

    @Override
    public void groom() {
        System.out.println("Grooming the gorilla...");
        // lather, rinse, repeat
    }

    @Override
    public void pet() {
        System.out.println("Approaching the gorilla carefully...");
        // pet at your own risk
    }
}

public class Tasksheet129 {
    public static void main(String[] args) {
        Gorilla gorilla = new Gorilla();

        gorilla.feed(true);

        gorilla.groom();

        gorilla.pet();
    }
}
