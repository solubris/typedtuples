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