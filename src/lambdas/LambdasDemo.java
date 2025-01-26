package lambdas;

import java.util.List;
import java.util.function.*;

public class LambdasDemo {

    public static void predicateInterface(){
        Predicate<String> isLongerThan5 = str -> str.length() > 5;

        System.out.println(isLongerThan5.test("hej"));
        System.out.println(isLongerThan5.test("testee"));

        Predicate<String> leftBrace = str -> str.startsWith("{");
        Predicate<String> rightBrace = str -> str.endsWith("}");
        boolean result = leftBrace
                .and(rightBrace)
                .test("{Testee}");
        System.out.println(result);

        // .negate() Er det samme som at skrive not='!'.
        // return true
        System.out.println(leftBrace.negate().test("w"));
    }

    public static void functionInterface(){
        Function<String, Integer> getStringLength =
                str -> str.length();

        System.out.println(getStringLength.apply("string"));

        Function<String,String> replace =
                str -> str.replace(":", "=");
        Function<String, String> addBraces =
                str -> "{" + str + "}";

        // Format af string.
        var result = replace
                .andThen(addBraces)
                .apply("key:value");

        System.out.println(result);
    }

    public static void supplierInterface(){
        Supplier<Double> getRandom = () -> Math.random();
        System.out.println(getRandom.get());
    }

    public static void consumerFunctionalInterface(){
        List<String> list = List.of("a", "b", "c");
        //List<Integer> list = List.of(1,2,3);
        Consumer<String> print = System.out::println;
        Consumer<String> printUpperCase = item ->
                System.out.println(item.toUpperCase());

        list.forEach(print);
        // Channing
        list.forEach(print.andThen(printUpperCase).andThen(print));


        // Imperative programming
        for (var item : list)
            System.out.println(item);
        // Declarative programming
        list.forEach(System.out::println);
    }

    public static void binaryAndUnaryOperator() {
        BinaryOperator<Integer> add = Integer::sum;
        Function<Integer,Integer> square = a -> a*a;
        var result = add.andThen(square).apply(1,2);
        // System.out.println(result);

        UnaryOperator<Integer> square2 = a -> a*a;
        var result2 = square2.andThen(square).apply(2);
        System.out.println(result2);

    }

    /// ----------- De hører sammmen ----------
    public static String prefix = "-";
    public LambdasDemo(String message){

    }
    public static void print(String message){}
    public static void lambdaExample(){
        // Fordi, at vi har et interface, i parameter,
        // kan vi bruge lambda. Da metoden er void i interface,
        // tilader den en sout som er void
        greet(messsage -> System.out.println(prefix + messsage));
        greet(System.out::println);

        // det samme
        greet(message -> print(message));
        greet(LambdasDemo::print);

        // det samme
        greet(message -> new LambdasDemo(message));
        greet(LambdasDemo::new);
    }
    public static void greet(Printer printer) {
        printer.print("hello world");
    }
    // -------------------------------------
}