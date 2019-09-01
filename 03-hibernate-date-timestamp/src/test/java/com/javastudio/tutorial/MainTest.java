package com.javastudio.tutorial;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class MainTest {

    @Test
    public void iso8859() throws Exception {
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("Default Charset in Use=" + getDefaultCharSet());

        String s = "\u064aHello";
        byte[] utf8 = s.getBytes("UTF-8");
        byte[] latin1 = new String(utf8, "UTF-8").getBytes("ISO-8859-1");
        System.out.println();

        System.out.println("Character array of string (unicode)");
        for (char c : s.toCharArray()) {
            System.out.print(String.format("%04x ", (int) c));
        }
        System.out.println();

        System.out.println("String byte-array (UTF-8)");
        for (byte b : utf8) {
            System.out.print(String.format("%x ", unsignedToBytes(b)));
        }
        System.out.println();

        System.out.println("String byte-array (ISO-8859-1) (8-bits)");
        for (byte b : latin1) {
            System.out.print(String.format("%x ", unsignedToBytes(b)));
        }
        System.out.println();
    }

    private static String getDefaultCharSet() {
        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
        String enc = writer.getEncoding();
        return enc;
    }

    public static int unsignedToBytes(byte b) {
        return b & 0xFF;
    }
}