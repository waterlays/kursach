import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Создание соединения с сервером
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Успешное подключение к серверу.");

            // Получение потоков ввода-вывода
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Запрос даты у пользователя
            System.out.println("Введите дату (ГГГГ-ММ-ДД): ");
            Scanner scanner = new Scanner(System.in);
            String date = scanner.nextLine();

            // Отправка запроса на сервер
            outputStream.writeObject(date);

            // Получение ответа от сервера
            String jsonWeather = (String) inputStream.readObject();

            // Вывод погоды
            System.out.println("Погода на " + date + ": ");
            System.out.println(jsonWeather);

            // Закрытие соединения
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка клиента: " + e.getMessage());
        }
    }
}
