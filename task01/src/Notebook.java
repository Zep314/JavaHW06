// Класс - ноутбук с параметрами
public class Notebook {
    private String name;  // Наименование
    private String brand;  // Производитель
    private String processor;  // Марка процессора
    private Integer vMemory;  // Объем ОЗУ
    private Integer vHDD;  // Объем жесткого диска
    private String os;  // Операционная система
    private String color;  // Цвет корпуса
    Notebook() { // Простой конструктор с пустыми полями
        name = "";
        brand = "";
        processor = "";
        vMemory = 0;
        vHDD = 0;
        os = "";
        color = "";
    }

    Notebook(
            String _name,
            String _brand,
            String _processor,
            Integer _vMemory,
            Integer _vHDD,
            String _os,
            String _color) {  // Конструктор, который заполняет поля при создании объекта
        name = _name;
        brand = _brand;
        processor = _processor;
        vMemory = _vMemory;
        vHDD = _vHDD;
        os = _os;
        color = _color;
    }
    // Сеттеры и геттеры полей класса
    void SetName(String _name) {
        name = _name;
    }
    void SetBrand(String _brand) {
        brand = _brand;
    }
    void SetProcessor(String _processor) {
        processor = _processor;
    }
    void SetVMemory(int _vMemory) {
        vMemory = _vMemory;
    }
    void SetVHDD(int _vHDD) {
        vHDD = _vHDD;
    }
    void SetOS(String _os) {
        os = _os;
    }
    void SetColor(String _color) {
        color = _color;
    }
    String getName() { return name; }
    String getBrand() { return brand; }
    String getProcessor() { return processor; };
    Integer getVMemory() { return vMemory; }
    Integer getVHDD() { return vHDD; }
    String getOS() { return os; }
    String getColor() { return color; }
    public String toString() {  // Переопределим метод конвертирование объекта в троку
        return "Наименование: " + name + ",\t" +
                "Производитель: " + brand + ",\t" +
                "Процесор: " + processor + ",\t" +
                "Объем ОЗУ: " + vMemory.toString() + "GB,\t" +
                "Объем HDD: " + vHDD.toString() + "GB,\t" +
                "Операционная система: " + os + ",\t" +
                "Цвет: " + color
                ;
    }

    public boolean IsEquivalent(Notebook _ntb) {
    // метод сравнения объекта класса Notebook c текущим объектом
        return
            ((_ntb.getVMemory() == -1 || vMemory == _ntb.getVMemory()) ? true : false) &&
            ((_ntb.getVHDD() == -1 || vMemory == _ntb.getVHDD()) ? true : false) &&
            ((MyStringEqu(name, _ntb.getName())) ? true : false) &&
            ((MyStringEqu(brand, _ntb.getBrand())) ? true : false) &&
            ((MyStringEqu(processor, _ntb.getProcessor())) ? true : false) &&
            ((MyStringEqu(os, _ntb.getOS())) ? true : false) &&
            ((MyStringEqu(color, _ntb.getColor())) ? true : false);
    }

    boolean MyStringEqu(String a, String filter) {
    // сравниваем 2 строки с "подобием" правил SQL
        if (filter.equals("*") || filter.equals("")) {
            return true;
        }
        else if (filter.contains("%")){
            return a.contains(filter.replaceAll("%", ""));
        }
        else return a.equals(filter);
    }
}