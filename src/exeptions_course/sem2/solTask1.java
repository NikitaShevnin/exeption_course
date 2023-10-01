package exeptions_course.sem2;

/*
Задание 1: Реализуйте метод, который запрашивает у пользователя ввод дробного
числа (типа float), и возвращает введенное значение. Ввод текста вместо числа
не должно приводить к падению приложения, вместо этого, необходимо
повторно запросить у пользователя ввод данных.
 */

import java.util.Scanner;

public class solTask1 {

    public static void main(String[] args) {
        float number = readFloatFromUser();
        System.out.println("Возвращаемое число: " + number);
    }

    public static float readFloatFromUser(){
        Scanner scanner = new Scanner(System.in);
        float number;
        while (true){
            System.out.print("Введите дробное число: ");
            if (scanner.hasNextFloat()){
                number = scanner.nextFloat();
                break;
            } else {
                System.out.println("Некорректный ввод!");
                scanner.nextLine();
            }
        }
        return number;
    }
}
