import java.io.*;

// Student class implementing Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int studentID;
    private String name;
    private char grade;

    // Constructor
    public Student(int studentID, String name, char grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Grade: " + grade;
    }
}

public class SerializeDeserializeDemo {
    public static void main(String[] args) {
        String filename = "student.ser";
        Student student = new Student(101, "Tanik Sehrawat", 'A');

        // ---------- Serialization ----------
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(student);
            System.out.println("Student object serialized and saved to " + filename);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ---------- Deserialization ----------
        Student deserializedStudent = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            deserializedStudent = (Student) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Print the deserialized object
        System.out.println("Deserialized Student:");
        System.out.println(deserializedStudent);
    }
}
