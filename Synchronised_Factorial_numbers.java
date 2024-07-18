package apjfsa;

class FactorialSynchronization {
	public synchronized void factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + n + " is: " + fact);
    }
}

    

public class Synchronised_Factorial_numbers extends Thread {
    FactorialSynchronization fse;
    int number;

    public Synchronised_Factorial_numbers(FactorialSynchronization fse, int number) {
        this.fse = fse;
        this.number = number;
    }

    public void run() {
        fse.factorial(number);
    }

    public static void main(String[] args) {
        FactorialSynchronization fs = new FactorialSynchronization();

        Synchronised_Factorial_numbers sfn1 = new Synchronised_Factorial_numbers(fs, 4);
        
        Synchronised_Factorial_numbers sfn2 = new Synchronised_Factorial_numbers(fs, 3);
        
        Synchronised_Factorial_numbers sfn3 = new Synchronised_Factorial_numbers(fs, 2);

        sfn1.start();
        
        sfn2.start();
        
        sfn3.start();
    }
}
