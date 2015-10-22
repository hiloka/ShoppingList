package cajohnson7.cs222.bsu.edu.shoppinglist;

/**
 * Created by Trey on 10/21/2015.
 */
public class  Recipe{
    String name;
    String cookTime;
    int serving;


    public void nameRecipe(String input){
        this.name=input;
    }

    public String RecipeName(){
        return this.name;
    }

    public void setCookTime(String input){
        this.cookTime=input;
    }
    public  String getCookTime(){
        return this.cookTime;
    }

    public void setServing(int input){
        this.serving=input;
    }
    public int getServing(){
        return this.serving;
    }
}
