[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.solubris/typedtuples/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.solubris/typedtuples)
[![Javadocs](http://www.javadoc.io/badge/com.solubris/typedtuples.svg)](http://www.javadoc.io/doc/com.solubris/typedtuples)
![Java CI with Maven](https://github.com/solubris/typedtuples/workflows/Java%20CI%20with%20Maven/badge.svg)

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
                        (l, r) -> new int[]{l[0] + r[0], l[1] + r[1]}
                );

With tuples and a tuple accumulator, this can be done as follows:
    
        CoupleAccumulator<Integer, Integer> accumulator = Accumulator.of(Integer::sum, Integer::sum);
        Couple<Integer, Integer> result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> ImmutableTuple.of(i, i * i))
                .reduce(
                        ImmutableTuple.of(0, 0),
                        accumulator::combine
                );

## Usage

There are 3 types of tuples which can be created from the builder classes as follows:

        ImmutableTuple.of(0, 0);
        MutableTuple.of(0, 0);
        Accumulator.of(Integer::sum, Integer::sum);

The api can the be explored from the results of these methods.

## Strong typing

The tuples are never converted to the Object class.

Alternative tuple libraries have an Object[] toArray();
If this is the requirement, then its better to use a List\<Object> directly.
No need to complicate the solution with tuples.

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


