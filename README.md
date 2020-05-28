[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.solubris/typedtuples/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.solubris/typedtuples)
[![Javadocs](http://www.javadoc.io/badge/com.solubris/typedtuples.svg)](http://www.javadoc.io/doc/com.solubris/typedtuples)

# typedtuples

Strongly typed tuple library for java

## Example

Java streams don't handle computation of multiple values nicely, eg:
- compute sum(N), sum(N^2)

This could be done using arrays as follows:

        int[] result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new int[]{i, i * i})
                .reduce(
                        new int[2],
                        (ints, ints2) -> new int[]{ints[0] + ints2[0], ints[1] + ints2[1]}
                );

With tuples and a tuple accumulator, this can be done as follows:
    
        CoupleAccumulator<Integer, Integer> accumulator = Accumulator.of(Integer::sum, Integer::sum);
        Couple<Integer, Integer> result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> ImmutableTuple.of(i, i * i))
                .reduce(
                        ImmutableTuple.of(0, 0),
                        accumulator::combine
                );

## Strong typing

The tuples never convert the Object class.

Using Objects defeats the purpose of tuples, might as well use a List or Array of objects if that's the case.

## Not Serializable

Tuples are only meant to be used as temporary holders for manipulation.
So they should not be used as fields in other classes which means they don't need to be serializable.

## Not Comparable

Without knowing if the types are comparable, then the tuples also can't be comparable (without casting).

## English names

No names like tuple2 because they are not fluent.

## Stream friendly

Designed for use in streams where tuples are especially useful for manipulating the intermediate values.
Methods like map are especially useful in stream operations.

# Alternatives

- org.javatuples
- org.eclipse.collections.impl.tuple.Tuples
- reactor.util.function.Tuples


