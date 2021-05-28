package labs.util.locale;

/**
 * Russian localization class
 * @author Romzeus
 */
public class RussianLocalization extends Localization{
    /**
     * Constructor of RussianLocalization with basic keyphrase collection
     */
    public RussianLocalization() {
        addEntry("Incorrect command", "Неверная команда");
        addEntry("Empty file", "Файл пуст");
        addEntry("Something wrong file", "Что-то пошло не так при открытии файла");
        addEntry("Name not null", "Название не может быть пустым.");
        addEntry("Try again", "Попробуйте еще раз");
        addEntry("Distance not less than 1", "Расстояние не может быть меньше 1.");
        addEntry("Write x coordinate", "Введите координату x: ");
        addEntry("X coordinate not null", "Координата x не может быть пустой или не числом.");
        addEntry("Write y coordinate", "Введите координату y: ");
        addEntry("Write name", "Введите название: ");
        addEntry("Write distance", "Введите расстояние: ");
        addEntry("X coordinate not greater than 130", "Координата x не может быть больше 130.");
        addEntry("Y coordinate not null", "Координата y не может быть пустой или не числом.");
        addEntry("Update description", "Обновляет значение элемента с заданным id");
        addEntry("Coordinate creation", "Создание объекта координат");
        addEntry("Location creation", "Создание объекта локации");
        addEntry("Wrong format", "Неверный формат");
        addEntry("Object not found", "Объект не найден");
        addEntry("filter_starts_with_name description", "Выводит элементы, значение поля name которых начинается с заданной подстроки");
        addEntry("show description", "Выводит элементы коллекции в строковом представлении");
        addEntry("save description", "Сохраняет коллекцию в json-файл");
        addEntry("remove_lower description", "Удаляет из коллекции элементы, меньшие заданного");
        addEntry("remove_by_id description", "Удаляет элемент из коллекции по id");
        addEntry("Wrong id format","Неправильный формат ввода id");
        addEntry("No id", "Нет элемента с таким id");
        addEntry("print_descending description", "Выводит элементы коллекции в порядке убывания");
        addEntry("info description", "Выводит информацию о коллекции");
        addEntry("Collection type", "Тип коллекции: ");
        addEntry("Collection element type", "Тип элементов коллекции: ");
        addEntry("No elements", "Нет элементов");
        addEntry("Init time", "Время инициализации: ");
        addEntry("history description", "Выводит последние 15 команд без их аргументов");
        addEntry("head description", "Выводит первый элемент коллекции");
        addEntry("filter_less_than_distance description", "Выводит элементы, значение поля distance которых меньше заданного");
        addEntry("exit description", "Завершает работу программы (без сохранения)");
        addEntry("execute_script description", "Считывает и исполняет скрипт из файла");
        addEntry("File not found", "Файл не найден");
        addEntry("clear description", "Удаляет все элементы коллекции");
        addEntry("add description", "Добавляет в коллекцию новый объект");
        addEntry("Recursion", "Обнаружена рекурсия");
        addEntry("connection failure", "Ошибка соединения");
    }
}
