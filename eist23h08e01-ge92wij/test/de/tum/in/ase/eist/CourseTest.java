package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

	// TODO 1: Test getCourseTitle()
    @Test
    void testGetCourseTitle() {
        Course tested = new Course("EIST");
        assertEquals(tested.getTitle(), "EIST");
    }

    //getNumberOfAttendees() in Course returns the number of attendees of the course.
    //
    //Add a new test case testNoAttendees() in CourseTest. It should check if getNumberOfAttendees() returns 0 if there are no attendees.
    //Add a new test case testThreeAttendees() in CourseTest. It should check if getNumberOfAttendees() returns 3 if there are three attendees.

	// TODO 2: Test getNumberOfAttendees()
    @Test
    void testNoAttendees() {
        Course noOneAttends = new Course("Boring");
        assertEquals(noOneAttends.getNumberOfAttendees(), 0);
    }

    @Test
    void testThreeAttendees() {
        Course interesting = new Course("Botev Plovdiv");
        Student gogo = new Student("Gogo", "Losta", "28.10.2003", "Futbol", "Lostove");
        Student marto = new Student("Marto", "Parkinga", "01.10.2003", "CS", "Nargilist");
        Student acho = new Student("Acho", "Betadjiqta", "20.07.2003", "Botev Plovdiv", "Liverpool");
        interesting.addAttendee(gogo);
        interesting.addAttendee(marto);
        interesting.addAttendee(acho);
        assertEquals(interesting.getNumberOfAttendees(), 3);
    }

}
