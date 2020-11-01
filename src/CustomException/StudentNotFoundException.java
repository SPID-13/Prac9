package CustomException;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException () {
        super ("Студент с таким именем не найден.");
    }
}
