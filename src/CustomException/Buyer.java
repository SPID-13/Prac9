package CustomException;

import java.util.Scanner;

public class Buyer {

    private String Name;
    private String INN;

    public Buyer (String Name, String INN) {
        this.Name = Name;
        this.INN = INN;
    }

    public Buyer () {
        this.Name = "";
        this.INN = "";
    }

    public void setINN() throws BuyerException{
        try (Scanner scINN = new Scanner(System.in) ) {
            if (scINN.hasNextLine())
                this.INN = scINN.nextLine();
        }  catch (Exception e) {
            if (!isCorrectINN(INN)) {
                throw new BuyerException("Bad client INN: " + INN, e);
            }
        }
    }

    public String getINN() {
            return INN;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public String toString () {
        return ("ФИО: " + Name + ", ИНН: " + INN + ".");
    }

    public boolean isCorrectINN (String INN) {
        return !INN.equals("");
    }

}

class BuyerException extends Exception {
    public BuyerException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
