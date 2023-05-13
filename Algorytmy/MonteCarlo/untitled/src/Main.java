import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static double x1,x2,xi1,xi2,x1tylda,x2tylda;
    static double fxmax,fxtylda,fxi;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Liczba iteracji: ");
        int iteracja= scan.nextInt();
        x1 = losowaliczba();
        x2 = losowaliczba();
        double y = 0.00000001;
        double t = 100;
        fxmax = fmaxFunkcji(x1,x2);
        for(int i=1;i<iteracja+1;i++){
            if(i==1){
                xi1=x1;
                xi2=x2;
            }
            saveToFile("current.txt",fxmax);
            int w = losowybit();
            int sigma=losowybit();
            if(w==1){
               x1tylda=xi1+y*sigma*sigma;
               x2tylda=xi2+y*sigma*sigma;
            }
            else{
                x1tylda=xi1-y*sigma*sigma;
                x2tylda=xi2-y*sigma*sigma;
            }
            fxtylda=fmaxFunkcji(x1tylda,x2tylda);
            if(fxtylda>fmaxFunkcji(x1,x2)){
                fxmax=fxtylda;
                x1=x1tylda;
                x2=x2tylda;
                xi1=x1tylda;
                xi2=x2tylda;
                System.out.println("Fmax po iteracji: "+i+" to: "+fxmax);
                System.out.println("Argument x1: "+x1);
                System.out.println("Argument x2: "+x2);
                System.out.println();
            }
            else {
                fxi=fmaxFunkcji(xi1,xi2);
                int z = losowybit();
                if (z < Math.exp((fxtylda - fxi) / t)) {
                    fxmax = fxtylda;
                    x1 = x1tylda;
                    x2 = x2tylda;
                    xi1 = x1tylda;
                    xi2 = x2tylda;
                }
            }
            saveToFile("bestStep.txt",fxmax);

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
    static int liczba0lub1(){
        Random rand = new Random();
        int x1=rand.nextInt(2);
        return x1;
    }
    static void saveToFile(String nazwa,double value){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nazwa, true));
            bw.write(Double.toString(value));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    static int losowybit(){
        Random rand = new Random();
        int x1=rand.nextInt(2);
        return x1;
    }
}