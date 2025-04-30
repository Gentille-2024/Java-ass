package com.mycompany.test1;

import java.util.InputMismatchException;
import java.util.Scanner;

interface Polygon {
    String getName();
    int getNumberOfSides();
    int totalIntAngleSum();
}

class Quadrilateral {
    String typeOfQuadrilateral;

    public Quadrilateral(String type) {
        this.typeOfQuadrilateral = type;
        System.out.println("Type of Quadrilateral: " + typeOfQuadrilateral);
    }

    public Quadrilateral() {
        System.out.println("Hello Student");
    }

    public Quadrilateral(String name, String type) {
        System.out.println("Name: " + name + ", Type of Quadrilateral: " + type);
    }

    public double getArea(double side) {
        return side * side;
    }

    public double getArea(double length, double width) {
        return length * width;
    }

    public double getArea(double a, double b, double h) {
        return ((a + b) * h) / 2;
    }
}

class Square {
    public static void calculateSquareArea() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter side of the Square: ");
            double side = scanner.nextDouble();
            if (side <= 0) throw new IllegalArgumentException("Side must be positive.");

            Quadrilateral square = new Quadrilateral("Square");
            double area = square.getArea(side);
            System.out.println("Area of the Square: " + area);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // clear buffer
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Rectangle {
    public static void calculateRectangleArea() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter length of the Rectangle: ");
            double length = scanner.nextDouble();
            if (length <= 0) throw new IllegalArgumentException("Length must be positive.");

            System.out.print("Enter width of the Rectangle: ");
            double width = scanner.nextDouble();
            if (width <= 0) throw new IllegalArgumentException("Width must be positive.");

            Quadrilateral rectangle = new Quadrilateral("User", "Rectangle");
            double area = rectangle.getArea(length, width);
            System.out.println("Area of the Rectangle: " + area);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // clear buffer
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Trapezium implements Polygon {
    private String name = "Trapezium";
    private int numberOfSides = 4;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfSides() {
        return numberOfSides;
    }

    @Override
    public int totalIntAngleSum() {
        return (numberOfSides - 2) * 180;
    }

    public static void calculateTrapeziumArea() {
        Scanner scanner = new Scanner(System.in);
        try {
            Quadrilateral trapezium = new Quadrilateral();

            System.out.print("Enter small base of the Trapezium: ");
            double a = scanner.nextDouble();
            if (a <= 0) throw new IllegalArgumentException("Base must be positive.");

            System.out.print("Enter big base of the Trapezium: ");
            double b = scanner.nextDouble();
            if (b <= 0) throw new IllegalArgumentException("Base must be positive.");

            System.out.print("Enter height of the Trapezium: ");
            double h = scanner.nextDouble();
            if (h <= 0) throw new IllegalArgumentException("Height must be positive.");

            double area = trapezium.getArea(a, b, h);
            System.out.println("Area of the Trapezium: " + area);

            Trapezium trapeziumObj = new Trapezium();
            System.out.println("Polygon Name: " + trapeziumObj.getName());
            System.out.println("Number of Sides: " + trapeziumObj.getNumberOfSides());
            System.out.println("Total Interior Angle Sum: " + trapeziumObj.totalIntAngleSum());

            thankYouMessage();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // clear buffer
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void thankYouMessage() {
        System.out.println("Thank you for using the program!");
    }
}

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nChoose a shape to calculate area:");
                System.out.println("1. Square");
                System.out.println("2. Rectangle");
                System.out.println("3. Trapezium");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Square.calculateSquareArea();
                        break;
                    case 2:
                        Rectangle.calculateRectangleArea();
                        break;
                    case 3:
                        Trapezium.calculateTrapeziumArea();
                        break;
                    case 4:
                        System.out.println("Exiting the program...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }

                System.out.print("Do you want to calculate another shape? (yes/no): ");
                String repeat = scanner.next();
                if (repeat.equalsIgnoreCase("no")) {
                    System.out.println("Thank you for using the program!");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear buffer
            }
        }
    }
}
