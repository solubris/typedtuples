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

import com.solubris.typedtuples.immutable.ImmutableQuadruple;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class StreamTest {
    private int sid = 1;
    private final List<Student> allStudents = new ArrayList<>();
    {
        allStudents.add(getStudent());
        allStudents.add(getStudent());
    }

    @Test
    void multilevelReduction() throws Exception {

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


        Map<Triple<Long, Long, Long>, Double> result = allStudents.stream()
                .map(ImmutableTuple::of)
                .flatMap(s -> s.get().getCourses().stream().map(
                        c -> s.map(Student::getStudentId).add(c)))
                .flatMap(sc -> sc.getSecond().getTasks().stream().map(
                        t -> sc.mapSecond(Course::getCourseId).add(t)))
                .flatMap(sct -> sct.getThird().getAssessments().stream().map(
                        a -> sct.mapThird(Task::getTaskId).add(a.getScore())))
//                .collect(Collectors.summarizingDouble())
//                .collect(Tuples.QuartetCollector.groupingByAndAccumulating(Double::sum));
                .collect(Collectors.groupingBy(
                        ImmutableQuadruple::removeFourth,
                        Collectors.summingDouble(Quadruple::getFourth)
                ));

        System.out.println(result);
        System.out.println("1,0,0 = " + result.get(ImmutableTuple.of(1L, 0L, 0L)));

        assertThat(result.get(ImmutableTuple.of(1L, 0L, 0L))).isEqualTo(30D);
    }


    /**
     *      how does flatMapping in groupBy compare to flatMapping in stream?
     *      flatMapping in groupBy results in less duplication as the key is only stored once
     *      flatMapping in stream doesn't require nesting
     *      what about performance?
     */
    @Test
    void multilevelReductionWithFlatMapping() {

        Map<Long, Map<Long, Map<Long, Double>>> result = allStudents.stream()
                .collect(Collectors.groupingBy(Student::getStudentId,
                        Collectors.flatMapping(student -> student.getCourses().stream(),
                                Collectors.groupingBy(Course::getCourseId,
                                        Collectors.flatMapping(course -> course.getTasks().stream(),
                                                Collectors.groupingBy(Task::getTaskId,
                                                        Collectors.flatMapping(task -> task.getAssessments().stream(),
                                                                Collectors.summingDouble(Assessment::getScore))))))));

        System.out.println(result);
        System.out.println("1,0,0 = " + result.get(1L).get(0L).get(0L));

        assertThat(result.get(1L).get(0L).get(0L)).isEqualTo(30D);
    }

    private Student getStudent() {
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
}
