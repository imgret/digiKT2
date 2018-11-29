import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        BinaryMultiplier multiplier = new BinaryMultiplier(3, 10, 10, 11);

        int Rg1Value = 0;
        int Rg2Value = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please chose operands format");
        System.out.println(" ( b for binary and d for decimal )");
        System.out.print("Format: ");
        String format = scanner.nextLine();
        if (format.equals("b")) {
            System.out.print("Rg1: ");
            Rg1Value = Integer.parseInt(scanner.nextLine(), 2);
            System.out.print("Rg2: ");
            Rg2Value = Integer.parseInt(scanner.nextLine(), 2);
            scanner.close();
        }
        else if (format.equals("d")) {
            System.out.print("Rg1: ");
            Rg1Value = scanner.nextInt();
            System.out.print("Rg2: ");
            Rg2Value = scanner.nextInt();
            scanner.close();
        }

        multiplier.counter.setValue(0b101);
        multiplier.Rg1.setValue(Rg1Value);
        multiplier.Rg2.setValue(Rg2Value);
        multiplier.Rg3.setValue(0);
        multiplier.multiply();
    }
}
