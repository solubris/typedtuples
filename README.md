image:https://maven-badges.herokuapp.com/maven-central/com.solubris/typedtuples/badge.svg["Maven Central", link="https://maven-badges.herokuapp.com/maven-central/com.solubris/typedtuples"]

# typedtuples
Strongly typed tuple library for java

org.javatuples is the tuple library I have been using for years but it hasn't been updated for a long time and it fundamentally flawed.
So I am creating a new library - typedtuples

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

org.javatuples
org.eclipse.collections.impl.tuple.Tuples
reactor.util.function.Tuples

