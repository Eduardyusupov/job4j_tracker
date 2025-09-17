package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenComparatorByPriorityAndName() {
        Comparator<Job> descPriorityAscName = new JobDescByPriority().thenComparing(new JobAscByName());
        int rsl = descPriorityAscName.compare(
                new Job("Vladic", 1),
                new Job("Alexei", 1)

        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenAscByName() {
        List<Job> jobs = Arrays.asList(
             new Job("Mormon", 1),
             new Job("Vladic", 2),
             new Job("Alexei", 3),
             new Job("Marmon", 4)
        );

        List<Job> expected = Arrays.asList(
                new Job("Alexei", 3),
                new Job("Marmon", 4),
                new Job("Mormon", 1),
                new Job("Vladic", 2)
        );
        Collections.sort(jobs, new JobAscByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Mormon", 1),
                new Job("Vladic", 2),
                new Job("Alexei", 3),
                new Job("Marmon", 4)
        );

        List<Job> expected = Arrays.asList(
                new Job("Vladic", 2),
                new Job("Mormon", 1),
                new Job("Marmon", 4),
                new Job("Alexei", 3)
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Mormon", 1),
                new Job("Vladic", 2),
                new Job("Alexei", 3),
                new Job("Marmon", 4)
        );

        List<Job> expected = Arrays.asList(
                new Job("Marmon", 4),
                new Job("Alexei", 3),
                new Job("Vladic", 2),
                new Job("Mormon", 1)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Marmon", 4),
                new Job("Alexei", 3),
                new Job("Vladic", 2),
                new Job("Mormon", 1)
        );

        List<Job> expected = Arrays.asList(
                new Job("Mormon", 1),
                new Job("Vladic", 2),
                new Job("Alexei", 3),
                new Job("Marmon", 4)
        );
        Collections.sort(jobs, new JobAscByPriority());
        assertThat(jobs).isEqualTo(expected);
    }
}