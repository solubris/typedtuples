[![Build Status](https://github.com/solubris/typedtuples/actions/workflows/ci.yml/badge.svg)](https://github.com/solubris/typedtuples/actions/workflows/ci.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=solubris_typedtuples&metric=alert_status)](https://sonarcloud.io/dashboard?id=solubris_typedtuples)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.solubris/typedtuples/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.solubris/typedtuples)
[![Javadocs](http://www.javadoc.io/badge/com.solubris/typedtuples.svg)](http://www.javadoc.io/doc/com.solubris/typedtuples)

# TypedTuples

Strongly typed tuple library for java

## Install

- Maven
```xml
        <dependency>
          <groupId>com.solubris</groupId>
          <artifactId>typedtuples</artifactId>
          <version>2.1</version>
        </dependency>
```
- Gradle
```groovy
        implementation 'com.solubris:typedtuples:2.1'
```

## Example

### Multivalued Computation

Java streams don't handle computation of multiple values nicely, eg:
- compute sum(N), sum(N^2)

This could be done using arrays as follows:

```java
        int[] result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new int[]{i, i * i})
                .reduce(
                        new int[2],
                        (l, r) -> new int[]{l[0] + r[0], l[1] + r[1]}
                );
```

With tuples and a tuple accumulator, this can be done as follows:
    
```java
        CoupleAccumulator<Integer, Integer> accumulator = Accumulator.of(Integer::sum, Integer::sum);
        Couple<Integer, Integer> result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> ImmutableTuple.of(i, i * i))
                .reduce(
                        ImmutableTuple.of(0, 0),
                        accumulator::combine
                );
```

### Enrichment

Enriching a stream of data can be done as follows:

```java
        List<StringStats> result = Stream.of("abc", "1234", "zzz")
                .map(ImmutableTuple::of)
                .map(s -> s.mapAndAdd(String::length))
                .map(sl -> sl.mapFirstAndAdd(this::isPalindrome))
                .map(ImmutableTuple.to(StringStats::new))
                .collect(Collectors.toList());
```

## Usage

There are 3 types of tuples which can be created from the builder classes as follows:

```java
        ImmutableTuple.of(0, 0);
        MutableTuple.of(0, 0);
        Accumulator.of(Integer::sum, Integer::sum);
```

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

However, some custom comparators are provided as follows:

```java
        list.sort(Couple.compareByAllFieldsInOrder());
        list.sort(Couple.compareByAllFieldsInReverseOrder());
        list.sort(Single.compareByAllFieldsInOrder(String::length));
        list.sort(Single.compareByAllFieldsInOrder(Comparator.nullsLast(Integer::compareTo));
```

## English names

No names like tuple2 because they are not fluent.

## Stream friendly

Designed for use in streams where tuples are especially useful for manipulating the intermediate values.
Methods like map are especially useful in stream operations.

## Java 14 Record types

Will record types eliminate the need for tuples?
Let's look at the example of returning a Couple of values.

```java
        public Couple<String, String> getNameValue() {
            return ImmutableTuple.of("name", "value");
        }
```
        
How could this be done with record types?

```java
        record NameValue(String name, String value){}
        public NameValue getNameValue() {
            return new NameValue("name", "value");
        }
```
        
So record types would still require the creation of a separate definition, however that definition would be very concise.
This is probably suitable for method returns,
but still not suitable for multistage stream enrichment as every stage would require a record definition.
Other limitations:

- it's not possible to have mutable record types
- record types don't support generics
- record types wont have the rich api of tuples

Record types can be a good target for the result of enrichment, eg:

```java
        ImmutableTuple.of("name", "value").transform(NameValue::new);
```

## Alternatives

|                     | Arity  | Naming    | self contained     | Immutable          | Mutable            | Strongly Typed     | Accumulators       | Comparators        | Collectors         | Overloaded Builders | Primitives         | Nullable Values    |
|---------------------|--------|-----------|--------------------|--------------------|--------------------|--------------------|--------------------|--------------------|--------------------|---------------------|--------------------|--------------------|
| TypeTuples          | 0 - 10 | English   | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |                    | :heavy_check_mark:  |                    | :heavy_check_mark: |
| javatuples          | 1 - 10 | English   | :heavy_check_mark: | :heavy_check_mark: |                    |                    |                    |                    |                    |                     |                    | :heavy_check_mark: |
| jooq tuples         | 0 - 16 | Numerical |                    | :heavy_check_mark: |                    |                    |                    |                    | :heavy_check_mark: |                     |                    | :heavy_check_mark: |
| apache lang3        | 2 - 3  | English   |                    | :heavy_check_mark: | :heavy_check_mark: |                    |                    |                    |                    |                     |                    | :heavy_check_mark: |
| eclipse collections | 2      | English   |                    | :heavy_check_mark: |                    |                    |                    |                    |                    |                     | :heavy_check_mark: | :heavy_check_mark: |
| reactor utils       | 2 - 8  | Numerical |                    | :heavy_check_mark: |                    |                    |                    |                    |                    | :heavy_check_mark:  |                    |                    |

- org.javatuples

In the Tuple base class it holds the values here:

    private final Object[] valueArray;
    private final List<Object> valueList;

This is in addition to the Pair class (for instance) values:

    private final A val0;
    private final B val1;

The valueList is populated with Arrays.asList(valueArray), so it doesn't copy all the values again.
In summary, every value is stored twice and there are two extra references for each tuple.
So for a Pair, that's 4 extra object references (or 200%).
    
- org.eclipse.collections.impl.tuple.Tuples

- reactor.util.function.Tuples

- org.apache.commons.lang3.tuple

   - is comparable - uses reflection to work out which comparator

- org.jooq.lambda.tuple

   - toArray(), Comparable, Serializable, Cloneable
   - concat, split, limit, skip, swap, map, mapAll
   - collect tuples from multiple collectors
   - not self contained
