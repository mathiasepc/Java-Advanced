package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    private static List<Movie> movies = List.of(
            new Movie("b", 10, Genre.ACTION),
            new Movie("c", 30, Genre.ACTION),
            new Movie("a", 20, Genre.COMEDY),
            new Movie("c", 40, Genre.THRILLER)
    );

    public static void primitiveStream(){
        var result = IntStream.of(1,2,3,4);
        IntStream.rangeClosed(1,5)
                .forEach(System.out::println);

    }

    public static void partitioningElements(){
        // Grupperer film ift. likes og indsætter som true eller false.
        var result = movies.stream()
                .collect(Collectors.partitioningBy(
                        m -> m.getLikes() > 20,
                        Collectors.mapping(Movie::getTitle,
                                Collectors.joining(","))));
    }

    // grouping element
    public static void groupingElement(){
        // grupperer film ift. genre
        var result = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
        // tæller de forskellige movies udfra genre
        var result2 = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.counting()));
        // indsætter comma, imellem hver objekt. Inddelt i genre.
        var result3 = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.mapping(Movie::getTitle,Collectors.joining(","))));
    }

    public static void collectors(){
        // her har vi et set af movies. Udfra filter
        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toSet());
        // her har vi en list af movies. Udfra filter
        var result2 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toList());
        // her har vi et hashMap. Udfra filter
        // Man får det specifikke objekt. Det er pga. Function.identity()
        var result3 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Function.identity()));
        // her har vi et sum af integers. Udfra filter
        // der er også for double og long
        var result4 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));
        // Giver os statistik. udfra filter
        // er der også for long og double
        var result5 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));
        // Indsætter ',' mellem hver title, som den henter udfra likes.
        var result6 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(","));
    }

    public static void reducers() {
        // reduce lægger tal sammen.
        Optional<Integer> sum = movies.stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum);

        // hvis den ikke har lagt noget sammen. print 0
        System.out.println(sum.orElse(0));
    }

    public static void simpleReducers() {
        Predicate<Movie> greaterThan20 = m -> m.getLikes() > 20;
        // anyMatch, der skal være en som passer.
        // søgning er true
        movies.stream()
                .anyMatch(greaterThan20);
        // alle skal matche predicate for at få true.
        // søgning er false
        movies.stream()
                .allMatch(greaterThan20);
        // fortæller om ingen af objekterne matcher predicate.
        // false
        movies.stream()
                .noneMatch(greaterThan20);
        // finder første element fra stream.
        movies.stream()
                .findFirst()
                .get();
        // Finder den største. Kan laves på String.
        movies.stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get();
        // finder den mindste. Kan laves på String
        movies.stream()
                .min(Comparator.comparing(Movie::getLikes))
                .get();
    }

    public static void peekingElement() {
        // peek method tillader, at vi kan søge efter fejl,
        // hvis vi ikke får ønsket resultat
        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("filter " + m.getTitle()))
                .map(Movie::getTitle)
                .peek(t -> System.out.println("mapped: " + t))
                .forEach(System.out::println);
    }

    public static void uniqueElement() {
        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);
    }

    public static void sorting() {
        movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(System.out::println);
    }

    public static void slicing() {
        // hvis man nu har 1000 film.
        // 10 pr side.
        // man er på 3 side
        // skip(20) = skip(page-1)*pageSize
        // limit(10) = limit(pageSize)
        movies.stream()
                .skip(20)
                .limit(10)
                .forEach(m -> System.out.println(m.getTitle()));

        // leder indtil den rammer en som er >= 30
        movies.stream()
                .takeWhile(m -> m.getLikes() < 30)
                .forEach(System.out::println);

        // printer først når den rammer > 30
        movies.stream()
                .dropWhile(m -> m.getLikes() < 30)
                .forEach(System.out::println);

    }

    public static void filtering() {

        Predicate<Movie> isPopular = m -> m.getLikes() > 10;

        movies.stream()
                .filter(isPopular)
                .filter(m -> m.getLikes() < 30)
                .forEach(System.out::println);
    }

    public static void map() {
        // Convert Stream<List> -> Stream<x>
        var stream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        stream
                .flatMap(list -> list.stream())
                .forEach(System.out::println);

        // Mapper fra Movie til String. Men map() tager typen T
        movies.stream()
                .map(Movie::getTitle)
                .forEach(System.out::println);

        // Mapper fra Movie til int. Men kun int
        movies.stream()
                .mapToInt(Movie::getLikes)
                .forEach(System.out::println);
    }

    public static void streamExample() {
        // !! en måde at iterate stream på !!
        // ikke aktiv
        var stream = Stream.generate(() -> Math.random());
        // aktiv
        // stream.forEach(System.out::println);
        // Vi sætter limit på
        stream
                .limit(3)
                .forEach(System.out::println);

        // !! en anden måde at iterate stream på !!
        Stream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(System.out::println);
    }

    public static void ImperialVersusFunctional() {
        int count = 0;

        // Imperative programming
        for (var movie : movies)
            if (movie.getLikes() > 10)
                count++;

        // Declarative (Functional) Programming
        var count2 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .count();
    }
}
