package com.example.demo.entity;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/12/7
 * Time: 10:28
 * Description: 封装分页相关信息
 */
public class Page {


    private int current = 1;

    private int limit = 10;

    //数据总数
    private int rows;

    //查询路径
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //获取当前页面起始行
    public int getOffset() {
        // current * limit -limit
        return (current - 1) * limit;
    }

    //获取总的页数
    public int getTotal() {
        //rows / limit +1
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * @Description: 获取起始页码
     * @Author: LiXin
     * @Date: 2021/12/7 10:44
     * @Param []
     * @Return int
     **/
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * @Description:获取结束页码 [5, 6, 7, 8, 9]
     * @Author: LiXin
     * @Date: 2021/12/7 10:44
     * @Param []
     * @Return int
     **/
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}
