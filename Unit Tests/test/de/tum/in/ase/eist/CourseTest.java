package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    // TODO 1: Test getCourseTitle()
    @Test
    void testGetCourseTitle() {
        Course testedTitle = new Course("Ronaldo");
        assertEquals(testedTitle.getTitle(), "Ronaldo");
    }

    // TODO 2: Test getNumberOfAttendees()

    @Test
    void testNoAttendees() {
        Course attendees = new Course("a");
        assertEquals(attendees.getNumberOfAttendees(), 0);
    }

    @Test
    void testThreeAttendees() {
        Course bridge = new Course("bridgeCourse");
        Student student1 = new Student("Stefan", "Koritarev", "24.09.2003", "Informatics", "Maths");
        Student student2 = new Student("Cristiano", "Ronaldo", "05.02.1985", "Sports", "Health");
        Student student3 = new Student("Pesho", "Traktora", "09.09.2009", "Electrotechnik", "Maths");

        bridge.addAttendee(student1);
        bridge.addAttendee(student2);
        bridge.addAttendee(student3);

        assertEquals(bridge.getNumberOfAttendees(), 3);
    }

}
