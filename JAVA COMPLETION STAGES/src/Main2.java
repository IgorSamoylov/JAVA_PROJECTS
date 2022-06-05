import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main2 {

    public static void main(String... args) throws InterruptedException {
        /* ������, ���������� ��������� � ��������� �������, ����� ������ �� ���� ����������
        �������� ������, ������� ���� ������� [](){} ��� � C++ ����� �� ����� */
        int n = 100;

        /* ������� ���������� ��������� ��� �������. ������������ ��� ���������
        � �� ������������� ��� ������ ������� Integer */
        AtomicInteger result = new AtomicInteger(0);

        Runnable runnableLambda = () -> {
            result.addAndGet(n); // ��������� �� n
            System.out.println(result + " " + Thread.currentThread().getName());
        };

        //����� Thread ��������� � ����������� ���������� ���������� Runnable
        Thread thread1 = new Thread(runnableLambda);
        // ����� Thread ������� ������� ����� start ��� ������� ����������� ��� Runnable!
        thread1.start();

        // ��������� ��� ���� �����
        new Thread(runnableLambda).start();

        // ������� ����� main ����� ������������� ����� �������
        Thread.sleep(1000);

        new Thread(runnableLambda).start();
        new Thread(runnableLambda).start();

        Thread.sleep(1000);

        // ����� Executors ������ ��������� ��� ���������� �������, ����������� �� ��������
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(runnableLambda);
        executorService.shutdown();

        System.out.println(result);


    }
}
