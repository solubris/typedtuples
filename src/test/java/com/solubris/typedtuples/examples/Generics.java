/*
 * Copyright 2020 Solubris Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.solubris.typedtuples.examples;

import com.solubris.typedtuples.function.CoupleFunction;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

class Generics {

    private abstract static class BaseClass {
        public String baseMethod() {
            return "base";
        }
    }

    private static class SubClass1 extends BaseClass {
    }

    private static class SubClass2 extends BaseClass {
    }

//    @Test
//    void canMapToSubClassOfTheTarget() {
//        var underTest = ImmutableTuple.of(1, 1);
//        ImmutableCouple<Integer, BaseClass> actual = underTest.map(i -> new SubClass1());
//        var expected = ImmutableTuple.of(1, new SubClass1());
//        System.out.println(actual.equals(expected));
//
//        Assertions.assertThat(actual.get().baseMethod()).isEqualTo("base");
//
//    }
//
//    @Test
//    void canMapToSubClassOfTheTarget2() {
//        var underTest = ImmutableTuple.of(1, 1);
//        Couple<Integer, Iterable<Integer>> actual = underTest.map(List::of);
//        var expected = ImmutableTuple.of(1, List.of(1));
//        System.out.println(actual.equals(expected));
//
////        Assertions.assertThat(actual.get().baseMethod()).isEqualTo("base");
//    }
//
//    @Test
//    void canMapFromSuperClassOfTheTarget() {
//        var underTest = ImmutableTuple.of(1, 1);
//        Function<Number, Iterable<Number>> of = List::of;
////        Couple<Integer, Iterable<Integer>> actual = underTest.map(of);
//        var expected = ImmutableTuple.of(1, List.of(1));
////        System.out.println(actual.equals(expected));
//
////        Assertions.assertThat(actual.get().baseMethod()).isEqualTo("base");
//    }

    /**
     * Requires the capture: ? super T
     */
    @Test
    void canMapFromSuperClassOfTheTarget() {
        Function<BaseClass, String> function = BaseClass::baseMethod;

        var underTest1 = ImmutableTuple.of(1, new SubClass1());
        var underTest2 = ImmutableTuple.of(1, new SubClass2());
        var actual1 = underTest1.mapSecond(function);
        var actual2 = underTest2.mapSecond(function);

        Assertions.assertThat(actual1.getSecond()).isEqualTo("base");
        Assertions.assertThat(actual2.getSecond()).isEqualTo("base");
    }

    /**
     * Given a function that can operate on a baseClass
     * It should be accepted by transform for any tuples with a subclass of the baseClass
     *
     * Requires the capture: ? super T
     */
    @Test
    void canTransformFromSuperClassOfTheTarget() {
        CoupleFunction<Integer, BaseClass, String> function = (integer, baseClass) -> baseClass.baseMethod() + integer;

        var underTest1 = ImmutableTuple.of(1, new SubClass1());
        var underTest2 = ImmutableTuple.of(2, new SubClass2());
        var actual1 = underTest1.transform(function);
        var actual2 = underTest2.transform(function);

        Assertions.assertThat(actual1).isEqualTo("base1");
        Assertions.assertThat(actual2).isEqualTo("base2");
    }

//    /**
//     * Requires the capture: ? super T
//     */
//    @Test
//    void canComputeFromSuperClassOfTheTarget() {
////        CoupleFunction<Integer, BaseClass, Couple<Integer, BaseClass>> function = ImmutableTuple::of;
//        UnaryOperator<BaseClass> function = sc -> (sc instanceof SubClass1) ? new SubClass2() : new SubClass1();
//
//        var underTest1 = MutableTuple.of(1, (BaseClass)new SubClass1());
//        var underTest2 = MutableTuple.of(1, (BaseClass)new SubClass2());
//        underTest1.compute(function);
//        underTest2.compute(function);
//
//        Assertions.assertThat(underTest1.get().baseMethod()).isEqualTo("base");
//        Assertions.assertThat(underTest2.get().baseMethod()).isEqualTo("base");
//    }
}
