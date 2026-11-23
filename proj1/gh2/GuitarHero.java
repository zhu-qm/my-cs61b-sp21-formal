package gh2;

import deque.ArrayDeque;
import deque.Deque;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    private static final int STANDARD = 440
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private Deque<GuitarString> notes;

    public GuitarHero() {
        notes = new ArrayDeque<>();
        for (int i = 0; i < keyboard.length(); i++) {
            double frequency = STANDARD * Math.pow(2, (i - 24.0)/12.0);
            GuitarString note = new GuitarString(frequency);
            notes.addLast(note);
        }
    }

    public static void main(String[] args) {
        /* create guitar strings */
        GuitarHero h = new GuitarHero();

        while (!StdIn.isEmpty()) {}
    }
}
