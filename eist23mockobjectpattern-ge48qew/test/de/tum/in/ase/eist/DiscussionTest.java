package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {


    @TestSubject
    Discussion discussion = new Discussion();

    @Mock
    Course courseMock;

    @Mock
    Comment commentMock;

    @Test
    void testComment() {
        int commentsNum = discussion.getNumberOfComments();
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);

        assertEquals(discussion.addComment(commentMock), true);

        assertEquals(discussion.getNumberOfComments(), commentsNum + 1);

    }

    @Test
    void testCommentIfSavingFails() {
        int commentsNum = discussion.getNumberOfComments();
        expect(commentMock.save()).andReturn(false);
        replay(commentMock);

        assertEquals(discussion.addComment(commentMock), false);

        assertEquals(discussion.getNumberOfComments(), commentsNum);
    }

    @Test
    void testStartCourseDiscussion() {
        Lecturer lecturer = new Lecturer("Cristiano", "Ronaldo", LocalDate.now());
        expect(courseMock.isDiscussionAllowed(lecturer)).andReturn(true);
        replay(courseMock);

        assertEquals(discussion.startCourseDiscussion(courseMock, lecturer, "Is programming fun"), true);


        assertEquals(discussion.getTopic(), "Is programming fun");
        assertEquals(discussion.getCourse(), courseMock);

    }


}
