package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static Scanner choiceScan = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    public static void logger(){
        try{
            BufferedWriter logger = new BufferedWriter(new FileWriter("src/main/resources/log.txt", true));
            LocalDateTime.now();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            logger.write(LocalDateTime.now().format(df) + " launch\n");
            int temp = 0;
            while(temp < 1){
                System.out.print("User Input (X to exit): ");
                String loggerInput = choiceScan.nextLine();
                if(loggerInput.equalsIgnoreCase("x")){
                    logger.write(LocalDateTime.now().format(df) + " exit");
                    temp++;
                }
                else{
                    logger.write(LocalDateTime.now().format(df) + " search " + loggerInput);
                    logger.newLine();
                }
            }
            logger.newLine();
            logger.close();
            menu();
        }
        catch(Exception e){
            System.out.println("Unknown error occured. ");
            e.printStackTrace();
        }
    }
    public static void menu(){
        System.out.print("Welcome! Please choose an option (1 or 2).\n\t1)Search A Term\n\t2)Exit Program\nUser Input: ");
        String choice = choiceScan.nextLine();
        switch(choice){
            case("1"):
                logger();
                break;
            case("2"):
                System.out.println("See you again soon!");
                break;
            default:
                System.out.println("Please enter a valid option (1 or 2).\n");
                menu();
        }
    }
}