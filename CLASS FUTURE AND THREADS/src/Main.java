import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

        public static void main(String... args) throws ExecutionException, InterruptedException {

            Callable task = () -> {
                return "Hello, World!";
            };

            // ����������� Callable ��� Runnable ������� FutureTask
            FutureTask<String> myTask = new FutureTask<>(new Task());

            Thread thread = new Thread(myTask); // ������ ������ ������ � ������� � ���� ��� FutureTask
            thread.start(); // ������ ������ ������ ������� start()
            // �������� ��������� ������ ������ call � ������� ����������� ��� ������ FutureTask.get()

            System.out.println(myTask.get());//��� ��������� get() ���������� �������������

        }


    }

    class Task implements Callable {

        public String call() throws InterruptedException {
            System.out.println("������ ���������� ������...");
            Thread.sleep(5000);
            return "����� ���������� ������...";
        }
    }

