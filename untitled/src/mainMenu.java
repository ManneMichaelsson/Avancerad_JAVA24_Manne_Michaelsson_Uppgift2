//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class mainMenu {
    private StudentManagementSystem studentManagementSystem;
    private Scanner scanner;
    private Boolean online;
    private String filename;

    public mainMenu() {
        this.scanner = new Scanner(System.in);
        this.online = true;
        this.filename = "students.txt";
        this.studentManagementSystem = StudentManagementSystem.getInstance();
    }

    void displayMenu() {
        while(this.online) {
            System.out.println("______________________________________________");
            System.out.println("1. Lägg till nya studentposter via menyn");
            System.out.println("2. Sök efter student via ID");
            System.out.println("3. Visa alla sparade studenter i nuvarande minne");
            System.out.println("4. Spara studentposter till fil");
            System.out.println("5. Läs studentposter från fil och lägg in i minnet");
            System.out.println("6. avsluta programmet");
            System.out.println("______________________________________________");
            System.out.print("Väl alternativ: ");
            int choice = this.scanner.nextInt();
            this.userChoise(choice);
        }

    }

    void userChoise(int choise) {
        if (choise == 1) {
            System.out.println("Lägg till student");
            System.out.println("Välj id: ");

            String id;
            for(id = this.scanner.next(); id.isEmpty(); id = this.scanner.next()) {
                System.out.println("Inget ID valt, vänligen försök igen: ");
            }

            System.out.println("Studentens namn: ");

            String name;
            for(name = this.scanner.next(); name.isEmpty(); name = this.scanner.next()) {
                System.out.println("Inget namn valt, vänligen försök igen: ");
            }

            System.out.println("Studentens betyg [Skriv X.X]: ");

            String gradeString;
            for(gradeString = this.scanner.next(); gradeString.isEmpty(); gradeString = this.scanner.next()) {
                System.out.println("Inget betyg valt, vänligen försök igen: ");
            }

            try {
                double gradeDouble = Double.parseDouble(gradeString);
                this.studentManagementSystem.addStudent(id, name, gradeDouble);
            } catch (NumberFormatException var8) {
                System.out.println("Felaktigt betyg, får endast vara siffror. Kommatecken skrivs med [.] mellan siffrorna.");
            }

            this.continueProgram();
        } else if (choise == 2) {
            System.out.println("Skriv studentens id: ");
            String studentId = this.scanner.next();
            this.studentManagementSystem.findStudent(studentId);
            this.continueProgram();
        } else if (choise == 3) {
            this.studentManagementSystem.allStudents();
            this.continueProgram();
        } else if (choise == 4) {
            this.studentManagementSystem.saveStudentsToFile(this.filename);
            this.continueProgram();
        } else if (choise == 5) {
            this.studentManagementSystem.loadFromFile(this.filename);
            this.continueProgram();
        } else if (choise == 6) {
            this.online = this.studentManagementSystem.exitProgram();
            this.continueProgram();
        }

    }

    void continueProgram() {
        System.out.println("Tryck valfri bokastav och sedan enter för att fortsätta");
        this.scanner.next();
    }

    public StudentManagementSystem getStudentManagementSystem() {
        return this.studentManagementSystem;
    }

    public void setStudentManagementSystem(StudentManagementSystem studentManagementSystem) {
        this.studentManagementSystem = studentManagementSystem;
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Boolean getOnline() {
        return this.online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public static void main(String[] args) {
        mainMenu mainMenu = new mainMenu();
        mainMenu.displayMenu();
    }
}
