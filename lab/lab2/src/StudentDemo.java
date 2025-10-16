/*
    Основное задание. Задание оценивается в 0 баллов.
    Создать класс Student с полями:
    1. Long id
    2. String name
    В методе main:
    1. Создать ArrayList, который хранит объекты класса Student
    (ArrayList<Student>).
    2. Создать LinkedList, который хранит объекты класса Student
    (LinkedList <Student>).
    3. Создать Set, который хранит объекты класса Student (HashSet
    <Student>).
    4. Создать HashMap, который хранит объекты класса Student (HashMap
    <Long, Student>).
    В каждую структуру данных добавить 10 000 000 объектов.
    После этого для каждой структуры данных измерить время в нс:
    1. Добавление 1 несуществующего элемента в конец (id = 10 000 001).
    2. Добавление 1 несуществующего элемента в начало.
    3. Удаление последнего элемента
    4. Удаление первого элемента
    5. Взятие (Get) центрального элемента (id = 5 000 000)
    6. Взятие (Get) последнего элемента (id = 9 999 999).
    Помимо кода решение должно содержать цифры, полученные при
    тестах. При невозможности работать с 10 000 000 записей позволительно
    несколько сократить количество объектов.
*/
import structures.Student;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class StudentDemo {

    public static void main(String[] args) {
        final int itemsCount = 7000000;

        List<Student> arrayList = new ArrayList<>();
        List<Student> linkedList = new LinkedList<>();
        Set<Student> hashSet = new HashSet<>();
        Map<Long, Student> hashMap = new HashMap<>();

        for (long i = 1; i <= itemsCount; i++) {
            arrayList.add(new Student(i, "Student " + i));
            linkedList.add(new Student(i, "Student " + i));
            hashSet.add(new Student(i, "Student " + i));
            hashMap.put(i, new Student(i, "Student " + i));
        };

        System.out.println("Результаты тестов: ");

        Student newStudentToStart = new Student(0L, "Student first");
        Student newStudentToEnd = new Student((long) itemsCount + 1, "Student last");

        testArrayListPerformance(
                arrayList,
                newStudentToEnd,
                newStudentToStart
        );

        testLinkedListPerformance(
                linkedList,
                newStudentToEnd,
                newStudentToStart
        );

        testHashSetPerformance(
                hashSet,
                newStudentToEnd,
                newStudentToStart,
                itemsCount
        );

        testHashMapPerformance(
                hashMap,
                newStudentToEnd,
                newStudentToStart,
                itemsCount
        );

    };

    private static void testArrayListPerformance(
            List<Student> arrayList,
            Student newStudentToEnd,
            Student newStudentToStart
    ) {
        long startTime, endTime, duration;
        System.out.println("ArrayList:");

        startTime = System.nanoTime();
        arrayList.add(newStudentToEnd);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Добавление элемента в конец: %,d ns%n", duration);

        startTime = System.nanoTime();
        arrayList.addFirst(newStudentToStart);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Добавление элемента в начало: %,d ns%n", duration);

        startTime = System.nanoTime();
        arrayList.removeLast();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Удаление последнего элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        arrayList.removeFirst();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Удаление первого элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        Student centralStudent = arrayList.get(arrayList.size() / 2);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Получение центрального элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        Student lastStudent = arrayList.getLast();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Получение последнего элемента: %,d ns%n", duration);
    };

    private static void testLinkedListPerformance(
            List<Student> linkedList,
            Student newStudentToEnd,
            Student newStudentToStart
    ) {
        long startTime, endTime, duration;
        System.out.println("LinkedList:");

        startTime = System.nanoTime();
        linkedList.add(newStudentToEnd);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Добавление элемента в конец: %,d ns%n", duration);

        startTime = System.nanoTime();
        linkedList.addFirst(newStudentToStart);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Добавление элемента в начало: %,d ns%n", duration);

        startTime = System.nanoTime();
        linkedList.removeLast();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Удаление последнего элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        linkedList.removeFirst();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Удаление первого элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        Student centralStudent = linkedList.get(linkedList.size() / 2);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Получение центрального элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        Student lastStudent = linkedList.getLast();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Получение последнего элемента: %,d ns%n", duration);
    };

    private static void testHashSetPerformance(
            Set<Student> hashSet,
            Student newStudentToEnd,
            Student newStudentToStart,
            int itemsCount
    ) {
        long startTime, endTime, duration;
        System.out.println("HashSet:");

        startTime = System.nanoTime();
        hashSet.add(newStudentToEnd);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Добавление элемента (ID %d): %,d ns%n", newStudentToEnd.getId(), duration);

        startTime = System.nanoTime();
        hashSet.add(newStudentToStart);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Добавление элемента (ID %d): %,d ns%n", newStudentToStart.getId(), duration);

        startTime = System.nanoTime();
        hashSet.remove(newStudentToEnd);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Удаление последнего элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        hashSet.remove(newStudentToStart);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Удаление первого элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        Student centralStudent = null;
        for (Student s : hashSet) {
            if (s.getId().equals((long) itemsCount / 2)) {
                centralStudent = s;
                break;
            }
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Получение центрального элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        Student lastStudent = null;
        for (Student s : hashSet) {
            if (s.getId().equals((long) itemsCount)) {
                lastStudent = s;
                break;
            }
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Получение последнего элемента: %,d ns%n", duration);
    };

    private static void testHashMapPerformance(
            Map<Long, Student> hashMap,
            Student newStudentToEnd,
            Student newStudentToStart,
            int itemsCount
    ) {
        long startTime, endTime, duration;
        System.out.println("HashMap:");

        startTime = System.nanoTime();
        hashMap.put(newStudentToEnd.getId(), newStudentToEnd);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Добавление элемента (ID %d): %,d ns%n", newStudentToEnd.getId(), duration);

        startTime = System.nanoTime();
        hashMap.put(newStudentToStart.getId(), newStudentToStart);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Добавление элемента (ID %d): %,d ns%n", newStudentToStart.getId(), duration);

        startTime = System.nanoTime();
        hashMap.remove(newStudentToEnd.getId());
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Удаление последнего элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        hashMap.remove(newStudentToStart.getId());
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Удаление первого элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        Student centralStudent = hashMap.get((long) itemsCount / 2);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Получение центрального элемента: %,d ns%n", duration);

        startTime = System.nanoTime();
        Student lastStudent = hashMap.get((long) itemsCount - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("Получение последнего элемента: %,d ns%n", duration);
    }
}

/*
    Результаты тестов (7 млн элементов):
    ArrayList:
    Добавление элемента в конец: 1,292 ns
    Добавление элемента в начало: 1,967,167 ns
    Удаление последнего элемента: 1,833 ns
    Удаление первого элемента: 686,625 ns
    Получение центрального элемента: 7,209 ns
    Получение последнего элемента: 1,000 ns
    LinkedList:
    Добавление элемента в конец: 2,000 ns
    Добавление элемента в начало: 7,708 ns
    Удаление последнего элемента: 1,333 ns
    Удаление первого элемента: 1,041 ns
    Получение центрального элемента: 91,964,458 ns
    Получение последнего элемента: 2,958 ns
    HashSet:
    Добавление элемента (ID 7000001): 3,125 ns
    Добавление элемента (ID 0): 500 ns
    Удаление последнего элемента: 13,250 ns
    Удаление первого элемента: 1,375 ns
    Получение центрального элемента: 31,103,292 ns
    Получение последнего элемента: 32,869,083 ns
    HashMap:
    Добавление элемента (ID 7000001): 1,625 ns
    Добавление элемента (ID 0): 667 ns
    Удаление последнего элемента: 4,750 ns
    Удаление первого элемента: 833 ns
    Получение центрального элемента: 11,958 ns
    Получение последнего элемента: 542 ns
*/