import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String... args) {
        //�������� ������������� ������ ������� Arrays.asList
        List<Person> personList = Arrays.asList(
                new Person("����", 7),
                new Person("������", 8),
                new Person("������", 8),
                new Person("�����", 10)
        );
        //�������� ������ ������ distinct() �� ������ ������� hashCode � equals ������
        personList.stream()
                .unordered()
                .distinct()
                .peek(s -> {
                    System.out.println(s.name + " " + s.age);
                })
                .allMatch(s -> true);

        // ����������� ���������
        Collector<Person, StringJoiner, String> myCollector = Collector.of(
                () -> new StringJoiner(" ** "),
                (stringJoiner, person) -> stringJoiner.add("���: " + person.name + " -> " + person.age ),
                StringJoiner::merge,
                StringJoiner::toString
        );

        String resultCollect = personList.stream().collect(myCollector);
        System.out.println(resultCollect);

        Supplier<Stream<Person>> streamSupplier = personList.stream();
               // .filter(person -> (person.age > 8)? true : false);


        //����� ���������� IntSummaryStatistics
        IntSummaryStatistics intSummaryStatistics = Stream.generate(Math::random)
                .limit(500L)
                .mapToInt(x -> (int) (x * 100))
                .summaryStatistics();

        System.out.println(intSummaryStatistics);

        //�������� ������������������� ����� ������� IntStream.range, ������ �����
        IntStream.rangeClosed(0, 10)
                .parallel()
                .map(x -> x * 2)
                .sequential()
                .peek(System.out::println)
                .allMatch(s -> true);

    }

}

class Person {
    public String name;
    public int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;

        return true;
        //return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        //int result = name != null ? name.hashCode() : 0;
        //result = 31 * result + age;
        //return result;
        return age;
    }
}
