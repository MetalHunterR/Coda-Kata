package org.metalhunterr.generator;

import java.util.zip.CRC32;

public class CRC32HashGenerator {

    private static final CRC32 crc32 = new CRC32();

    public static long generateHash(String word, int seed) {
        crc32.update(word.getBytes());
        return crc32.getValue();
    }
}
