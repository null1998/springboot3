package org.example;

import org.example.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * @author huang
 */
public class JDK17Test {

    @Test
    public void testSwitch() {
        int a = 1, b = 2;
        Assertions.assertEquals(3, cal(a, b, "+"));
        Assertions.assertEquals(-1, cal(a, b, "-"));
        Assertions.assertThrows(RuntimeException.class, () -> {
            int c = cal(a, b, "*");
        });
    }

    @Test
    public void testText() {
        String json = """
                {
                  "name": "古时的风筝",
                  "age": 18
                }
                """;
        System.out.println(json);
    }

    @Test
    public void testRecord() {
        User user = new User("1", "张三");
        Assertions.assertEquals("1", user.id());
        System.out.println(user);
    }

    @Test
    public void testInstanceOf() {
        Object o = new User("1", "张三");
        Assertions.assertEquals("1", instanceOf(o));
    }

    @Test
    public void testDateTimePattern() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("B");
        Assertions.assertEquals("上午", dtf.format(LocalTime.of(8, 0)));
        Assertions.assertEquals("下午", dtf.format(LocalTime.of(13, 0)));
        Assertions.assertEquals("晚上", dtf.format(LocalTime.of(20, 0)));
        Assertions.assertEquals("晚上", dtf.format(LocalTime.of(23, 0)));
        Assertions.assertEquals("午夜", dtf.format(LocalTime.of(0, 0)));
    }

    @Test
    public void testNumberFormat() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);
        Assertions.assertEquals("1K", fmt.format(1000));
        Assertions.assertEquals("100K", fmt.format(100000));
        Assertions.assertEquals("1M", fmt.format(1000000));
    }

    @Test
    public void testStreamToList() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.toList();
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    private int cal(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            default -> {
                throw new RuntimeException("未知的运算符" + op);
            }
        };
    }

    private String instanceOf(Object o) {
        if (o instanceof User user) {
            return user.id();
        }
        return null;
    }
}
