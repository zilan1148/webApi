package com.dykj.webApi.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果集
 * @param <T>
 */
public class PageResult<T> {

    private List<T> data = new ArrayList<>();

    private long total = 0;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}