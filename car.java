package Week1Inlab;

abstract class Car {
    String regno;
    public Car(String regno) {
        this.regno = regno;
    }

    public void fillTank() {
        System.out.println("Filled the tank.");
    }

    public abstract void steering(int direction);

    public abstract void braking(int force);
}

class Maruthi extends Car {
    public Maruthi(String regno) {
        super(regno);
    }

    @Override
    public void steering(int direction) {
        System.out.println("Maruthi: Steering towards " + direction + " degrees.");
    }

    @Override
    public void braking(int force) {
        System.out.println("Maruthi: Applying brakes with a force of " + force + " units.");
    }
}

class Santro extends Car {
    public Santro(String regno) {
        super(regno);
    }

    @Override
    public void steering(int direction) {
        System.out.println("Santro: Steering towards " + direction + " degrees.");
    }

    @Override
    public void braking(int force) {
        System.out.println("Santro: Applying brakes with a force of " + force + " units.");
    }
}

 class AbstractDemo {
    public static void main(String[] args) {
        Car maruthiCar = new Maruthi("TN 01 AB 1234");
        maruthiCar.fillTank();
        maruthiCar.steering(30);
        maruthiCar.braking(80);
        System.out.println();

        Car santroCar = new Santro("AP 02 CD 5678");
        santroCar.fillTank();
        santroCar.steering(45);
        santroCar.braking(70);
    }
}
