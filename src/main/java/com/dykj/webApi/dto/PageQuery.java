package com.dykj.webApi.dto;

/**
 * 分页参数
 */
public class PageQuery {

    private int pageNo = 1;

    private int pageSize = 10;

    private int endRecode;

    private int beginRecode;

    public int getBeginRecode() {
        return (pageNo - 1) * pageSize;
    }

    public int getEndRecode() {
        return pageNo * pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setEndRecode(int endRecode) {
        this.endRecode = endRecode;
    }

    public void setBeginRecode(int beginRecode) {
        this.beginRecode = beginRecode;
    }
}
