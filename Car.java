import java.util.Scanner;

public class Car {
  String carModel;
  double mpgRate;
  double gasTank;

    public Car(String model, double mpg, double gasTankCapacity) {
      carModel = model;
      mpgRate = mpg;
      gasTank = gasTankCapacity;
    }

    public static void main(String[] args) {
        // Create a new Car object, asking the user (using the scanner class) for the model, mpg, and gasTankCapacity
        Scanner sc = new Scanner(System.in);
        System.out.print("Model: ");
        String model = sc.nextLine();
        System.out.print("MPG: ");
        double mpg = sc.nextDouble();
        System.out.print("Gas Tank Capacity: ");
        double gasTankCapacity = sc.nextDouble();
        Car car = new Car(model, mpg, gasTankCapacity);

        // Refuel the car to its maximum gas capacity
        car.refuel(gasTankCapacity);

        // Print out car information
        System.out.println(car);

        // Ask the user how many miles they want to drive, then drive that distance, and then report back the car's remaining gas and range after the drive.
        System.out.print("How far do you want to drive? ");
        double miles = sc.nextDouble();
        car.drive(miles);
        System.out.println("Remaining Gas: " + car.getGasRemaining() + ", Remaining Range: " + car.getRange());

        // Ask the user how much gas they want to add, and then refuel the car that amount
        System.out.print("How much gas do you want to add? ");
        double gas = sc.nextDouble();
        car.refuel(gas);

        // Ask the user how many miles they want to drive, then drive that distance, and then report back the car's remaining gas and range after the drive.
        System.out.print("How far do you want to drive? ");
        miles = sc.nextDouble();
        car.drive(miles);
        System.out.println("Remaining Gas: " + car.getGasRemaining() + ", Remaining Range: " + car.getRange());
    }

    public void drive(double distance) {
        // drive for distance (in miles), and update gas tank level accordingly (using mpg)
      gasTank = gasTank - (distance/mpgRate);
      System.out.println("You drive for " + distance + " miles.");
    }

    public void refuel(double gasAmount) {
        // Add gasAmount of gas to the gas tank
      gasTank = gasTank + gasAmount;
      System.out.println("You added " + gasAmount + " gallons of gas and now have " + gasTank + " gallons in your tank.");
    }

    public double getGasRemaining() {
        // Return the number of gallons of gas currently in the gas tank
      return gasTank;
    }

    public double getRange() {
        // Return the estimated amount of miles the car can drive based on current gas remaining and MPG (provided to constructor)
      double range = gasTank * mpgRate;
      return range;
    }

    public String toString() {
        // Return a string representation of the car's current state.
      return "This car is a " + carModel + ". It's got " + mpgRate + "mpg and " + gasTank + "gas tank capacity.";
        // Be sure to include range, model, and gas level.
    }
}
