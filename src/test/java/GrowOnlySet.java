import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrowOnlySet {

    List elements = new LinkedList();

    void add(String element) {
        if(elements.contains(element))
            return;
        elements.add(element);
    }

    boolean contains(String element) {
        for(Object e : elements)
            if(e.equals(element))
                return true;
        return false;
    }

    int size() {
        int size = 0;
        for(Object e : elements)
            size++;
        return size;
    }

    GrowOnlySet set;

    @BeforeEach
    void setUp() {
        set = new GrowOnlySet();
    }

    @Test
    void canAddElementToTheSet() {
        set.add("Element");
        assertTrue(set.contains("Element"));
    }

    @Test
    void setContainsNoElementThatWasNotAdded() {
        assertFalse(set.contains("Not extisting element"));
    }

    @Test
    void containsDetectsTwoEqualObject() {
        set.add("Element");
        assertTrue(set.contains("Element"));
    }

    @Test
    void containsReturnsFalseForNull() {
        set.add("Element");
        assertFalse(set.contains(null));
    }

    @Test
    void containsReturnsFalseOnEmptySet() {
        assertFalse(set.contains("Element"));
    }

    @Test
    void addingSameElementTwice_onlyOneIsAdded() {
        set.add("Element");
        set.add("Element");
        assertEquals(1, set.size());
    }

    /* Testlist:

    Adding null does not work

     */
}
