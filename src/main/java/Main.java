import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

           public static void main(String[] args) {
            List<Student> students = new ArrayList<>();
            students.add(new Student("Сергей", Arrays.asList(new Course("Литературы"), new Course("Геометрии"))));
            students.add(new Student("Борис", Arrays.asList(new Course("Алгебры"), new Course("Астрономии"),
                    new Course("Черчения"))));
            students.add(new Student("Екатерина", Arrays.asList(new Course("Физики"))));


            System.out.println(students.stream()
                    .map(s -> s.getCourses())
                    .flatMap(f -> f.stream())
                    .collect(Collectors.toSet()));


            System.out.println(students.stream()
                    .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                    .limit(2)
                    .collect(Collectors.toList()));


            Course course = new Course("Физики");
            System.out.println(students.stream()
                    .filter(s -> s.getCourses().contains(course))
                    .collect(Collectors.toList()));
        }
    }
