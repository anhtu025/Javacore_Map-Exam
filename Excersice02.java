import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Excersice02 {

    public Map<String, Integer> countSubstrings(String input, int length) {
        Map<String, Integer> substringCountMap = new HashMap<>();

        for (int i = 0; i <= input.length() - length; i++) {
            String substring = input.substring(i, i + length);
            substringCountMap.put(substring, substringCountMap.getOrDefault(substring, 0) + 1);
        }

        return substringCountMap;
    }

    public void displaySubstringCounts(Map<String, Integer> substringCountMap) {
        for (Map.Entry<String, Integer> entry : substringCountMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Excersice02 counter = new Excersice02();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Chuoi dau vao : ");
        String input = scanner.nextLine();

        System.out.print("Do dai chuoi con : ");
        int length = scanner.nextInt();

        Map<String, Integer> substringCountMap = counter.countSubstrings(input, length);

        counter.displaySubstringCounts(substringCountMap);

        scanner.close();
    }
}
