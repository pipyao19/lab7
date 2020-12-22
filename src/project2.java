import java.io.*;
import java.util.Scanner;
class Avto implements Serializable {
    String model; // название авто
    double number, year, probeg, count; // номер, год, пробег, стоимость авто
}
public class project2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Scanner sc=new Scanner(System.in,"cp1251");
        // создается файл на диске
        File f=new File("C:\\Users\\user\\Documents\\предметы 2020\\2 курс, 1 полугодие\\АиП\\lab7\\proj2");
        f.createNewFile();
// -------------ЗАПИСЬ ОБЪЕКТА В ФАЙЛ-------------
// Создается поток для записи объекта
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
// Вводится информация об объекте (авто)
        Avto avto = new Avto();
        System.out.println("Введите информацию о автомобиле: ");
        System.out.print("Модель авто => ");
        avto.model=sc.nextLine();
        System.out.print("Регистрационный номер авто => ");
        avto.number=sc.nextDouble();
        System.out.print("Год производства авто => ");
        avto.year=sc.nextDouble();
        System.out.print("Пробег авто => ");
        avto.probeg=sc.nextDouble();
        System.out.print("Стоимость авто => ");
        avto.count=sc.nextDouble();
// Объект записывается в файл
        oos.writeObject(avto);
// Дописывается информация и закрывается файловый поток
        oos.flush();
        oos.close();
        // -------------ЧТЕНИЕ ОБЪЕКТА ИЗ ФАЙЛА-------------
// Создается поток для чтения объекта из файла
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream oin = new ObjectInputStream(fis);
// Объект считывается, и на экран выводится требуемая информация
        avto = (Avto) oin.readObject();
        System.out.println(" Модель авто "+ avto.model);
        System.out.println(" его рег.номер = "+ avto.number);
        System.out.println(" год выпуска = "+ avto.year);
        System.out.println(" его пробег = "+ avto.probeg);
        System.out.println(" стоимость = "+ avto.count);
// Поток закрывается
        oos.close();
    }

}
