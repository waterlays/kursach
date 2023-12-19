import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Получение потоков ввода-вывода
            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            // Получение запроса от клиента
            String date = (String) inputStream.readObject();

            // Получение погоды из базы данных
            WeatherDatabase weatherDatabase = Server.getWeatherDatabase();
            String jsonWeather = weatherDatabase.getWeather(date);

            // Отправка ответа на клиент
            outputStream.writeObject(jsonWeather);

            // Закрытие потоков
            inputStream.close();
            outputStream.close();
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка обработки запроса клиента: " + e.getMessage());
        }
    }
}