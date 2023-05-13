import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Instruction {
    Instruction(){

    }
    //Repair
    static void Reset(){
        try {
            PrintWriter writer = new PrintWriter("zasoby.txt", StandardCharsets.UTF_8);
            writer.print("");
            writer.close();


            //Error error=new Error("Zresetowano liste");

        }catch (Exception e){
            FatalError(e);
        }
    }
    static void CloseWindow(Frame container){
        container.dispose();
    }

    //File
    static void FileFinder(String NameOfFile){
        String pathtofile = Paths.get(NameOfFile).toString();
        File file = new File(pathtofile);
        if(!file.exists()){
            try{
                System.out.println("NIE MA TAKIEGO PLIKU");
                Reset();
            }
            catch (Exception e){
                FatalError(e);
            }
        }
    }
    static int CountLineInFile(String NameOfFile){
        int line = 0;
        FileFinder(NameOfFile);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(NameOfFile));
            while (reader.readLine() != null) line++;
            reader.close();
        }
        catch (Exception e){
            FatalError(e);
        }
        return line;
    }
    static String[] FileReader(String filename) {
        String[] linie = new String[CountLineInFile(filename)];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            for (int i = 0; i < linie.length; i++) {
                linie[i] = reader.readLine();
            }
        } catch (Exception e) {
            FatalError(e);
        }
        return linie;
    }
    static void FileSaver(String[] information,String filename){
        try {
            Path path = Paths.get(filename);
            String fulline=String.join(" ",information);
            List<String> linie = Files.readAllLines(path);
            linie.add(fulline);
            Files.write(path, linie);
        }
        catch (Exception e){
            Instruction.FatalError(e);
        }
    }
    //Errors
    static void FatalError(Exception e){
        String ErrorDescription=Paramets.FatalError+": "+e;
        System.out.println(ErrorDescription);
        Error error =new Error(ErrorDescription);
        Reset();
    }
}
