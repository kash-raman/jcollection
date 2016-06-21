package edu.learn.collection.dup;

import edu.learn.exception.ComputationException;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by kash on 5/19/16.
 */
public class DeDup {
    private int[] randomArray;

    public DeDup(int[] intArray) {
        this.randomArray = intArray;
    }


    private static Logger log = Logger.getLogger(DeDup.class);

    /**
     * This is a simple looping using arrayList. Performance is a major factor here.
     * Add/remove operation in ArrayList takes O(n), which is more time than LinkedList O(1). Since agenda is to deDupe,
     * Set would be a better alternative due to no duplicate allowed.
     * ArrayList is not thread-safe and need to be synchriozed externally in multi thread application.
     *
     * @return Integer List
     * @throws ComputationException
     */
    public List removeDuplicate() throws ComputationException {
        log.debug("Removing duplicate using List......");
        List<Integer> uniqueList = new ArrayList();
        int[] intArray = getRandomArray();
        log.debug("Actual size of int array:" + intArray.length);
        log.debug(Arrays.toString(intArray));
        for (int i = 0; i < intArray.length; i++) {
            if (!isAdded(uniqueList, intArray[i])) {
                uniqueList.add(intArray[i]);
            }

        }
        log.debug("refined size of int array: " + uniqueList.size());
        log.debug(uniqueList.toString());
        return uniqueList;

    }

    /**
     * Set does not allow duplicate values.  HashSet is the fastest and
     * offers O(1) for add, contains and remove operations. HashSet does not maintain order of element
     * Set, in general, is not thread-safe and need to be synchriozed externally in multi thread application.
     *
     * @return Set
     * @throws ComputationException
     */
    public Set removeDuplicateUsingSet() throws ComputationException {
        Set<Integer> uniqueSet = new HashSet<>();
        log.debug("Removing duplicate using Set......");
        int[] intArray = getRandomArray();
        log.debug("Actual size of int array:" + intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            uniqueSet.add(intArray[i]);
        }
        log.debug("refined size of int array using Set: " + uniqueSet.size());
        log.debug(Arrays.toString(uniqueSet.toArray()));
        return uniqueSet;
    }

    /**
     * LinkedHashSet is implemented using HashSet and LinkedList. It does maintain order of element.
     * Offers O(1) for add, contains and remove operations. Due to usage of linkedList,
     * LinkedHashSet, need to maintain the 2 index for every add/delete. This makes it slower than HashSet.
     * Set, in general, is not thread-safe and need to be synchriozed externally in multi thread application.
     *
     * @return Set
     * @throws ComputationException
     */
    public Set removeDuplicateUsingLinkedHashSet() throws ComputationException {
        Set<Integer> uniqueSet = new LinkedHashSet<>();
        log.debug("Removing duplicate using Linked Hash Set......");
        int[] intArray = getRandomArray();
        log.debug("Actual size of int array:" + intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            uniqueSet.add(intArray[i]);
        }
        log.debug("refined size of int array using Set: " + uniqueSet.size());
        log.debug(Arrays.toString(uniqueSet.toArray()));
        return uniqueSet;
    }


    /**
     * When the resource for this class is not provided, the exception will be thrown.
     * Using DRY to reuse code.
     *
     * @return
     * @throws ComputationException
     */


    private int[] getRandomArray() throws ComputationException {
        if (randomArray == null || randomArray.length == 0) {
            throw new ComputationException("Unable to compute");
        }
        return randomArray;
    }


    private boolean isAdded(List<Integer> uniqueList, int randomInteger) {
        if (uniqueList.contains(randomInteger)) {
            return true;
        }
        return false;
    }


}
