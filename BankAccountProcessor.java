package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BankAccountProcessor
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // a variable that continues the program
        boolean runProgram = true;



        // a while loop that runs only if runProgram = true
        System.out.println("What file would you like to parse?");


        while (runProgram)
        {
            try
            {
                Scanner input = new Scanner(System.in);
                String fileName;
                fileName = input.nextLine();
                File file = new File(fileName);
                Scanner inputFile = new Scanner(file);
                while (inputFile.hasNext())
                {

                    Scanner scanner = new Scanner(file);
                    System.out.println(scanner.nextLine());
                    String accountLine = scanner.nextLine();
                    System.out.println("Line " + accountLine + " has been processed.");
                    if (isValid(scanner.nextLine()))
                    {
                        System.out.println("Line " + accountLine + " has been processed.");
                    }

                }

                runProgram = false;
            }
            catch (FileNotFoundException e) {
                System.out.println("That file does not exist");
                break;
            }
            catch (BankAccountException e) {
                System.out.println("Something is not happening...");
            }
        }
    }

    public static boolean isValid(String accountLine) throws BankAccountException
    {
        StringTokenizer stringToken = new StringTokenizer(accountLine, ";");
        String tokenOne = stringToken.nextToken();
        String tokenTwo = stringToken.nextToken();
        if (stringToken.countTokens() != 2)
        {
            throw new BankAccountException("Invalid Bank Account Info");
        }
        else if (tokenOne.length() != 10)
        {
            throw new BankAccountException("Invalid Bank Account Info: Account Number is not 10 digits.");
        }
        else if (tokenTwo.length() < 3)
        {
            throw new BankAccountException("Invalid Bank Account Info: Name must be more than 3 letters.");
        }
        else if (BankAccountProcessor.hasLetter(tokenOne) == true)
        {
            throw new BankAccountException("Invalid Bank Account Info: Account Number must be all digits.");
        }
        else if (BankAccountProcessor.hasDigit(tokenTwo) == true)
        {
            throw new BankAccountException("Invalid Bank Account Info: Account Name cannot have digits.");
        }
        return true;
    }

    private static boolean hasDigit(String str){
        for (char c : str.toCharArray()){
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    private static boolean hasLetter(String str){
        for (char c : str.toCharArray()){
            if (Character.isLetter(c)){
                return true;
            }
        }
        return false;
    }

}
