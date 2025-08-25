package de.tum.in.ase.eist;


import java.util.List;


public class LinearSearch implements SearchStrategy {

    public int performSearch(List<Chapter> book, String chapterName) {
        for (Chapter chapter : book) {
            if (chapter.getName().equals(chapterName)) {
                return chapter.getPageNumber();
            }
        }
        return -1;
    }
}
