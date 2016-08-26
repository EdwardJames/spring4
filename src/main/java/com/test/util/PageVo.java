package com.test.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * 
 * @author yuhaibin
 * 
 */
public class PageVo<E> implements Serializable
{

    private static final long serialVersionUID = -4861421206255705029L;

    private static int DEFAULT_PAGE_SIZE = 20; // 默认分页记录数
    private int recordCount; // 总记录数
    private int pageSize; // 页面记录条数
    private int pageCount; // 总页数
    private int currentPage; // 当前页码
    //private String condition; // 分页条件
    private String orderby; // 排序值
    private int ascORdesc; // 升序降序 0 升序 1 降序
    private List<E> voList; // 数据记录List

    public PageVo()
    {
        recordCount = -1;
        pageCount = -1;
        
        pageSize = DEFAULT_PAGE_SIZE;
        currentPage = -1;
    }

    public int getAscORdesc()
    {
        return ascORdesc;
    }

    /**
     * 升序降序 <BR>
     * 0:升序<BR>
     * 1:降序
     * 
     * @param ascORdesc
     */
    public void setAscORdesc(int ascORdesc)
    {
        this.ascORdesc = ascORdesc;
    }

    public List<E> getVoList()
    {
        return voList;
    }

    /**
     * 
     * @return 分页条件. where 语句的标准sql条件  <BR>例如:    username='admin' and pwd='123456' 条件前后trim空格 
     * @created 2012-9-13 上午10:26:22
     */
//    public String getCondition()
//    {
//        return condition;
//    }

    /**
     * 分页条件. where 语句的标准sql条件  <BR>例如:    username='admin' and pwd='123456' 条件前后trim空格 
     * @param condition
     */
//    public void setCondition(String condition)
//    {
//        this.condition = condition;
//    }

    /**
     * 
     * @return 排序值   <br>例如:排序字段  userage|userlevel   表示userage第一排序,userlevel第二排序
     * @created 2012-9-13 上午10:26:11
     */
    public String getOrderby()
    {
        return orderby;
    }

    /**
     * 排序值   
     * @param orderby 排序值   <br>例如:排序字段  userage|userlevel   表示userage第一排序,userlevel第二排序
     * @created 2012-9-13 上午10:24:37
     */
    public void setOrderby(String orderby)
    {
        this.orderby = orderby;
    }

    public void setVoList(List<E> voList)
    {
        this.voList = voList;
    }

    /**
     * @return 当前页码
     */
    public int getCurrentPage()
    {
        return currentPage;
    }

    /**
     * 设置所需的页码
     * 
     * @param currentPage
     *            页码。第一页就是1，第二页就是2
     */
    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getPageCount()
    {
        return pageCount;
    }

    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }

    public int getPageSize()
    {
        return pageSize < 1 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getRecordCount()
    {
        return recordCount;
    }

    public void setRecordCount(int recordCount)
    {
        this.recordCount = recordCount;
    }

    public void rePageCount()
    {
        if (pageSize * (currentPage - 1) > recordCount)
            setCurrentPage((int) Math.ceil((double) recordCount / (double) pageSize));
        if (pageSize == 0)
            setPageSize(DEFAULT_PAGE_SIZE);
        setPageCount((int) Math.ceil((double) recordCount / (double) pageSize));
    }
}
