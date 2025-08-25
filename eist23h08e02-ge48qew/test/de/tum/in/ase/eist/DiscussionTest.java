package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {


    @TestSubject
    private Discussion discussion = new Discussion();

    @Mock
    private Course courseMock;

    @Mock
    private Comment commentMock;

    @Test
    void testComment() {
        int expectedSize = discussion.getNumberOfComments();

        expect(commentMock.save()).andReturn(true);
        //discussion.addComment(commentMock);
        replay(commentMock);
        assertEquals(discussion.addComment(commentMock), true);

        assertEquals(expectedSize + 1, discussion.getNumberOfComments());
    }

    @Test
    void testCommentIfSavingFails() {
        int expectedSize = discussion.getNumberOfComments();


        expect(commentMock.save()).andReturn(false);
        replay(commentMock);
        //discussion.addComment(commentMock);
        assertEquals(discussion.addComment(commentMock), false);

        assertEquals(expectedSize, discussion.getNumberOfComments());
    }


    @Test
    void testStartCourseDiscussion() {

        Person student = new Student("Stefan", "Koritarev", LocalDate.now(), "Informatics", "Mathematics");

        expect(courseMock.isDiscussionAllowed(student)).andReturn(true);
        replay(courseMock);


        assertEquals(discussion.startCourseDiscussion(courseMock, student, "Is Ronaldo the Goat?"), true);


        assertEquals(discussion.getCourse(), courseMock);

        assertEquals(discussion.getTopic(), "Is Ronaldo the Goat?");

    }

    // TODO implement the tests


}
