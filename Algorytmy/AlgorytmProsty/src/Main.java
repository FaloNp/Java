import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Liczba iteracji: ");
        int iteracja= scan.nextInt();
        double x1 = losowaliczba();
        double x2 = losowaliczba();
        double x1_copy=0;
        double x2_copy=0;
        double fmax = fmaxFunkcji(x1,x2);
        for(int i=1;i<iteracja+1;i++){
            x1 = losowaliczba();
            x2 = losowaliczba();
            double x0=fmaxFunkcji(x1,x2);
            saveToFile("current.txt",x0);
            if(x0>fmax){
                fmax=x0;
                x1_copy=x1;
                x2_copy=x2;
                System.out.println("Fmax po iteracji: "+i+" to: "+fmax);
                System.out.println("Argument x1: "+x1_copy);
                System.out.println("Argument x2: "+x2_copy);
                System.out.println();

            }
            saveToFile("bestStep.txt",fmax);


        }
    }
    static double fmaxFunkcji(double x1,double x2){
        double fmax=-(x1*x1)-(x2*x2)+2;
        return (fmax);
    }
    static double losowaliczba(){
        Random rand = new Random();
        double x1 = -2 + (2 - -2) * rand.nextDouble();
        return x1;
    }
    static void saveToFile(String nazwa,double value){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nazwa, true));
            bw.write(Double.toString(value));
            bw.newLine();
            bw.close();
            //System.out.println("Value saved to file: " + nazwa);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}