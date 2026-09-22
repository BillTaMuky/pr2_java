import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Journal {
    private static final List<Student> journal = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager(sc);


    public static void runJournal() {

        boolean isActive = true;

        while (isActive) {
            System.out.println("Welcome in journal, 1 - to add student, 2 - to check all list of students, 0 - to exit!");
            switch (sc.nextLine().charAt(0)) {
                case ('1'):
                    System.out.println("Register new student!");
                    journal.add(manager.registerStudent());
                    break;
                case ('2'):
                    System.out.println("List of students!");
                    manager.showAllStudents(journal);
                    break;
                case ('0'):
                    isActive = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

    }
}


