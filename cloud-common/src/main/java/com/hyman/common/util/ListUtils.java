package com.hyman.common.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static<T> List<List<T>> batchList(List<T> sourceList, int batchCount) {
        List<List<T>> returnList = new ArrayList<>();
        int startIndex = 0; // 从第0个下标开始
        while (startIndex < sourceList.size()) {
            int endIndex = 0;
            if (sourceList.size() - batchCount < startIndex) {
                endIndex = sourceList.size();
            } else {
                endIndex = startIndex + batchCount;
            }
            returnList.add(sourceList.subList(startIndex, endIndex));
            startIndex = startIndex + batchCount; // 下一批
        }
        return returnList;
    }
}
