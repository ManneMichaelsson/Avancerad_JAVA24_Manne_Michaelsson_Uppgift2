//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentManagementSystem {
    private static StudentManagementSystem instance;
    private Map<String, Student> studentsMap = new HashMap();

    private StudentManagementSystem() {
    }

    public static StudentManagementSystem getInstance() {
        if (instance == null) {
            instance = new StudentManagementSystem();
        }

        return instance;
    }

    void addStudent(String id, String name, double grade) {
        Student student = new Student(id, name, grade);
        this.studentsMap.put(student.getId(), student);
        System.out.println("Studenten " + student.getName() + " har lagts till!");
    }

    void saveStudentsToFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("Filen " + filename + " finns redan. Raderar och skapar en ny");
            file.delete();

            try {
                FileWriter writer = new FileWriter(filename);
                BufferedWriter buffer = new BufferedWriter(writer);

                for(Student student : this.studentsMap.values()) {
                    buffer.write(student.toFileFormat());
                    buffer.newLine();
                }

                buffer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                FileWriter writer = new FileWriter(filename);
                BufferedWriter buffer = new BufferedWriter(writer);

                for(Student student : this.studentsMap.values()) {
                    buffer.write(student.toFileFormat());
                    buffer.newLine();
                }

                buffer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    void loadFromFile(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);

            String line;
            int i;
            for(BufferedReader reader = new BufferedReader(fileReader); (line = reader.readLine()) != null; ++i) {
                i = 0;
                String[] data = line.split(",");
                if (data.length == 3) {
                    String id = data[0];
                    String name = data[1];
                    double grade = Double.parseDouble(data[2]);
                    this.addStudent(id, name, grade);
                    System.out.println("Student " + i + ": " + ((Student)this.studentsMap.get(id)).toStringFormat());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void findStudent(String id) {
        try {
            Student student = (Student)this.studentsMap.get(id);
            System.out.println("Student hittades.");
            System.out.println(student.toStringFormat());
        } catch (NullPointerException var3) {
            System.out.println("Student hittades inte");
        }

    }

    void allStudents() {
        for(Map.Entry<String, Student> entry : this.studentsMap.entrySet()) {
            System.out.println(((Student)entry.getValue()).toStringFormat());
        }

    }

    boolean exitProgram() {
        System.out.println("Tack för att du använde tjänsten!");
        return false;
    }
}
