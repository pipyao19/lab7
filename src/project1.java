//Вариант 1
        //Записать в исходный файл информацию об автомобилях:
        //Модель, рег_номер, год_выпуска, пробег, стоимость
        //Количество автомобилей задать с клавиатуры.
        //Создать программным способом другой файл и переписать в него
// информацию об автомобилях с годом выпуска позднее 2009 года.

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class project1 {
    public static void main(String[] args) {
        try {
            File folder = new File("C:\\Users\\user\\Documents\\предметы 2020\\2 курс, 1 полугодие\\АиП\\lab7");
            if (!folder.exists())
                folder.mkdir();
            File f1 = new File("C:\\Users\\user\\Documents\\предметы 2020\\2 курс, 1 полугодие\\АиП\\lab7\\proj1.txt");
            if (!f1.exists())
                f1.createNewFile();
            RandomAccessFile rf = new RandomAccessFile(f1, "rw"); // чтение и запись
            long fSize = rf.length(); // размер файла
            Scanner sc = new Scanner(System.in, "cp1251");
            System.out.print("Введите количество автомобилей для записи в файл\n"
                    + "=> ");
            int kol = sc.nextInt();
            sc.nextLine(); // очистка буфера после ввода числа

            String model;
            int number, year, probeg, count;
            //----ЗАПИСЬ ИНФОРМАЦИИ О АВТОМОБИЛЯХ В ФАЙЛ----
            for (int i = 0; i < kol; i++) {
                System.out.print("Введите модель " + (i + 1) + " автомобиля => ");
                model = sc.next();
                rf.seek(rf.length()); // поиск конца файла
                rf.writeUTF(model); // запись модели
                for (int j = 0; j < 20 - model.length(); j++)
                    rf.writeByte(1); // добавление байтов до 20-ти любой цифрой (=1)
                System.out.print("Введите его регистрационный номер => ");
                number = sc.nextInt();
                sc.nextLine(); // очистка буфера
                rf.writeInt(number); // запись номера
                System.out.print("Введите год выпуска => ");
                year = sc.nextInt();
                sc.nextLine(); // очистка буфера
                rf.writeInt(year); // запись года выпуска
                System.out.print("Введите пробег авто => ");
                probeg = sc.nextInt();
                sc.nextLine(); // очистка буфера
                rf.writeInt(probeg); // запись пробега
                System.out.print("Введите стоимость => ");
                count = sc.nextInt();
                sc.nextLine(); // очистка буфера
                rf.writeInt(count); // запись стоимости
            }
            rf.close();
            //----ЧТЕНИЕ ИНФОРМАЦИИ О АВТОМОБИЛЯХ ИЗ ФАЙЛА----
            rf = new RandomAccessFile(f1, "r");
            rf.seek(0); // перемещение в начало файла
            System.out.println("Информация о автомобиле");
            System.out.println("Модель \t\t Рег.номер \t\t Год выпуска \t\t Пробег \t\t Стоимость ");
            for (int i = 0; i < kol; i++) {
                model = rf.readUTF();
                for (int j = 0; j < 20 - model.length(); j++)
                    rf.readByte();
                number = rf.readInt();
                year = rf.readInt();
                probeg = rf.readInt();
                count = rf.readInt();
                System.out.println(model + "\t\t\t" + number + "\t\t\t" + year + "\t\t\t" + probeg + "\t\t\t" + count);
            }
            rf.close();

            File folder1 = new File("C:\\Users\\user\\Documents\\предметы 2020\\2 курс, 1 полугодие\\АиП\\lab7");
            if (!folder1.exists())
                folder1.mkdir();
            File f2 = new File("C:\\Users\\user\\Documents\\предметы 2020\\2 курс, 1 полугодие\\АиП\\lab7\\proj1_2.txt");
            if (!f2.exists())
                f2.createNewFile();
            rf = new RandomAccessFile(f1, "r");
            rf.seek(0); // перемещение в начало файла
            System.out.println("Информация о автомобилях с годом выпуска позднее 2009-го");
            System.out.println("Модель \t\t Рег.номер \t\t Год выпуска \t\t Пробег \t\t Стоимость ");
            int kol1 = 2009;
            for (int i = 0; i <= kol1; i++) {
                model = rf.readUTF();
                for (int j = 0; j < 20 - model.length(); j++)
                    rf.readByte();
                number = rf.readInt();
                year = rf.readInt();
                probeg = rf.readInt();
                count = rf.readInt();
                System.out.println(model + "\t\t\t" + number + "\t\t\t" + year + "\t\t\t" + probeg + "\t\t\t" + count);
            }
            rf.close();


        } catch (IOException e) {
            System.out.println("End of file " + e);
        }
    }
}
