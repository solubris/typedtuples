/*
 * =============================================================================
 *
 *   Copyright (c) 2010, The JAVATUPLES team (http://www.javatuples.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package com.solubris.typedtuples;

import com.solubris.typedtuples.accumulator.Accumulator;
import com.solubris.typedtuples.accumulator.CoupleAccumulator;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import com.solubris.typedtuples.mutable.MutableTuple;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {
    private static int sid = 1;

    @Test
    void computeSumAndSumOfSquaresIntArrayReduction() throws Exception {
        // compute sum(N), sum(N^2)

        // creates a new int array for each item during reduction
        int[] result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new int[]{i, i * i})
                .reduce(new int[2], (ints, ints2) -> new int[]{ints[0] + ints2[0], ints[1] + ints2[1]});
        System.out.println(Arrays.toString(result));

        assertThat(result)
                .containsExactly(6, 14);
    }

    @Test
    void computeSumAndSumOfSquareRootsNumberArrayReduction() throws Exception {
        // compute sum(N), sum(sqrt(N))

        // creates a new int array for each item during reduction
        Number[] result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new Number[]{i, Math.sqrt(i)})
                .reduce(new Number[]{0, 0}, (ints, ints2) -> new Number[]{ints[0].intValue() + ints2[0].intValue(), ints[1].doubleValue() + ints2[1].doubleValue()});
        System.out.println(Arrays.toString(result));

        assertThat(result)
                .containsExactly(6, 4.146264369941973);
    }

    @Test
    void computeSumAndSumOfSquaresIntArrayCollection() throws Exception {
        // compute sum(N), sum(N^2)

        int[] result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new int[]{i, i * i})
                .collect(
                        Collector.of(
                                () -> new int[2],
                                (a, t) -> {
                                    a[0] += t[0];
                                    a[1] += t[1];
                                },
                                (a, b) -> {
                                    a[0] += b[0];
                                    a[1] += b[1];
                                    return a;
                                },
                                Collector.Characteristics.IDENTITY_FINISH)

                );
        System.out.println(Arrays.toString(result));

        assertThat(result)
                .containsExactly(6, 14);
    }

    @Test
    void computeSumAndSumOfSquaresTupleReduction() throws Exception {
        // compute sum(N), sum(N^2)
        CoupleAccumulator<Integer, Integer> accumulator = Accumulator.of(Integer::sum, Integer::sum);

        Couple<Integer, Integer> result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> ImmutableTuple.of(i, i * i))
                .reduce(ImmutableTuple.of(0, 0), accumulator::combine);
        System.out.println(result);

        assertThat(result)
                .isEqualTo(ImmutableTuple.of(6, 14));
    }

    @Test
    void computeSumAndSumOfSquareRootsTupleReduction() throws Exception {
        // compute sum(N), sum(sqrt(N))
        CoupleAccumulator<Integer, Double> accumulator = Accumulator.of(Integer::sum, Double::sum);

        Couple<Integer, Double> result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> ImmutableTuple.of(i, Math.sqrt(i)))
                .reduce(ImmutableTuple.of(0, 0D), accumulator::combine);
        System.out.println(result);

        assertThat(result)
                .isEqualTo(ImmutableTuple.of(6, 4.146264369941973));
    }

    @Test
    void computeSumAndSumOfSquaresTupleCollection() throws Exception {
        // compute sum(N), sum(N^2)
        CoupleAccumulator<Integer, Integer> accumulator = Accumulator.of(Integer::sum, Integer::sum);

        Couple<Integer, Integer> result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> ImmutableTuple.of(i, i * i))
                .collect(
                        Collector.of(
                                () -> MutableTuple.of(0, 0),
                                accumulator::accumulate,
                                accumulator::combine,
                                Collector.Characteristics.IDENTITY_FINISH)
                );
        System.out.println(result);

        assertThat(result)
                .isEqualTo(ImmutableTuple.of(6, 14));
    }

    @Test
    void streamTest() throws Exception {
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(getStudent());
        allStudents.add(getStudent());

        // should map be static method in another class?
        // chaining calls doesn't work:
        // t -> Tuple.add(Tuple.map(sc, Course::getCourseId), t)))
        // what is example usage of Mutable tuple?
        // collecting to a couple of longs
        // collecting to a single long can be done with Collectors.summingLong()
        // what about collecting to a long and double?
        // this cant be done with an array as they are different types
        // what about collecting to a count as int and sum as double?
        // this can be done with summarizingDouble
        // need example that summarizes multiple values from the stream
        // eg, a left sum and a right sum - from a couple of longs


//        Map<Triple<Long, Long, Long>, Double> result = allStudents.stream()
//                .map(ImmutableTuple::of)
//                .flatMap(s -> s.get().getCourses().stream().map(
//                        c -> s.map(Student::getStudentId).add(c)))
//                .flatMap(sc -> sc.get().getTasks().stream().map(
//                        t -> sc.map(Course::getCourseId).add(t)))
//                .flatMap(sct -> sct.get().getAssessments().stream().map(
//                        a -> sct.map(Task::getTaskId).add(a.getScore())))
//                .map(MutableTuple::copyOf)
////                .flatMap(sct -> sct.getValue2().getAssessments().stream().map(
////                        a -> Quartet.with(sct.getValue0(), sct.getValue1(), sct.getValue2().taskId, a.getScore())))
//                .collect(Collectors.summarizingDouble())
//                .collect(Tuples.QuartetCollector.groupingByAndAccumulating(Double::sum));
//
////                .collect(Collectors.groupingBy(
////                        Quartet::withoutLast,
////                        Collectors.summingDouble(Quartet::last)
////                ));
//
//        System.out.println(result);

    }

    private static Student getStudent() {
        Student s = new Student();
        s.studentId = sid++;
        Course c = new Course();
        Task t = new Task();
        Assessment a1 = new Assessment();
        a1.score = 10;
        Assessment a2 = new Assessment();
        a2.score = 20;
        t.assessments = List.of(a1, a2);
        c.tasks = List.of(t);
        s.courses = List.of(c);
        return s;
    }

    public static class Student {
        private long studentId;
        private List<Course> courses;

        public long getStudentId() {
            return studentId;
        }

        public List<Course> getCourses() {
            return courses;
        }
    }

    public static class Course {
        private long courseId;
        private List<Task> tasks;

        public long getCourseId() {
            return courseId;
        }

        public List<Task> getTasks() {
            return tasks;
        }
    }

    public static class Task {
        private long taskId;
        private List<Assessment> assessments;

        public long getTaskId() {
            return taskId;
        }

        public List<Assessment> getAssessments() {
            return assessments;
        }
    }

    public static class Assessment {
        private String type;
        private double score;

        public String getType() {
            return type;
        }

        public double getScore() {
            return score;
        }
    }

    private class Residence {
    }
}
