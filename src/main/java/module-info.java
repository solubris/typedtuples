open module typedtuples {
    // module typedtuples does not "opens com.solubris.typedtuples" to unnamed module @41a2befb
    // open is required for assertj assertions to work
    requires java.base;
    exports com.solubris.typedtuples;
    exports com.solubris.typedtuples.accumulator;
    exports com.solubris.typedtuples.immutable;
    exports com.solubris.typedtuples.mutable;
    exports com.solubris.typedtuples.function;
}