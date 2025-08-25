package de.tum.in.ase.eist;


import java.util.List;

public class BinarySearch implements SearchStrategy {
    public int performSearch(List<Chapter> book, String chapterName) {
        int left = 0;
        int right = book.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Chapter chapter = book.get(mid);
            int result = chapter.getName().compareTo(chapterName);

            if (result == 0) {
                return chapter.getPageNumber();
            } else if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
