import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {



        double a = 1.0E+10D;
        double b = a; // ����� ���������� ����������� �������� � b
        b = 20.1D;
        System.out.println(a);


        List<String> arrayList = new ArrayList<>();
        arrayList.add("����");

        List<String> arrayList2 = arrayList;// � ����� - ������� ������� ������ �� ��� �� ����� ������ arrayList

        arrayList2.add("������");

        arrayList.forEach(System.out::println);

        Integer int1 = 1010;
        Integer int2 = int1;
        int2 = 8080;
        System.out.println(int1);

    }
}
