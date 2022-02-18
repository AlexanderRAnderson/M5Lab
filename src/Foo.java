import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Foo {
    Scanner scanner;
    File file;
    int firstValue, secondValue, testCaseNumber = 0, sum = 0;


    Foo() {
        File file = new File("src/Eq.txt");
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {

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
            } else if (nextValue.endsWith(";")) {
                nextValue = nextValue.substring(0, nextValue.length() - 1);
                secondValue = Integer.parseInt(nextValue);
                testCaseNumber++;
                if (this.check(n) > 0) {
                    fooSum += this.check(n);
                }
            } else {
                secondValue = Integer.parseInt(nextValue);
                testCaseNumber++;
                if (this.check(n) > 0) {
                    return this.check(n) + foo(random.nextInt(30) + 1);
                }
                testCaseNumber = 0;
            }
        }

        return -1;
    }

    private int check(int val) {
        if (val >= firstValue && val <= secondValue) {
            return testCaseNumber;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Foo foo = new Foo();
        int num = random.nextInt(30) + 1;
        System.out.println(num);
        System.out.println(foo.foo(num));
        foo.resetSum();
        foo.resetScanner();
        System.out.println(foo.fooOld(num));
        System.out.println("I swear this works");
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

    public void resetSum() {
        sum = 0;
    }

    public void resetScanner() {
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {

        }
    }
}
