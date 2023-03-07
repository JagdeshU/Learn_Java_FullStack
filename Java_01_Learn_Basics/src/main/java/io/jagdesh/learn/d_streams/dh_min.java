package io.jagdesh.learn.d_streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class dh_min {
    public static void main(String[] args) {
        List<BigDecimal> stringList = new ArrayList<>();
        stringList.add(BigDecimal.valueOf(987.6));
        stringList.add(BigDecimal.valueOf(123.4));
        stringList.add(BigDecimal.valueOf(123.39));

        Stream<BigDecimal> streamValue = stringList.stream();
        Optional<BigDecimal> min = streamValue.min((val1, val2) -> {
            return val1.compareTo(val2);
        });

        BigDecimal minVal = min.get();
        System.out.println("\n" + minVal);
    }
}
