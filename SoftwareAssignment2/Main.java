/*Hello Github!*/
package softwareassignment2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * Malcolm Moore 11/12/22
 */
public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Pet> petList = new ArrayList<>();

        /*Read txt file and create and add pets to petList*/
        try{
            File myFile = new File("Pets.txt");
            Scanner readFile = new Scanner(myFile);

            while (readFile.hasNextLine()){
                String data = readFile.nextLine();

                String[] splitData = data.split("\\|");
                Pet newPet = new Pet(petList.size(), splitData[0], Integer.valueOf(splitData[1]));
                petList.add(newPet);

            }

        } catch (FileNotFoundException e){

            System.out.println("File not found");
            e.printStackTrace();
        }

        /*Pets now being added from file*/
        /*Pet Kitty = new Pet(petList.size(), "Kitty", 8);
        petList.add(Kitty);
        Pet Bruno = new Pet(petList.size(), "Bruno", 7);
        petList.add(Bruno);
        Pet Boomer = new Pet(petList.size(), "Boomer", 8);
        petList.add(Boomer);*/

        boolean isRunning = true;

        while (isRunning){
            System.out.println("Pet Database Program");
            System.out.println("What would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add more Pets");
            System.out.println("3) Remove a Pet");
            System.out.println("4) Exit program");
            System.out.print("Your response: ");

            int response = input.nextInt();
            input.nextLine();

            /*Format and display data from petList*/
            if (response == 1){
                System.out.println(petList.size());
                System.out.println("+----------------------+");
                System.out.println("| ID |   Name   |  Age |");
                System.out.println("+----------------------+");
                for (Pet p: petList){
                    System.out.printf("| %s  | %-9s|  %s   |\n", p.getID(), p.getName(), p.getAge());
                }
                System.out.println("+----------------------+");
                System.out.printf("%s rows in set.\n", petList.size());
                System.out.println("");

            }

            /*Add pets until "done" is input*/
            else if (response == 2){
                boolean isAddingPet = true;

                while (isAddingPet){
                    System.out.print("add pet (name, age): ");
                    String addedPet = input.nextLine();

                    if (addedPet.equals("done")){
                        isAddingPet = false;
                    }

                    /*Display error if list is at limit of 5 or more*/
                    else if (petList.size() > 4){
                        System.out.println("Error: Database is full");
                    }

                    else{
                        String[] splitAddedPet = addedPet.split(" ");

                        /*Determine if given input is valid by array length*/
                        if (splitAddedPet.length != 2){
                            System.out.println(addedPet + " is not valid input");
                        }

                        /*Determine if age is an accepted value*/
                        else if (Integer.valueOf(splitAddedPet[1]) < 1 || Integer.valueOf(splitAddedPet[1]) > 20){
                            System.out.println(splitAddedPet[1] + " is not a valid age");
                        }

                        else{
                            Pet newPet = new Pet(petList.size(), splitAddedPet[0], Integer.valueOf(splitAddedPet[1]));
                            petList.add(newPet);
                            System.out.println("Pet added!");
                        }

                    }

                }
            }

            /*Remove pet by ID*/
            else if (response == 3){
                System.out.print("Enter the pet ID to be removed: ");
                int removePet = input.nextInt();

                /*determine if index given is within petList size*/
                if (removePet < 0 || removePet > petList.size()){
                    System.out.println("Error: ID " + String.valueOf(removePet) + " does not exist");
                }

                else{
                    System.out.println(petList.get(removePet).getName() + " removed");
                    petList.remove(removePet);

                    /*Update all IDs affected by removing Pet*/
                    for (Pet p: petList){
                        if (p.getID() > removePet){
                            p.updateID(p.getID() - 1);
                        }
                    }
                }









            }

            else if (response == 4){
                isRunning = false;
            }

            else{
                System.out.println("input error");
            }
        }
    }

}
