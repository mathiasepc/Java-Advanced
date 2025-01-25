package streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsDemo {
    private static List<Movie> movies = List.of(
            new Movie("b", 10),
            new Movie("c", 30),
            new Movie("a", 20),
            new Movie("c", 40)
    );

    public static void uniqueElement(){
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
