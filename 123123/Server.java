import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static WeatherDatabase weatherDatabase;

    public static void main(String[] args) {
        // Создание и запуск сервера
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен.");

            // Соединение с базой данных
            weatherDatabase = new WeatherDatabase();

            while (true) {
                // Принятие клиентского подключения
                Socket clientSocket = serverSocket.accept();
                System.out.println("Получено подключение от клиента: " + clientSocket);

                // Создание потока для обработки запроса клиента
                ClientHandler clientHandler = new ClientHandler(clientSocket);

                // Запуск потока
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера: " + e.getMessage());
        }
    }

    public static WeatherDatabase getWeatherDatabase() {
        return weatherDatabase;
    }
}