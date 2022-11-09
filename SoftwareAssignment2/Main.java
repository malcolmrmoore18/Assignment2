/*Hello Github!*/
package softwareassignment2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Malcolm Moore 11/3/22
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Pet> petList = new ArrayList<Pet>();
        Pet Kitty = new Pet(petList.size(), "Kitty", 8);
        petList.add(Kitty);
        Pet Bruno = new Pet(petList.size(), "Bruno", 7);
        petList.add(Bruno);
        Pet Boomer = new Pet(petList.size(), "Boomer", 8);
        petList.add(Boomer);

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

            else if (response == 2){
                boolean isAddingPet = true;

                while (isAddingPet){
                    System.out.print("add pet (name, age): ");
                    String addedPet = input.nextLine();

                    if (addedPet.equals("done")){
                        isAddingPet = false;
                    }
                    else{
                        String[] splitAddedPet = addedPet.split(" ");

                        Pet newPet = new Pet(petList.size(), splitAddedPet[0], Integer.valueOf(splitAddedPet[1]));
                        petList.add(newPet);
                        System.out.println("Pet added!");
                    }

                }
            }

            else if (response == 3){
                System.out.print("Enter the pet ID to be removed: ");
                int removePet = input.nextInt();
                petList.remove(removePet);


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
