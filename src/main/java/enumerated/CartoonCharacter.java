package enumerated;

import generics.Generator;

import java.util.Random;

/**
 * Created by yuez on 14-1-23.
 * An enum can implement an interface
 */
public enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOS;

    Random random = new Random();

    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}
