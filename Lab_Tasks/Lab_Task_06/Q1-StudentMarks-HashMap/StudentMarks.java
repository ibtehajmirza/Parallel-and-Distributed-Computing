import java.util.HashMap;
import java.util.Map;

public class StudentMarks {
    public static void main(String[] args) {
        HashMap<String, Integer> studentMarks = new HashMap<>();

        studentMarks.put("Ibtehaj", 85);
        studentMarks.put("Ali", 92);
        studentMarks.put("Asad", 78);
        studentMarks.put("Usama", 88);
        studentMarks.put("Haider", 65);

        System.out.println("--- All Student Records ---");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " | Marks: " + entry.getValue());
        }

        studentMarks.put("Ali", 90);
        System.out.println("\n--- Updated Marks ---");
        System.out.println("Ali's updated marks: " + studentMarks.get("Ali"));

        String studentName = "Ibtehaj";
        System.out.println("\n--- Specific Student Search ---");
        System.out.println("Marks of " + studentName + ": " + studentMarks.get(studentName));

        System.out.println("\n--- Total Records ---");
        System.out.println("Total number of students: " + studentMarks.size());
    }
}