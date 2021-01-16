package ru.job4j.lambda.attachment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment attachment : list) {
            if (attachment.getSize() > 100) {
                result.add(attachment);
            }
        }
        return result;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment attachment : list) {
            if (attachment.getName().contains("bug")) {
                result.add(attachment);
            }
        }
        return result;
    }

    public static List<Attachment> universalFilter(
            List<Attachment> initialList,
            Function <List<Attachment>, List<Attachment>> action) {
        return action.apply(initialList);
    }

    public static List<Attachment> simpleFilter(
            List<Attachment> initialList,
            Function <List<Attachment>, List<Attachment>> action) {
        return action.apply(initialList);
    }
}
