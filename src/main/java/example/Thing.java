package example;

public class Thing {

    public static int compute(final int arg) {
        final int a = (arg * 13) + (arg % 7) + ((arg ^ 0xFFFFFFFF) % 13);
        final boolean b = a % 0xABCD == 13;
        int c;
        if (b) {
            c = (a ^ 0x0F0F0F0F) % 13;
        }
        else {
            c = (a ^ 0xF0F0F0F0) % 42;
        }
        for (int i = 0; i < (arg / 0xFFFF); ++i) {
            c = (c << 1) + 13 + (c & 7);
        }
        return c;
    }

}
