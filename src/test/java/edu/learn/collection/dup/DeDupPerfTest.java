package edu.learn.collection.dup;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by kash on 5/19/16.
 */
public class DeDupPerfTest {
    private DeDup deDup;
    private int[] negativeValduplicate = {-1, 1, 2, 1, -1, -2};
    int actual = 4;

    @Test
    public void testPerf1() throws Exception {
        deDup = new DeDup(negativeValduplicate);

        List response = deDup.removeDuplicate();
        Assert.assertEquals(response.size(), actual, "Expect duplicate array size equal to actual list response");
    }

    @Test
    public void testPerf2() throws Exception {
        deDup = new DeDup(negativeValduplicate);

        Set responseSet = deDup.removeDuplicateUsingSet();
        Assert.assertEquals(responseSet.size(), actual, "Expect duplicate array size equal to actual set response");
    }

    @Test
    public void testPerf3() throws Exception {
        deDup = new DeDup(negativeValduplicate);
        Set sortedSet = deDup.removeDuplicateUsingLinkedHashSet();
        Assert.assertEquals(sortedSet.size(), actual, "Expect duplicate array size equal to actual concurrent set response");
        Integer lastItem = ((Integer) sortedSet.toArray()[sortedSet.size() - 1]);
        Assert.assertTrue(lastItem.equals(-2));
    }

}
