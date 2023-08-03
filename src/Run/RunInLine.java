package Run;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

//java -jar %DERBY_HOME%\lib\derbyrun.jar server start
public class RunInLine {
    RunInLine(){

    }

    void Start() throws IOException {
        boolean end = false;
        Scanner scan = new Scanner(System.in);
        ArrayList <String[]> numbers = new ArrayList<>();
        while (!end){
            welcomeStart();
            String option = scan.nextLine();
            if (validateOption(option)){
                if(option.equals("1")){
                    String[] strings = questionEvaluation();
                    numbers.add(strings);
                }
                if (option.equals("2")){
                    Path path = Paths.get("src\\responseHistory.txt");
                    writeToFile(numbers,path);
                }
                if(option.equals("3")){
                    end = true;
                }
            }
        }
    }

    void welcomeStart(){
        System.out.println("Welcome to the Mental Health Application.");
        System.out.println("1. Enter how you are feeling.");
        System.out.println("2. Save to File.");
        System.out.println("3. Exit");
    }

    boolean validateOption(String option){
        return option.equals("1") || option.equals("2") || option.equals("3");
    }

    String[] questionEvaluation(){
        String[] therapyEvaluationArray = new String[8];
        try(BufferedReader br = Files.newBufferedReader(Paths.get("src\\response.txt"))){
            String content;
            int ctr = 0;
            Scanner scan = new Scanner(System.in);
            while((content = br.readLine()) != null){
                System.out.println(content);
                therapyEvaluationArray[ctr] = scan.nextLine();
                ctr++;

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return therapyEvaluationArray;
    }
    void writeToFile(ArrayList <String[]> numbersArrayList, Path path) throws IOException {
        for(String[] numbers: numbersArrayList){
            String content = "";
            for(String s : numbers){
                content = s + ",";
                if(Files.exists(path))
                    Files.writeString(path, content, StandardOpenOption.APPEND);
                else
                    Files.writeString(path, content, StandardOpenOption.CREATE);
            }
            if(Files.exists(path))
                Files.writeString(path,"\n",StandardOpenOption.APPEND);
        }
    }

    
}
