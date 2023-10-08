package exeptions_course.sem3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sol2_UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Осуществите ввод данных в следующем формате: Фамиля Имя Отчество ДатаРождения НомерТелефона Пол");
            String input = scanner.nextLine();

            String[] inputData = input.split(" ");

            if (inputData.length !=6){
                throw new InvalidDataFormatException ("Вы ввели не корректные данные, они не соответствуют формату ввода");
            }

            String surname = inputData[0];
            String name = inputData[1];
            String patronymic = inputData[2];
            String birthDate = inputData[3];
            String phoneNumber = inputData[4];
            String gender = inputData[5];

            validateData (surname, name, patronymic, birthDate, phoneNumber, gender);

            String fileName = surname + ".txt";
            String content = input.replace(" ", ", ");

            writeToFile (fileName, content);

            System.out.println("данные успешно записаны в файл" + fileName);

        } catch (InvalidDataFormatException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println("Ошибка при записи в файл");
        }
    }

    private static void validateData (String surname, String name, String patronymic, String birthDate, String phoneNumber, String gender)

            throws InvalidDataFormatException {

        if (!surname.matches("[A-Za-zA-Яа-яЁё]+")) {
            throw new InvalidDataFormatException("Неверный формат фамилии ");
        }

        if (!name.matches("[A-Za-zA-Яа-яЁё]+")) {
            throw new InvalidDataFormatException("Неверный формат имени ");
        }

        if (!patronymic.matches("[A-Za-zA-Яа-яЁё]+")) {
            throw new InvalidDataFormatException("Неверный формат отчества");
        }

        if (!birthDate.matches("\\d{2}.\\d{2}.\\d{4}")) {
            throw new InvalidDataFormatException("Неверный формат даты рождения");
        }

        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidDataFormatException("Неверный формат номера телефона");
        }

        if (!gender.matches("[МмЖж]")) {
            throw new InvalidDataFormatException("Не верный формат пола");
        }
    }
    private static void writeToFile (String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }
}
