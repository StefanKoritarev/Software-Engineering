package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {
    //Add a new attribute discussion of type Discussion and annotate it as test subject (SUT). Add two more attributes:
    // courseMock of type Course and commentMock of type Comment and annotate them as well.

    // TODO implement the tests
    @TestSubject
    private Discussion discussion = new Discussion();
    @Mock
    private Course courseMock;
    @Mock
    private Comment commentMock;

    @Test
    void testComment() {
        int numberOfComments = discussion.getNumberOfComments();
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);
        assertEquals(discussion.addComment(commentMock), true);
        assertEquals(numberOfComments + 1, discussion.getNumberOfComments());

    }

    //Write a test method named testCommentIfSavingFails() in DiscussionTest. Check that if saving a comment fails,
    // addComment() also works as specified and the number of comments does not increase.
    @Test
    void testCommentIfSavingFails() {
        int numberOfComments = discussion.getNumberOfComments();
        expect(commentMock.save()).andReturn(false);
        replay(commentMock);
        assertEquals(discussion.addComment(commentMock), false);
        assertEquals(numberOfComments, discussion.getNumberOfComments());
    }

    @Test
    void testStartCourseDiscussion() {
        //The startCourseDiscussion() method checks if a person is allowed to start a discussion by invoking the
        // isDiscussionAllowed() method of Course. We want you to test this method independently from the permission check.
        Student acho = new Student("Angel", "Vanchev", LocalDate.now(), "Informatik", "BWL");
        expect(courseMock.isDiscussionAllowed(acho)).andReturn(true);
        replay(courseMock);
        assertEquals(discussion.startCourseDiscussion(courseMock, acho, "Botev Plovdiv"), true);
        assertEquals(discussion.getCourse(), courseMock);
        assertEquals(discussion.getTopic(), "Botev Plovdiv");
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public Course getCourseMock() {
        return courseMock;
    }

    public Comment getCommentMock() {
        return commentMock;
    }

}
