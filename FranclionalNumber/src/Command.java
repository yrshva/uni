import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Указывает, что наша Аннотация может использована во время выполнения через Reflection (нам как раз это нужно).
@Target(ElementType.METHOD) //Указывает, что целью нашей Аннотации является метод (не класс, не переменная, не поле, а именно метод).
public @interface Command //Описание. Заметим, что перед interface стоит @;
{
    String name(); //Команда за которую будет отвечать функция (например "привет");

    String args(); //Аргументы команды, использоваться будут для вывода списка команд

    String desc(); //Описание, тоже для списка
}