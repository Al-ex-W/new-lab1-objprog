import java.util.Random;
public enum Models_enum {
    VOLVO240,
    SAAB95,
    SCANIA,
    RANDOMCAR;

    private static final Random rand = new Random();
    public static Models_enum getRandomModel() {
        Models_enum[] values = Models_enum.values();
        return values[rand.nextInt(values.length - 1)];
    }
}
