import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Excersice01 {

    // lưu trữ sinh viên dựa theo loại điểm
    private Map<String, List<String>> gradeMap;

    public Excersice01() {
        gradeMap = new HashMap<>();
        // khởi tạo danh sách trống
        gradeMap.put("A", new ArrayList<>());
        gradeMap.put("B", new ArrayList<>());
        gradeMap.put("C", new ArrayList<>());
        gradeMap.put("D", new ArrayList<>());
        gradeMap.put("F", new ArrayList<>());
    }

    // thêm sinh viên và phân loại theo điểm
    public void addStudent(String name, int score) {
        String grade = calculateGrade(score);
        gradeMap.get(grade).add(name);
    }

    // phân loại dựa theo điểm số
    private String calculateGrade(int score) {
        if (score >= 86 && score <= 100) {
            return "A";
        } else if (score >= 76 && score <= 85) {
            return "B";
        } else if (score >= 66 && score <= 75) {
            return "C";
        } else if (score >= 51 && score <= 65) {
            return "D";
        } else {
            return "F";
        }
    }

    // danh sách sinh viên dựa theo điểm
    public List<String> getStudentsByGrade(String grade) {
        return gradeMap.getOrDefault(grade, new ArrayList<>());
    }

    // danh sách sinh viên theo loại điểm
    public void displayAllGrades() {
        for (Map.Entry<String, List<String>> entry : gradeMap.entrySet()) {
            String grade = entry.getKey();
            List<String> students = entry.getValue();
            System.out.println("Grade " + grade + ": " + students);
        }
    }

    // em thử nghiệm với sc
    public static void main(String[] args) {
        Excersice01 system = new Excersice01();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter student name (or type 'exit' to finish):");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter student score:");
            int score = Integer.parseInt(scanner.nextLine());

            system.addStudent(name, score);
        }

        system.displayAllGrades();

        // sinh viên điểm A
        System.out.println("Students with Grade A: " + system.getStudentsByGrade("A"));

        scanner.close();
    }
}
