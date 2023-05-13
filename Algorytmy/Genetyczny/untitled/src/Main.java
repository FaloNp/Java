import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ilosc liczb które się zmieszcza w wyznaczonym zakresie: "+ilemiejscwzakresie(-2,2,5));
        System.out.println("Minimalna liczba bitow by zakodowac zakres: "+ IlebitowbyWypelnicZakres(ilemiejscwzakresie(-2,2,5)));
        System.out.println("Liczba chromosonow: "+ (2*IlebitowbyWypelnicZakres(ilemiejscwzakresie(-2,2,5))));
        int[] wyraz=MakeArray(2*IlebitowbyWypelnicZakres(ilemiejscwzakresie(-2,2,5)));
        System.out.println(Arrays.toString(wyraz));



        double[] odpowiedz=decodeChromosome(wyraz,-2,2,19,2);
        System.out.println(Arrays.toString(odpowiedz));

        double fxmax=fmaxFunkcji(odpowiedz[0],odpowiedz[1]);
        System.out.println("Fxmax:" + fxmax);
    }
    static double fmaxFunkcji(double x1,double x2){
        double fmax=-(x1*x1)-(x2*x2)+2;
        return (fmax);
    }

    static int losowybit(){
        Random rand = new Random();
        int x1=rand.nextInt(2);
        return x1;
    }
    static int ilemiejscwzakresie (double zakresod, double zakresdo, int dokladnosc){
        double x=(zakresdo-zakresod);
        for(int i=0;i<dokladnosc;i++){
            x=x*10;
        }
        int y=(int)x;
        return y;
    }
    static int IlebitowbyWypelnicZakres(int x){
        int y=(int)(Math.ceil(Math.log(x) / Math.log(2)));
        return y;
    }
    static int[] MakeArray(int lenght){
        int[] array = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i] = losowybit();
        }
        return array;
    }
    public static double[] decodeChromosome(int[] chromosome, double a, double b, int m, int n) {
        double[] values = new double[n];
        int bitsPerVariable = m;
        for (int i = 0; i < n; i++) {
            int startIndex = i * bitsPerVariable;
            int endIndex = startIndex + bitsPerVariable;
            int intValue = 0;
            for (int j = startIndex; j < endIndex; j++) {
                intValue = (intValue << 1) + chromosome[j];
            }
            double x = a + intValue * (b - a) / (Math.pow(2, bitsPerVariable) - 1);
            values[i] = x;
        }
        return values;
    }
    public static boolean areValuesValid(double[] values, double a, double b) {
        for (double value : values) {
            if (value < a || value > b) {
                return false;
            }
        }
        return true;
    }

}