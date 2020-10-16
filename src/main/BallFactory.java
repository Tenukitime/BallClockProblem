package main;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallFactory {

    public static List<IBall> CreateBalls(int count) {
        return IntStream.range(0, count)
                .mapToObj(num -> new Ball(num))
                .collect(Collectors.toList());
    }
}
