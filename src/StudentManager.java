import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentManager {

    private final Scanner sc;

    public StudentManager(Scanner sc) {
        this.sc = sc;
    }

    public Student registerStudent() {
        String name;
        String surname;
        LocalDate dateOfBirth;
        String phoneNumber;
        String city;
        String street;
        int buildingNumber;
        int apartmentNumber;


        while (true) {
            System.out.print("Name: ");
            name = sc.nextLine().trim();

            if(Validator.validateLine(name)) {
                name = Validator.formatString(name);
                break;
            }

            System.out.println("Invalid name!");
        }

        while (true) {
            System.out.print("Surname: ");
            surname = sc.nextLine().trim();

            if(Validator.validateLine(surname)) {
                surname = Validator.formatString(surname);
                break;
            }

            System.out.println("Invalid surname!");
        }

        while (true) {
            System.out.print("DateOfBirth (dd/MM/yyyy): ");

            String inputDateOfBirth = sc.nextLine();

            if(Validator.validateDateOfBirth(inputDateOfBirth)) {
                dateOfBirth = Validator.formatDateOfBirth(inputDateOfBirth);
                break;
            }

            System.out.println("Invalid date!");
        }

        int age = Validator.getAge(dateOfBirth);

        while (true) {
            System.out.print("Phone number (+380XXXXXXXXX): ");

            phoneNumber = sc.nextLine();

            if(Validator.validatePhone(phoneNumber)) {
                break;
            }

            System.out.println("Invalid phone number!");
        }

        while (true) {
            System.out.print("City: ");

            city = sc.nextLine();

            if(Validator.validateLine(city)) {
                city = Validator.formatString(city);
                break;
            }

            System.out.println("Invalid format city!");
        }

        while (true) {
            System.out.print("Street name: ");

            street = sc.nextLine();

            if(Validator.validateLine(street)) {
                street = Validator.formatString(street);
                break;
            }

            System.out.println("Invalid format street!");
        }

        while (true) {
            System.out.print("Building number: ");

            try {
                buildingNumber = Integer.parseInt(sc.nextLine());

                if (buildingNumber > 0) {
                    break;
                }

                System.out.println("Number must be greater than 0!");

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
            }
        }

        while (true) {
            System.out.print("Apartment number: ");

            try {
                apartmentNumber = Integer.parseInt(sc.nextLine());

                if (apartmentNumber > 0) {
                    break;
                }

                System.out.println("Number must be greater than 0!");

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
            }
        }

        Address address = new Address(
                city,
                street,
                buildingNumber,
                apartmentNumber
        );


        return new Student(
                name,
                surname,
                age,
                dateOfBirth,
                phoneNumber,
                address
        );
    }

    public static void showAllStudents(List<Student> journal) {
        if  (journal.isEmpty()) {
            System.out.println("Empty journal");
            return;
        }
        for(int i = 0; i < journal.size(); i++) {

            System.out.println("Student " + i + "________________");

            Student student = journal.get(i);

            System.out.println("Name: " + student.getName());
            System.out.println("Surname: " + student.getSurname());
            System.out.println("Age: " + student.getAge());
            System.out.println("Date of birth: " + student.getDateOfBirth());
            System.out.println("Phone: " + student.getPhoneNumber());
            System.out.println("Address: " + student.getAddress());
        }

    }
}
