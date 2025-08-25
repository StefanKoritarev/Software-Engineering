package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class OnlineCourseTest {

    // TODO 3: Test setOnlineCourseUrl()

    @Test
    void testSetOnlineCourseUrlWithValidUrl() throws MalformedURLException {

        OnlineCourse programming = new OnlineCourse("softUni");
        URL url = new URL("https://softuni.bg/");
        programming.setUrl("https://softuni.bg/");
        assertEquals(programming.getUrl(), url);
    }

    @Test
    void testSetOnlineCourseUrlWithInvalidUrl() throws MalformedURLException {
        OnlineCourse programming = new OnlineCourse("SUI");
        String invalidUrl = "twict.bg";
        assertThrows(MalformedURLException.class, () -> {
            programming.setUrl(invalidUrl);
        });
    }
}
