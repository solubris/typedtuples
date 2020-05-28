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

/**
 * There are three types of tuples
 * - immutable - these can't be changed but have methods produce new tuples based on the current tuple
 * - mutable - these have setter methods but none of the methods on immutable tuples to avoid confusion
 * - accumulator - these are tuples of functions which can be applied to a tuple to perform accumulation
 */
package com.solubris.typedtuples;