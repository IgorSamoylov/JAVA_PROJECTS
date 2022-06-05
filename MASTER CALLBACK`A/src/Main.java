import javax.swing.*;

class SomeClass {

    // ������� ������ � ��� �����
    interface Callback{
        void callingBack();
    }

    Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    void doSomething(){
        JOptionPane.showMessageDialog(null, "����������� ������");

        // �������� ����� ��������� ������
        callback.callingBack();
    }
}

class MyClass implements SomeClass.Callback {

    @Override
    public void callingBack() {

        System.out.println("����� ������ ��������� ������");

    }
}

public class Main {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        MyClass myClass = new MyClass();

//�������������� ������, ��������� ������ registerCallBack ��������� MyClass, ����������� ��������� ������
        someClass.registerCallBack(myClass);
        someClass.doSomething();

    }
}