// Абстрактный класс Компьютерная периферия
abstract class Peripheral {
    private String brand;
    private String model;
    private double price;
    private static int count = 0; 

    // Конструктор класса
    public Peripheral(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        count++;
    }

    // Конструктор по умолчанию
    public Peripheral() {
        this("Unknown", "Unknown", 0.0);
    }

    // Абстрактный метод для вывода информации
    public abstract void info();

    // Геттеры и сеттеры
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Метод для получения количества объектов
    public static int getCount() { return count; }
}

// Дочерний класс Клавиатура
class Keyboard extends Peripheral {
    private String layout;

    public Keyboard(String brand, String model, double price, String layout) {
        super(brand, model, price);
        this.layout = layout;
    }

    public Keyboard() {
        super();
        this.layout = "Unknown";
    }

    // Метод для симуляции макроса, который автоматически вводит текст
    public void macroInput(String text) {
        System.out.println("Клавиатура ввела текст через макрос: " + text);
    }

    // Перегрузка метода macroInput с задержкой перед вводом текста
    public void macroInput(String text, int delayInSeconds) {
        System.out.println("Клавиатура введёт текст через макрос через " + delayInSeconds + " секунд: " + text);
    }

    // Метод для симуляции залипания клавиши
    public void stickyKey(char key, int times) {
        System.out.println("Залипание клавиши '" + key + "': " + String.valueOf(key).repeat(times));
    }

    @Override
    public void info() {
        System.out.println("Клавиатура: " + getBrand() + " " + getModel() + ", цена: " + getPrice() + ", раскладка: " + layout);
    }

    public String getLayout() { return layout; }
    public void setLayout(String layout) { this.layout = layout; }
}

// Дочерний класс Наушники
class Headphones extends Peripheral {
    private boolean wireless;

    public Headphones(String brand, String model, double price, boolean wireless) {
        super(brand, model, price);
        this.wireless = wireless;
    }

    public Headphones() {
        super();
        this.wireless = false;
    }

    // Метод для симуляции воспроизведения звука
    public void playSound(String track) {
        System.out.println("Наушники воспроизводят трек: " + track);
    }

    // Метод для оповещения о низком заряде батареи
    public void batteryLowAlert() {
        if (wireless) {
            System.out.println("Оповещение: Низкий заряд батареи наушников!");
        } else {
            System.out.println("Это проводные наушники. Оповещения о батарее нет.");
        }
    }

    @Override
    public void info() {
        System.out.println("Наушники: " + getBrand() + " " + getModel() + ", цена: " + getPrice() + ", беспроводные: " + (wireless ? "Да" : "Нет"));
    }

    public boolean isWireless() { return wireless; }
    public void setWireless(boolean wireless) { this.wireless = wireless; }
}

// Дочерний класс Графический планшет
class GraphicsTablet extends Peripheral {
    private int penPressure;

    public GraphicsTablet(String brand, String model, double price, int penPressure) {
        super(brand, model, price);
        this.penPressure = penPressure;
    }

    public GraphicsTablet() {
        super();
        this.penPressure = 0;
    }

    // Метод для рисования линии
    public void drawLine(int length) {
        System.out.println("Нарисована линия длиной " + length + " единиц с чувствительностью пера " + penPressure);
    }

    // Метод для масштабирования объекта
    public void scaleObject(double scaleFactor) {
        System.out.println("Масштабирование объекта: " + (scaleFactor > 1 ? "увеличение" : "уменьшение") + " в " + scaleFactor + " раз.");
    }

    @Override
    public void info() {
        System.out.println("Графический планшет: " + getBrand() + " " + getModel() + ", цена: " + getPrice() + ", чувствительность пера: " + penPressure + " уровней");
    }

    public int getPenPressure() { return penPressure; }
    public void setPenPressure(int penPressure) { this.penPressure = penPressure; }
}

    public class TestPeripheral {
    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard("Logitech", "G213", 50.99, "QWERTY");
        Headphones headphones = new Headphones("Sony", "WH-1000XM4", 299.99, true);
        GraphicsTablet tablet = new GraphicsTablet("Wacom", "Intuos Pro", 379.99, 8192);

        keyboard.info();
        headphones.info();
        tablet.info();

        keyboard.macroInput("Привет, мир!");
        keyboard.macroInput("Задержка макроса", 5);
        keyboard.stickyKey('A', 5);

        headphones.playSound("Favorite Track");
        headphones.batteryLowAlert();

        tablet.drawLine(100);
        tablet.scaleObject(1.5);

        System.out.println("Количество периферийных устройств: " + Peripheral.getCount());
    }
}
