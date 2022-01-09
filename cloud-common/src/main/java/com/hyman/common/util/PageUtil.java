package com.hyman.common.util;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hyman
 * @version 1.0
 * @date 2019/5/17 0017 上午 10:46
 */
public class PageUtil {

    /**
     * 根据总数计算总页数
     *
     * @param totalCount 总共的数据数
     * @param pageSize   每页展示的数据个数
     * @return 一共有多少页
     */
    public static int getTotalPage(int totalCount, int pageSize) {

        return cn.hutool.core.util.PageUtil.totalPage(totalCount, pageSize);

    }

    /**
     * 该集合进行分页的总页数
     *
     * @param collection 需要分页显示的集合
     * @param pageSize   每页展示的数据个数
     * @return 一共多少页
     */
    public static int getTotalPage(Collection collection, int pageSize) {

        return getTotalPage(collection.size(), pageSize);

    }


    public static <E> List<E> getPageData(List<E> list, int page, int pageSize) {

        int[] ints = transToStartEnd(list, page, pageSize);

        return list.stream().limit(ints[1]).skip(ints[0]).collect(Collectors.toList());
    }


    public static <E> Set<E> getPageData(Set<E> set, int page, int pageSize) {
        int[] ints = transToStartEnd(set, page, pageSize);

        return set.stream().limit(ints[1]).skip(ints[0]).collect(Collectors.toSet());
    }

    //
    private static int[] transToStartEnd(Collection collection, int page, int pageSize) {

        int size = collection.size();
        //总共分页数
        int totalPage = getTotalPage(collection, pageSize);
        if (page < 0) {
            page = 0;
        }

        if (page > totalPage) {
            page = totalPage;
        }
        int[] ints = cn.hutool.core.util.PageUtil.transToStartEnd(page, pageSize);
        int begin = ints[0];
        int end = ints[1];

        if (end > size) {
            end = size;
        }

        return new int[]{begin, end};

    }


}
