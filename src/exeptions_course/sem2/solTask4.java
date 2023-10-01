package exeptions_course.sem2;

/*
Задание 4: Разработайте программу, которая выбросит Exception, когда пользователь
вводит пустую строку. Пользователю должно показаться сообщение, что пустые
строки вводить нельзя.
 */

import java.util.Scanner;

public class solTask4 {

    public static void main(String[] args) {
        System.out.print("Ожидаются данные на ввод: ");
        Scanner scanner = new Scanner(System.in);
        try {
            String input = getInput (scanner);
            System.out.println("Вы ввели: " + input);
        } catch (EmptyInputException  e) {
            System.out.println("Пустые строки вводить нельзя");
        }
    }

    public static String getInput (Scanner scanner) throws EmptyInputException {
        String input = scanner.nextLine();
        if (input.isEmpty()){
            throw new EmptyInputException();
        }
        return input;
    }
}

class EmptyInputException extends Exception{
    // Пользовательское исключение
}
