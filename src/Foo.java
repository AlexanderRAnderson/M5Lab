import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Foo {
    Scanner scanner;
    File inputFile, outputFile;
    FileWriter writer;
    int firstValue, secondValue, testCaseNumber = 0, sum = 0;


    Foo() {
        inputFile = new File("src/Eq.txt");
        outputFile = new File("src/test.txt");

        try {
            scanner = new Scanner(inputFile);
            outputFile.createNewFile();
            writer = new FileWriter(outputFile);
        } catch (Exception e) {
            System.out.println("An error has occurred");
        }
    }

    public int foo(int n) {
        int fooSum = 0;
        while (scanner.hasNext()) {
            Random random = new Random();
            String nextValue = scanner.next();
            if (nextValue.endsWith(",")) {
                nextValue = nextValue.substring(0, nextValue.length() - 1);
                firstValue = Integer.parseInt(nextValue);
                if(testCaseNumber == 0) {
                    String valueString = firstValue - 1 + " ";
                    try {
                        writer.append(valueString);
                    } catch (Exception e) {
                        System.out.println("Can't write to file");
                    }
                }
            } else if (nextValue.endsWith(";")) {
                nextValue = nextValue.substring(0, nextValue.length() - 1);
                secondValue = Integer.parseInt(nextValue);
                testCaseNumber++;
                try {
                    writer.append(firstValue + " " + (firstValue + 1) + " " + secondValue + " ");
                } catch (Exception e) {
                    System.out.println("Can't write to file");
                }
                if (this.check(n) > 0) {
                    fooSum += this.check(n);
                }
            } else {
                secondValue = Integer.parseInt(nextValue);
                testCaseNumber++;
                fooSum += this.check(n);
                testCaseNumber = 0;
                try {
                    writer.append(firstValue + " " + (firstValue + 1) + " " + secondValue + " " + (secondValue + 1) + "\n");
                } catch (Exception e) {
                    System.out.println("Can't write to file");
                }
                return fooSum + foo(random.nextInt(30) + 1);
            }
        }
        try {
            writer.close();
        } catch (Exception e) {
            System.out.println("Could not close file");
        }

        return fooSum;
    }

    private int check(int val) {
        if (val >= firstValue && val <= secondValue) {
            return testCaseNumber;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Foo foo = new Foo();
        int num = random.nextInt(30) + 1;
        System.out.println(foo.foo(num));

    }

    public int fooOld(int n) {
        while (scanner.hasNext()) {
            String nextValue = scanner.next();
            if (nextValue.endsWith(",")) {
                nextValue = nextValue.substring(0, nextValue.length() - 1);
                firstValue = Integer.parseInt(nextValue);
            } else if (nextValue.endsWith(";")) {
                nextValue = nextValue.substring(0, nextValue.length() - 1);
                secondValue = Integer.parseInt(nextValue);
                testCaseNumber++;
                if (this.check(n) > 0) {
                    sum += this.check(n);
                }
            } else {
                secondValue = Integer.parseInt(nextValue);
                testCaseNumber++;
                if (this.check(n) > 0) {
                    Random random = new Random();

                    sum += this.check(n);
                    //return sum += foo(random.nextInt(30) + 1);
                }
                testCaseNumber = 0;
            }
        }
        return sum;
    }

}
