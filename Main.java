import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        int x = 0;
        int y = 0;
        //this part stores content of the people.txt, food.txt and sport.txt files in their arraylists
        Scanner scanPeople = new Scanner(new File("people.txt"));
        Scanner scanFood = new Scanner(new File("food.txt"));
        Scanner scanSport = new Scanner(new File("sport.txt"));
        Scanner scanCommand = new Scanner(new File(args[0]));
        ArrayList<String> prePeopleList = new ArrayList<String>();
        ArrayList<String> preFoodList = new ArrayList<String>();
        ArrayList<String> preSportList = new ArrayList<String>();
        ArrayList<String> preCommandList = new ArrayList<String>();
        ArrayList<String> monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID = new ArrayList<String>();
        ArrayList<String> monitoringListFinal = new ArrayList<String>();
        while (scanPeople.hasNextLine()) {
            prePeopleList.add(scanPeople.nextLine());
        }
        scanPeople.close();
        while (scanFood.hasNextLine()) {
            preFoodList.add(scanFood.nextLine());
        }
        scanFood.close();
        while (scanSport.hasNextLine()) {
            preSportList.add(scanSport.nextLine());
        }
        scanSport.close();
        while (scanCommand.hasNextLine()) {
            preCommandList.add(scanCommand.nextLine());
        }
        scanCommand.close();
        String peopleString = Arrays.toString(prePeopleList.toArray()).replace("\n", ",").replace("\t", ",").replace("[", "").replace("]", "").replace(" ", "").replace(":", ",");
        String[] elementsPeople = peopleString.split(",");
        List<String> peopleList2 = Arrays.asList(elementsPeople);
        //to avoid newline blanks
        ArrayList<String> peopleList = new ArrayList<String>(peopleList2);
        String foodString = Arrays.toString(preFoodList.toArray()).replace("\n", ",").replace("\t", ",").replace("[", "").replace("]", "").replace(" ", "").replace(":", ",");
        String[] elementsFood = foodString.split(",");
        List<String> foodList2 = Arrays.asList(elementsFood);
        //to avoid newline blanks
        ArrayList<String> foodList = new ArrayList<String>(foodList2);
        String sportString = Arrays.toString(preSportList.toArray()).replace("\n", ",").replace("\t", ",").replace("[", "").replace("]", "").replace(" ", "").replace(":", ",");
        String[] elementsSport = sportString.split(",");
        List<String> sportList2 = Arrays.asList(elementsSport);
        //to avoid newline blanks
        ArrayList<String> sportList = new ArrayList<String>(sportList2);
        String commandString = Arrays.toString(preCommandList.toArray()).replace("\n", ",").replace("\t", ",").replace("[", "").replace("]", "").replace(" ", "").replace(":", ",");
        String[] elementsCommand = commandString.split(",");
        List<String> commandList2 = Arrays.asList(elementsCommand);
        //to avoid newline blanks
        ArrayList<String> commandList = new ArrayList<String>(commandList2);
        //add name and age values and writes "0" to calorie values to the arraylist monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result
        for (int i = 0; i < peopleList.size(); i=i+6){
            monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.add(peopleList.get(i));
            monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.add(peopleList.get(i+1));
            monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.add(Integer.toString(2022-Integer.parseInt(peopleList.get(i+5))));
            for (int iinner = 0; iinner < 4; iinner++){
                monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.add("0kcal");
            }
        }
        //calculates and stores daily calorie needs of every person
        for (int i3 = 0; i3 < peopleList.size(); i3=i3+6){
            if (peopleList.get(i3+2).equals("male")){
                //get values from people list, converts them to int, make calculations with double type, round it, converts to int(from 12.0 to 12 etc.), converts to string
                monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.set(i3+i3/6+3, Integer.toString((int)(Math.round(66 + (13.75 * Integer.parseInt(peopleList.get(i3+3))) + (5 * Integer.parseInt(peopleList.get(i3+4))) - (6.8 * (2022 - Integer.parseInt(peopleList.get(i3+5))))))) + "kcal");//calorie needs
            }
            else if (peopleList.get(i3+2).equals("female")){
                //get values from people list, converts them to int, make calculations with double type, round it, converts to int(from 12.0 to 12 etc.), converts to string
                monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.set(i3+i3/6+3, Integer.toString((int)(Math.round(665 + (9.6 * Integer.parseInt(peopleList.get(i3+3))) + (1.7 * Integer.parseInt(peopleList.get(i3+4))) - (4.7 * (2022 - Integer.parseInt(peopleList.get(i3+5))))))) + "kcal");//calorie needs
            }
        }
        //this part decides which operation will be done for each line of the command file
        for (int i4 = 0; i4 < commandList.size(); i4=i4+1){
            if (commandList.get(i4).equals("printList")){
                for (int i44 = 0; i44 < monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.size(); i44=i44+7){
                    if (!monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i44+4).equals("0kcal") || !monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i44+5).equals("0kcal")){
                        monitoringListFinal.add(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i44+1) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i44+2) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i44+3) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i44+4) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i44+5)+ "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i44+6) + "\n");
                    }
                }
                monitoringListFinal.add("***************" + "\n");
                y+=1;
            }
            else if (commandList.get(i4).equals("printWarn")){
                for (int i5 = 0; i5 < monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.size(); i5=i5+7){
                    String printString = monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i5+6).replaceAll("kcal", "");
                    if (Integer.parseInt(printString)>0){
                        monitoringListFinal.add(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i5+1) + "\t" +monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i5+2) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i5+3) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i5+4) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i5+5) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i5+6) + "\n");
                        monitoringListFinal.add("***************" + "\n");
                        break;
                    }
                    else{
                        monitoringListFinal.add("there\tis\tno\tsuch\tperson" + "\n");
                        monitoringListFinal.add("***************" + "\n");
                        break;
                    }
                }
                y+=1;
            }
            else if ( commandList.get(i4).contains("print(")) {
                String printString2 = commandList.get(i4).replaceAll("print", "");
                String printString3 = printString2.replaceAll("\\(","");
                String printString4 = printString3.replaceAll("\\)","");
                for (int i6 = 0; i6 < monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.size(); i6=i6+7){
                    if ( monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i6).contains(peopleList.get(peopleList.indexOf(printString4)))) {
                        //monitoring list yerine [name] tab [age] tab [daily calorie needs] tab [calories taken] tab
                        // [calories burned] tab [result] newline iÃ§eren bir liste oluÅŸturup oradaki elemanlarÄ± yazdÄ±rmak lazÄ±m
                        //monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result LÄ°STESÄ°NE YANÄ°
                        monitoringListFinal.add(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i6+1) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i6+2) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i6+3) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i6+4) + "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i6+5)+ "\t" + monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(i6+6) + "\n");
                        monitoringListFinal.add("***************" + "\n");
                    }
                }
                y+=1;
            }
            //if there are food consumption or sport activity
            else{
                if (Double.parseDouble(commandList.get(i4+1)) > 999 &&  Double.parseDouble(commandList.get(i4+1)) < 1400){
                    monitoringListFinal.add(commandList.get(i4) + "\t" + "has" + "\t" +"taken" + "\t" + Integer.parseInt(commandList.get(i4+2)) * Integer.parseInt(foodList.get(foodList.indexOf(commandList.get(i4+1))+2)) + "kcal" + "\t" + "from" + "\t" + foodList.get(foodList.indexOf(commandList.get(i4+1))+1) + "\n");
                    monitoringListFinal.add("***************" + "\n");
                    String printString5 = monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+4).replaceAll("kcal", "");
                    monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.set(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+4, Integer.parseInt(printString5) + Integer.parseInt(commandList.get(i4+2)) * Integer.parseInt(foodList.get(foodList.indexOf(commandList.get(i4+1))+2)) + "kcal");
                    String printString6 = monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+3).replaceAll("kcal", "");
                    String printString7 = monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+4).replaceAll("kcal", "");
                    String printString8 = monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+5).replaceAll("kcal", "");
                    if ((Integer.parseInt(printString7) - Integer.parseInt(printString8)) - Integer.parseInt(printString6)>0){
                        monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.set(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+6, "+" + ((Integer.parseInt(printString7) - Integer.parseInt(printString8)) - Integer.parseInt(printString6)) + "kcal");
                    }
                    else{
                        monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.set(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+6, (Integer.parseInt(printString7) - Integer.parseInt(printString8)) - Integer.parseInt(printString6) + "kcal");
                    }
                    i4+=2;
                    x+=1;
                }
                //I used i4+4+x*3-y for indexing because i4 is incremented by 3 but I want to increment index by 6. The only correlation between these situations is it.
                else if (Double.parseDouble(commandList.get(i4+1)) > 1999){
                    monitoringListFinal.add(commandList.get(i4) + "\t" + "has" + "\t" + "burned" + "\t" + Integer.parseInt(commandList.get(i4+2))/60 * Integer.parseInt(sportList.get(sportList.indexOf(commandList.get(i4+1))+2)) + "kcal" + "\t" + "thanks" + "\t" + "to"+ "\t" + sportList.get(sportList.indexOf(commandList.get(i4+1))+1) + "\n");
                    monitoringListFinal.add("***************" + "\n");
                    String printString9 = monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+5).replaceAll("kcal", "");
                    monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.set(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+5, Integer.parseInt(printString9) + Integer.parseInt(commandList.get(i4+2))/60 * Integer.parseInt(sportList.get(sportList.indexOf(commandList.get(i4+1))+2)) + "kcal");
                    String printString10 = monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+3).replaceAll("kcal", "");
                    String printString11 = monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+4).replaceAll("kcal", "");
                    String printString12 = monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.get(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+5).replaceAll("kcal", "");
                    monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.set(monitoringListforName__Age__Daily_Calorie_need__Calories_taken__Calories_burned__Result__with__ID.indexOf(commandList.get(i4))+6, (Integer.parseInt(printString11) - Integer.parseInt(printString12)) - Integer.parseInt(printString10) + "kcal");
                    i4+=2;
                    x+=1;
                }
            }
        }
        for (int i7 = 0; i7 < monitoringListFinal.size(); i7+=1){
            if(i7==monitoringListFinal.size()-1){
                String printString15 = monitoringListFinal.get(i7);
                String printString16 = printString15.substring(0, printString15.length() - 1);
                monitoringListFinal.set(i7,printString16);
                monitoringListFinal.remove(i7);
            }
            else if (i7==monitoringListFinal.size()-2) {
                String printString13 = monitoringListFinal.get(i7);
                String printString14 = printString13.substring(0, printString13.length() - 1);
                monitoringListFinal.set(i7, printString14);
            }
        }
        ArrayList<String> outputList = new ArrayList<String>();
        String ascendingWithoutBrackets = Arrays.toString(monitoringListFinal.toArray()).replace("[", "").replace("]", "").replace(", ", "");
        if (!ascendingWithoutBrackets.equals("") || !ascendingWithoutBrackets.equals("]")) {
            outputList.add(ascendingWithoutBrackets);
        }
        FileWriter writer = new FileWriter("monitoring.txt");
        for(String str: outputList) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}