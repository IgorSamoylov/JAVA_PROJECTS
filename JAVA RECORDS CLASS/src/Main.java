public class Main {

    public static void main(String... args) {
        PlainClass plainClass = new PlainClass(888, "������");
        System.out.println(plainClass);

        FirstRecord firstRecord = new FirstRecord(1, "����������");
        System.out.println(firstRecord.number() + " " + firstRecord.name());

        SecondRecord secondRecord = new SecondRecord(0, "����");
        System.out.println(secondRecord.number() + " " + secondRecord.name());

        ThirdRecord thirdRecord = new ThirdRecord(5, "���");
        System.out.println(thirdRecord.number() + " " + thirdRecord.name() + " " + thirdRecord.Test());

    }
}

//������� ������
record FirstRecord(int number, String name) {}

// ������ � ��������������� ������������ ������������� � ���������� �����
record SecondRecord(int number, String name) {
    SecondRecord{
    if(number == 0) number = 777;
    }
}
// ������ � ��������� ��������������� �������������
record ThirdRecord(int number, String name) {
    ThirdRecord(int number, String name) {
        if (name == "���") name = "������� ���";
        this.number = number;
        this.name = name;
    }
    static {System.out.println("����� ���������������!");}
    public int Test() {return 9090;}
}

/*����������� records
������� ���������, ��� �� �� ����� ����������� ������ record �� ������ �������.
����� ������ ����������� ������ �� records.
������ ������ record ����� ����������� ����������.
����� ����, ������ record �� ����� ���� ������������.
� record ������ ����� ������� ���������� ������������� ���� � ��������������.
����� ���������� ����������� ���������� � ��������������.
����� ���������� ����������� � ������������� ������
 */

