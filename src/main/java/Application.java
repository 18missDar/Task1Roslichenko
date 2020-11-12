
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws IOException {
                System.out.println("Введите путь к json файлу автомата: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String dir = br.readLine();
                System.out.println("Введите последовательность, подаваемую на вход: ");
                String input = br.readLine();
                System.out.println("Введите сколько символов пропустить: ");
                int skip = Integer.parseInt(br.readLine());
                String json = new String(Files.readAllBytes(Paths.get(dir)));
                FSM finiteStateMachine = JsonConverter.fromJson(json);
                Map.Entry<Boolean, Integer> mx = finiteStateMachine.max(input, skip);
                System.out.println(String.format("Результат работы: состояние = %s, результат = %d", mx.getKey(), mx.getValue()));
                if(mx.getKey()) {
                    System.out.println("Вывод: " + input.substring(skip, skip + mx.getValue()));
                }
    }
}


// C:\RoslichenkoTask1\src\main\resources\test.json
// 12345