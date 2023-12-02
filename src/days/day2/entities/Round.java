package days.day2.entities;

public class Round {


    private int red;

    private  int blue;

    private int green;

    public Round(){
        red = 0;
        blue = 0;
        green = 0;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    @Override
    public String toString() {
        return "red: "+ red +", blue: " + blue + " green: " + green;
    }

}
