package main.com.java.array;

import org.apache.commons.collections.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具
 * @author yeshen.chen@tuya.com
 */
public class PageUtil {

    /**
     * 循环截取某页列表进行分页
     * @param dataList 分页数据
     * @param pageSize  页面大小
     * @param currentPage   当前页面
     */
    public static<T> List<T> page(List<T> dataList, int pageSize, int currentPage) {
        List<T> currentPageList = new ArrayList<>();
        if (dataList != null && dataList.size() > 0) {
            int currIdx = (currentPage > 1 ? (currentPage - 1) * pageSize : 0);
            for (int i = 0; i < pageSize && i < dataList.size() - currIdx; i++) {
                T data = dataList.get(currIdx + i);
                currentPageList.add(data);
            }
        }
        return currentPageList;
    }

    /**
     * 利用subList方法进行分页
     * @param list 分页数据
     * @param pageSize  页面大小
     * @param currentPage   当前页面
     */

    public static<T> List<T> pageBySubList(List<T> list, int pageSize, int currentPage) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        int totalCount = list.size();
        int pagecount = 0;
        List<T> subList;
        int m = totalCount % pageSize;
        if (m > 0) {
            pagecount = totalCount / pageSize + 1;
        } else {
            pagecount = totalCount / pageSize;
        }
        if (m == 0) {
            subList = list.subList((currentPage - 1) * pageSize, pageSize * (currentPage));
        } else {
            if (currentPage == pagecount) {
                subList = list.subList((currentPage - 1) * pageSize, totalCount);
            } else {
                subList = list.subList((currentPage - 1) * pageSize, pageSize * (currentPage));
            }
        }
        return subList;
    }
}
