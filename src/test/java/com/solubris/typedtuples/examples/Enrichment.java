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

import com.solubris.typedtuples.immutable.ImmutableTuple;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Use tuples to enrich the items processed in the stream
 * without having to create intermediary objects
 */
public class Enrichment {

    @Test
    void determineStringAttributes() {
        List<StringStats> result = Stream.of("abc", "1234", "zzz")
                .map(ImmutableTuple::of)
                .map(s -> s.mapAndAdd(String::length))
                .map(sl -> sl.mapFirstAndAdd(this::isPalindrome))
                .map(slp -> slp.mapAll(StringStats::new))
                .collect(Collectors.toList());

        assertThat(result)
                .usingFieldByFieldElementComparator()
                .containsExactly(
                        new StringStats("abc", 3, false),
                        new StringStats("1234", 4, false),
                        new StringStats("zzz", 3, true)
                );
    }

    private boolean isPalindrome(String first) {
        for (int i = 0; i < first.length() / 2; i++) {
            if(first.charAt(i) != first.charAt(first.length() - 1)) {
                return false;
            }
        }
        return true;
    }

    private static class StringStats {
        private final String value;
        private final int length;
        private final boolean palindrome;

        public String getValue() {
            return value;
        }

        public int getLength() {
            return length;
        }

        public boolean isPalindrome() {
            return palindrome;
        }

        private StringStats(String value, int length, boolean palindrome) {
            this.value = value;
            this.length = length;
            this.palindrome = palindrome;
        }
    }
}
