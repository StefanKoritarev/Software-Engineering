package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;

public class Context {

    private SearchStrategy searchAlgorithm;
    private List<Chapter> book = new ArrayList<>();

    public int search(String chapterName) {
        return searchAlgorithm.performSearch(book, chapterName);
    }

    public boolean isChaptersSortedByName() {
        int size = book.size();
        for (int i = 0; i < size - 1; i++) {
            Chapter currChapter = book.get(i);
            Chapter nextChapter = book.get(i + 1);
            if (currChapter.getName().compareTo(nextChapter.getName()) > 0) {
                return false;
            }
        }
        return true;
    }


    public List<Chapter> getBook() {
        return book;
    }

    public void setBook(List<Chapter> book) {
        this.book = book;
    }

    public void setSearchAlgorithm(SearchStrategy searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    public SearchStrategy getSearchAlgorithm() {
        return searchAlgorithm;
    }
}
