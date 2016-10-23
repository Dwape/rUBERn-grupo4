/**
 * Created by Dwape on 10/23/16.
 */
public abstract class Formulary {

    String title;

    public void show(){
        clearScreen();
        displayTitle();
        drawLine();
        this.displayContent();
    }

    public void clearScreen(){  //fijarse como se hace para limpiar la consola
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public void displayTitle(){
        System.out.println(this.getTitle());
    }

    public void drawLine(){
        System.out.println("");
    }

    public String getTitle(){
        return this.title;
    }

    public abstract void displayContent();
}
