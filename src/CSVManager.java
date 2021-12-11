import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CSVManager {

    private static ArrayList<String> headers = new ArrayList<>();
    private static ArrayList<String[]> data = new ArrayList<>();
    private static Scanner scanner;
    private static CSVManager instance = null;

    private CSVManager(String path){
        try{
            scanner = new Scanner(new File(path));
            scanner.useDelimiter(",");
            readHeaders();
            readTable();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static CSVManager getInstance() {
        if(instance == null){
            instance = new CSVManager("res/purchases.csv");
        }
        return instance;
    }

    public static String[][] getData(){
        return data.toArray(new String[0][0]);
    }

    public static String[] getHeaders(){
        return headers.toArray(new String[0]);
    }

    private static void readHeaders(){
        Collections.addAll(headers, scanner.nextLine().split(","));
    }

    private static void readTable(){
        while(scanner.hasNext()){
            data.add(scanner.nextLine().split(","));
        }
    }

}
