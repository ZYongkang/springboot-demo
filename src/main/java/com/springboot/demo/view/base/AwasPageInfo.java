package com.springboot.demo.view.base;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

/**
 * 针对前端的翻页对象
 * @Author wangchungang@artspring.com.cn
 */
public class AwasPageInfo {

    private Integer pageNum;
    private Integer pageSize;
    private Integer size;
    private Integer startRow;
    private Integer endRow;
    private Integer pages;
    private Integer prePage;
    private Long total;

    /**
     * 默认构造函数
     */
    public AwasPageInfo(){
        super();
    }

    /**
     * 自定义构造函数
     * @param size
     * @param total
     * @param pageNum
     * @param pageSize
     */
    public AwasPageInfo(int size, long total, int pageNum, int pageSize){
        super();

        this.setSize(size);
        this.setTotal(total);
        this.setPageNum(pageNum);
        this.setPrePage(pageNum-1);
        this.setPageSize(pageSize);
        this.setStartRow((pageNum-1)*pageSize);
        int endRow = size==pageSize ? pageNum*pageSize : (pageNum-1)*pageSize+size;
        this.setEndRow(endRow);
        long pages = total%pageSize==0 ? total/pageSize : total/pageSize+1;
        this.setPages((int) pages);
    }

    /**
     * 构造函数，基于底层翻页对象构造
     * @param pageInfo
     */
    public AwasPageInfo(PageInfo pageInfo){
        super();

        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.size = pageInfo.getSize();
        this.startRow = pageInfo.getStartRow();
        this.endRow = pageInfo.getEndRow();
        this.pages = pageInfo.getPages();
        this.prePage = pageInfo.getPrePage();
        this.total = pageInfo.getTotal();
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 对象转JSON
     * @return
     */
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        if(pageNum!=null) jsonObject.put("page_num", pageNum);
        if(pageSize!=null) jsonObject.put("page_size", pageSize);
        if(size!=null) jsonObject.put("size", size);
        if(startRow!=null) jsonObject.put("start_row", startRow);
        if(endRow!=null) jsonObject.put("end_row", endRow);
        if(pages!=null) jsonObject.put("pages", pages);
        if(prePage!=null) jsonObject.put("pre_page", prePage);
        if(total!=null) jsonObject.put("total", total);
        return jsonObject;
    }

    @Override
    public String toString() {
        return "AwasPageInfo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", size=" + size +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                ", pages=" + pages +
                ", prePage=" + prePage +
                ", total=" + total +
                '}';
    }
}
