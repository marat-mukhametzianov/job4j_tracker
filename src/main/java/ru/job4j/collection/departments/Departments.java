package ru.job4j.collection.departments;

import java.util.*;

/**
 * The class provides sort methods, and a method filling gaps in the
 * raw initial list of departments.
 * @author Marat. M.
 * @version 1.0.
 */
public class Departments {

    /**
     * This method receives a raw list of departments. Then splits each row of the list by
     * the "/" sign. Afterward, it goes through the resulting String array, checking whether
     * the length of the resulting String array is 1 (only one element exists in the array),
     * and checking that the current index of the resulting array is not the first and the last.
     * If these three conditions are true then a final row uses slash, otherwise don't.
     * The final row is put into the intermediate resulting set in order to avoid duplicates.
     * Then this cycle is repeated for the next row of the initial raw list.
     * @param rawDepartments is a list of raw rows, and is going to be processed.
     * @return the processed initial list with no gaps.
     */
    public static List<String> fillGaps(List<String> rawDepartments) {
        final String slash = "/";
        Set<String> intermediateResult = new LinkedHashSet<>();
        for (String rawDepartment : rawDepartments) {
            String[] tempStore = rawDepartment.split("/");
            String loadedString = "";
            for (int i = 0; i < tempStore.length; i++) {
                loadedString = (tempStore.length != 1 && (i > 0 || i == tempStore.length - 1))
                        ?
                        loadedString + slash + tempStore[i]
                        :
                        loadedString + tempStore[i];
                intermediateResult.add(loadedString);
            }
        }
        return new ArrayList<>(intermediateResult);
    }

    /**
     * Sorting the received list in natural order.
     * @param orgs is the unsorted list of departments.
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
        for(String item : orgs) {
            System.out.println(item);
        }
    }

    /**
     * Sorting the received list in descending order, given that the first elements can be equal.
     * @param orgs is the unsorted list of departments.
     */
    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DescComparator());
        for(String item : orgs) {
            System.out.println(item);
        }
    }
}
