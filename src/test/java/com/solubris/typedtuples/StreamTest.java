package com.solubris.typedtuples;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    private static int sid = 1;

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
