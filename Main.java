import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Main {
    private static int Picked;
    static String YesOrNO = " ";//makes the decision to go back by pressing y or n
private static double input;
    public static void main(String[] args) {
        System.out.println("welcome to currency converter ");

        List<Double> List = new ArrayList<Double>();//a list containing doubles
        Scanner scanner = new Scanner(System.in);// an object to hold user input
        do {
            boolean done = false;// a test for non int
            while (!done) {
                System.out.println("Enter 1 for ILS to USD or 2 for USD to ILS ");
                try {
                    int n = scanner.nextInt();
                    if (n == 1 || n == 2) {
                        Picked = n;
                        done = true;

                    } else {
                        // The input was definitely an integer and was definitely
                        // not the "quit" value.  Do what you need to do with it.
                        System.out.println("\tThe number entered was: " + n);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\tInvalid input type (must be an integer)");
                    scanner.nextLine();  // Clear invalid input from scanner buffer.
                }

                if (Picked == 1) {   // case number 1
                    Coin ilsValue = CoinFactory.getCoinInstance(Coins.ILS);
                    boolean check = false;// a try and catch for non double values
                    while (!check) {
                        System.out.println("Enter amount to convert");                        try {
                            double n = scanner.nextDouble();
                            if (n>0) {
                                input=n;
                                check = true;
                            }

                            else {
                                System.out.println("\tThe input entered was: " + n);
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("\tInvalid input type (must be an a double)");
                            scanner.nextLine();  // Clear invalid input from scanner buffer.
                        }
                    }

                        assert ilsValue != null;
                        double value = ilsValue.Calculate(input);
                        System.out.println(value);
                        List.add(value);
                        counter++;
                        String strDouble = String.format("%.2f", value);
                        try {
                            FileWriter fw = new FileWriter("D:\\results.txt");
                            fw.write(strDouble);
                            fw.close();
                        } catch (Exception e) {
                            System.out.println(e);

                    }
                }
                if (Picked == 2) {
                    Coin usdValue = CoinFactory.getCoinInstance(Coins.USD);

                    boolean check = false;// a try and catch for non double values
                    while (!check) {
                        System.out.println("Enter amount to convert");                        try {
                            double n = scanner.nextDouble();
                            if (n>0) {
                                input=n;
                                check = true;
                            }

                            else {
                                System.out.println("\tThe input entered was: " + n);
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("\tInvalid input type (must be an a double)");
                            scanner.nextLine();  // Clear invalid input from scanner buffer.
                        }
                    }


                        assert usdValue != null;
                        double value = usdValue.Calculate(input);
                        System.out.println(value);
                        List.add(value);
                        counter++;
                        String strDouble = String.format("%.2f", value);
                        try {
                            FileWriter fw = new FileWriter("D:\\results.txt");
                            fw.write(strDouble);
                            fw.close();
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                    }

                boolean check = false;// a try and catch for non string values
                while (!check) {
                    System.out.println("would you like to try again enter Y. Exit? press N");
                    try {
                        String n = scanner.next();
                        if (n.equals("Y")||n.equals("y")) {
                            YesOrNO=n;
                                    check = true;
                        }
                        if (n.equals("n")||n.equals("N")){
                            YesOrNO=n;
                            check = true;
                        }
                        else {
                            System.out.println("\tThe input entered was: " + n);
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println("\tInvalid input type (must be an string)");
                        scanner.nextLine();  // Clear invalid input from scanner buffer.
                    }
                }
                if (YesOrNO.equals("n") || YesOrNO.equals("N")) {
                    System.out.println("thank you for using currency converter");
                        System.out.println("search history:" + List);


                } else {
                    Picked=0;
                    break;
                }

            }
        } while (YesOrNO.equals("Y") || YesOrNO.equals("y"));// the loop condition for the do while

    }
}


