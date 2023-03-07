package io.jagdesh.learn.d_streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class di_max {
    public static void main(String[] args) {
        List<BigDecimal> stringList = new ArrayList<>();
        stringList.add(BigDecimal.valueOf(123.45));
        stringList.add(BigDecimal.valueOf(987.6));
        stringList.add(BigDecimal.valueOf(987.59));

        Stream<BigDecimal> streamValue = stringList.stream();
        Optional<BigDecimal> maxVal= streamValue.max((val1, val2) -> {
            return val1.compareTo(val2);
        });
        System.out.println("\n" + maxVal);
    }
}
