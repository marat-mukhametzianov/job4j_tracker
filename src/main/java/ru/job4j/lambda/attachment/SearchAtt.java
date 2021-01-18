package ru.job4j.lambda.attachment;

import ru.job4j.lambda.attachment.Attachment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return universalFilter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return universalFilter(list, predicate);
    }

    public static List<Attachment> universalFilter(
            List<Attachment> attachments,
            Predicate<Attachment> predicate
    ) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment attachment : attachments) {
            if (predicate.test(attachment)) {
                result.add(attachment);
            }
        }
        return result;
    }
}
