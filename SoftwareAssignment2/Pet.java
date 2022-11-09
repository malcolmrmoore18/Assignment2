package softwareassignment2;

/**
 *
 * Malcolm Moore
 */
public class Pet {
    private int ID;
    private String name;
    private int age;

    public Pet(int ID, String name, int age){
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void updateID(int ID){
        this.ID = ID;
    }
}
