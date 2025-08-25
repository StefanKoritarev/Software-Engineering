package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class OnlineCourseTest {
    /*setOnlineCourseUrl(String) in OnlineCourse updates the course URL with a given string.
     It will throw an MalformedURLException if the URL is not valid.

    Add a new test case testSetOnlineCourseUrlWithValidUrl() in OnlineCourseTest.
     It should set a valid URL using setUrl() and afterwards check if getUrl() returns the correct URL object.
    Add a new test case testSetOnlineCourseUrlWithInvalidUrl() in OnlineCourseTest.
     It should set an invalid URL using setUrl() and test if the MalformedURLException is thrown.*/

	// TODO 3: Test setOnlineCourseUrl()
    @Test
    void testSetOnlineCourseUrlWithValidUrl() throws MalformedURLException {
        OnlineCourse valid = new OnlineCourse("Botev Plovdiv");
        URL url = new URL("https://botevplovdiv.bg");
        valid.setUrl("https://botevplovdiv.bg");
        assertEquals(valid.getUrl(), url);

    }

    @Test
    void testSetOnlineCourseUrlWithInvalidUrl() throws MalformedURLException {
        OnlineCourse invalid = new OnlineCourse("Loko Plovdiv");
        assertThrows(MalformedURLException.class, () -> {
            invalid.setUrl("nai tupiq otbor");
        });
    }
}
