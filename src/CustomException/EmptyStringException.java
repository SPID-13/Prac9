package CustomException;

public class EmptyStringException extends RuntimeException {
    public EmptyStringException () {
        super ("Поле ФИО не должно быть пустым.");
    }
}
