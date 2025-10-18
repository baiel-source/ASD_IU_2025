package structures;

import java.util.Objects;

public class Student {
    private Long id;
    private String name;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    };

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    };

    @Override
    public int hashCode() {
        return Objects.hash(id);
    };

    @Override
    public String toString() {
        return String.format("Student(id=%d, name=%s)", id, name);
    }

};
