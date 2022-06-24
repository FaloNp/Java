import java.util.Scanner;

public class Main{
    //Zmienne dla wprowadzenia
    int[] date_org = {0, 0, 0, 0, 0, 0, 0};

    //Zmienne dla wlasnego drzewa
    int root;
    int[] date = new int [20];
    boolean[] empty = new boolean [200];
    int floor=3;
    int howmany=0;
    int liczba;

    //szczegoly
    int deep;
    double  fromrighttoleft;
    int direction;
    int flor=0;
    double fromroot;
    int LargeRoot=0;
    int NodeInfo=-1;
    //flagi
    static int flag;

    //Funkcje klasy Main
    void print_menu(){
        System.out.println("==========================================================");
        System.out.println("Program pomaga zrozumiec sposob dzialania drzewa binarnego");
        System.out.println("1.Wprowadzenie");
        System.out.println("2.Zrobienie wlasnego drzewa binarnego");
        System.out.println("3.Wyjscie wpisz 10");
        System.out.println("==========================================================");
        System.out.print("Nacisnij przycisk ");
        int wprowadzonaliczba = new Scanner(System.in).nextInt();
        if (wprowadzonaliczba==1){
            introdution();
        }
        if (wprowadzonaliczba==2){
            flag=5;
            for(int i=0;i<1;i--){
                print();
            }

        }
        if (wprowadzonaliczba==10){
            System.exit(1);
        }
    }
    void introdution(){
        System.out.print("W drzewie binarnym liczby mozna rozstawic na wiele sposob w zaleznosci od kolejnosci ich wprowadzania:" + "\n");
        System.out.print("Dane sa nastepujace liczby:" + "\n");
        date_org = new int[]{1, 2, 3, 4, 5, 6, 7};
        checkdate(date_org);
        System.out.print("\n");
        for(int licznik=0; licznik<7; licznik++) {
            print();

        }
        howmany=0;
        reset();
        System.out.print("Dane sa nastepujace liczby:" + "\n");
        date_org = new int[]{2, 1, 4, 5, 3, 7, 6};
        checkdate(date_org);
        for(int licznik=0; licznik<7; licznik++) {
            print();
        }
        reset();
    }
    void checkdate(int x[]){
        int c=x.length;
        for (int q = 0; q < c; q++) {
            System.out.print(x[q] + " ");
        }
        System.out.println();
    }
    void reset(){
        date_org = new int[]{0, 0, 0, 0, 0, 0, 0};
        for (int f=0; f<20; f++){
            empty[f]=false;
            date[f] = 0;
            flor = 0;
        }

    }
    void print() {
        System.out.println("==========================================================");
        int liczba=1;                                                                                                   //zmienna ktora umozliwa dostep do konkretnej szufladki z danymi np date[5], empty[5]. Uzyta jest zamiast zmiennej 'i', poniewaz jest zbyt wiele petli
        for (int i = 0; i < floor; i++) {                                                                               //petla drukujaca ilosc pieter drzewa
            double power = Math.pow(2, i);
            for (int next = 0; next < 50/power; next++) {                                                               //petla ktora drukuje odstep pierwszego wyrazu danej linii od lewej krawedzi konsoli, czyli zamiast | napis jest |                  napis. Sprawia to ze wierzcholek drzewa jest wysyniety na srodek
                System.out.print(" ");
            }
            for (int next = 0; next < power; next++) {                                                                  //petla odpowiadajaca za ilosc wyrazow na danym pietrze. Przez zastosowanie funckji pow() ilość wyrazow to kolejne wielokrotnosci 2, czyli dla pierwszego pierta: 1, drugiego: 2 i tak dalej
                if (!empty[liczba]) {
                    System.out.print('_');
                } else {
                    System.out.print(date[liczba]);
                }
                for (int nex = 0; nex < 100 / power; nex++) {                                                           //petla ktora powoduje odstep miedzy nastepnymi wyrazami danej linii
                    System.out.print(" ");
                }
                liczba=liczba+1;
            }
            System.out.print('\n');
            System.out.print('\n');
            System.out.print('\n');
        }
        add();

    }

    void add()                                                                                                          //funckja dodajaca wyraz do struktury
    {
        if(flag==5) {
            System.out.println("==========================================================");
            System.out.println("Wpisuj kolejne liczby zeby uzupelnic drzewo");
            System.out.println("Jezeli podasz liczbe 500 wlaczy sie tryb szukania");
            System.out.println("==========================================================");
            System.out.print("Dodaj liczbe: ");
            liczba = new Scanner(System.in).nextInt();
        }
        else {
            liczba=date_org[howmany];
            date_org[howmany]=0;
        }
        if (!empty[1]){
            root=liczba;
            date[1]=root;
            empty[1]=true;
        }
        else {

            boolean wstaw=false;
            int node=1;







            while (!wstaw)
            {
                if((node>NodeInfo)&&liczba!=500) {
                    NodeInfo = node;
                }
                System.out.print("");
                if (!empty[node])
                {
                    wstaw=true;
                    date[node]=liczba;
                    empty[node]=true;

                }
                else if(liczba<date[node])
                {
                    node=2*node;    //umieszcza liczbe w lewym wierzcholku
                }
                else if(liczba>date[node])
                {

                    node=2*node+1; //umieszcza liczbe w prawyum wierzcholku

                }
                else if(liczba==date[node])
                {
                    System.out.println("\nNie mozna powtarzac liczb");
                    wstaw=true;
                }
                if(node>15)
                {
                    wstaw=true;
                    System.out.println("Zbyt male drzewo");

                }
            }


        }

        howmany=howmany+1;
        if (liczba==500){
            find();
        }
    }
    void find(){
        System.out.print("Podaj liczbe do znalezieinia ");
        int liczba = new Scanner(System.in).nextInt();
        boolean znaleziona=false;
        int node=1;
        while (!znaleziona) {

            if(liczba==date[node])
            {
                if (NodeInfo==2 || NodeInfo==3){
                    deep=1;
                }
                else{
                    deep=2;
                }
                fromrighttoleft=Math.pow(2,deep);
                System.out.println("LargeRoot" + NodeInfo);
                System.out.println("==========================================================");
                System.out.println("Informacje o wezlie \n");
                System.out.print("Znaleziono liczbe w wezle nr " + node + "\n");
                System.out.print("Wysokosc badanego drzewa " + (deep + 1) + "\n");
                System.out.print("Szerokosc badanego drzewa " + fromrighttoleft + "\n");
                if (direction==0 && flor!=0){
                    System.out.println("Kierunek wezla lewo ");
                }
                else if ( direction==1 && flor!=0 ){
                    System.out.println("Kierunek wezla prawo ");
                }
                else{
                    System.out.println("Korzen ");
                    break;
                }
                System.out.print("");
                if(LargeRoot==1) {
                    if(direction==1){
                        direction=0;
                    }
                    else if(direction==0){
                        direction=1;
                    }

                }

                fromroot = (Math.pow(2, (flor - 1))) - direction;

                System.out.print("Pietro wyszukanego wezla " + (flor+1) + " \n ");
                System.out.print("Odleglosc wezla od korzenia " + fromroot + "\n");
                System.out.print("==========================================================");
                znaleziona=true;
            }
            else if(liczba==date[1])
            {
                direction=11;
                znaleziona=true;
            }
            else if(liczba<date[node])
            {
                //w lewo
                node=2*node;
                direction=0;
                if(empty[node]==true) {
                    flor = flor + 1;
                }
            }
            else
            {
                //w prawo
                node=2*node+1;
                System.out.println("flor" + flor);
                direction=1;
                if(flor==0) {   //sprawdza kierunek od korzenia
                    LargeRoot=1;
                }
                if(empty[node]==true) {
                    flor = flor + 1;
                }

            }
            if(node>7)
            {
                System.out.print("Nie ma");
                znaleziona=true;
            }
        }
        System.out.print( " \n ");
        reset();

    }
    public static void main(String[] args) {
        Main menu = new Main();
        menu.print_menu();

    }
}
