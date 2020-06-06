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

package com.solubris.typedtuples;

import java.util.Comparator;
import java.util.function.Function;

public interface Triple<A, B, C> {
    A getFirst();

    B getSecond();

    C get();

    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>> Comparator<Triple<A, B, C>> compareByAllFieldsInOrder(
    ) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(Triple::getFirst);
        Comparator<Triple<A, B, C>> b = Comparator.comparing(Triple::getSecond);
        Comparator<Triple<A, B, C>> c = Comparator.comparing(Triple::get);
        return (a).thenComparing(b).thenComparing(c);
    }

    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>> Comparator<Triple<A, B, C>> compareByAllFieldsInReverseOrder(
    ) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(Triple::getFirst);
        Comparator<Triple<A, B, C>> b = Comparator.comparing(Triple::getSecond);
        Comparator<Triple<A, B, C>> c = Comparator.comparing(Triple::get);
        return (c).thenComparing(b).thenComparing(a);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>> Comparator<Triple<A, B, C>> compareByAllFieldsInOrder(
            Function<A, FA> fa, Function<B, FB> fb, Function<C, FC> fc) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(fa.compose(Triple::getFirst));
        Comparator<Triple<A, B, C>> b = Comparator.comparing(fb.compose(Triple::getSecond));
        Comparator<Triple<A, B, C>> c = Comparator.comparing(fc.compose(Triple::get));
        return (a).thenComparing(b).thenComparing(c);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>> Comparator<Triple<A, B, C>> compareByAllFieldsInReverseOrder(
            Function<A, FA> fa, Function<B, FB> fb, Function<C, FC> fc) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(fa.compose(Triple::getFirst));
        Comparator<Triple<A, B, C>> b = Comparator.comparing(fb.compose(Triple::getSecond));
        Comparator<Triple<A, B, C>> c = Comparator.comparing(fc.compose(Triple::get));
        return (c).thenComparing(b).thenComparing(a);
    }

    static <A, B, C> Comparator<Triple<A, B, C>> compareByAllFieldsInOrder(Comparator<? super A> ca,
                                                                           Comparator<? super B> cb, Comparator<? super C> cc) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(Triple::getFirst, ca);
        Comparator<Triple<A, B, C>> b = Comparator.comparing(Triple::getSecond, cb);
        Comparator<Triple<A, B, C>> c = Comparator.comparing(Triple::get, cc);
        return (a).thenComparing(b).thenComparing(c);
    }

    static <A, B, C> Comparator<Triple<A, B, C>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(Triple::getFirst, ca);
        Comparator<Triple<A, B, C>> b = Comparator.comparing(Triple::getSecond, cb);
        Comparator<Triple<A, B, C>> c = Comparator.comparing(Triple::get, cc);
        return (c).thenComparing(b).thenComparing(a);
    }
}
