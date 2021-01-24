package ru.job4j.lambda.attachment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * The class realizes two logic options of a comparator. The first option sorts an array of the
 * Attachment instances by theirs size, second one - by theirs names.
 * @author Marat. M.
 * @version 1.0.
 */
public class AttachmentSort {
    /**
     * This method creates the "size" comparator, pass it to the output method,
     * then override the comparator as a "name" one, and pass it again.
     * @param args is an array of the command line parameters.
     */
    public static void main(String[] args) {
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        output(comparator, "Sorted by sizes:");
        comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        output(comparator, "Sorted by names:");
    }

    /**
     * The method receives the comparator, and a prompt. Creates a list, sorts the list using the
     * comparator, and prints the sorted list.
     * @param comparator is an instance of the anonymous class, that can have two options.
     * @param prompt is a string to be a caption.
     */
    private static void output(Comparator comparator, String prompt) {
        List<Attachment> attachments = List.of(
                new Attachment("image_1", 100),
                new Attachment("image_2", 34),
                new Attachment("image_3", 13)
        );
        attachments.sort(comparator);
        System.out.println(prompt);
        for (Attachment item : attachments) {
            System.out.println(item);
        }
    }
}
