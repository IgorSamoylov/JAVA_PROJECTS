import javax.swing.*;

class SomeClass2 {

    String replyTo;

    interface Callback{
        void callingBack(String s);
    }

    private Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    void doSomething(){
        int reply = JOptionPane.showConfirmDialog(null, "�� �����������?", "�����", JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.NO_OPTION){
            replyTo = "���";
        }
        if (reply == JOptionPane.YES_OPTION){
            replyTo = "��";
        }

        callback.callingBack(replyTo);
    }
}

class MyClass2 implements SomeClass2.Callback {
    @Override
    public void callingBack(String s) {

        if (s != null) {
            System.out.println("��� �����: " + s);
        } else {
            System.out.println("�� �� �������� �� ������!");
        }
    }
}

public class Main2 {

    public static void main(String[] args) {

        SomeClass2 someClass2 = new SomeClass2();
        MyClass2 myClass2 = new MyClass2();

        someClass2.registerCallBack(myClass2);
        someClass2.doSomething();
    }
}

