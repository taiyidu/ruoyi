package com.sky.common.utils;

import com.github.pagehelper.PageHelper;
import com.sky.common.core.page.PageDomain;
import com.sky.common.core.page.TableSupport;
import com.sky.common.utils.sql.SqlUtil;

/**
 * 分页工具类
 * 
 * @author ruoyi
 */
public class PageUtils extends PageHelper
{
    /**
     * 设置请求分页数据
     */
    public static void startPage()
    {
        //创建一个pageDomain对象,用于接收分页参数
        PageDomain pageDomain = TableSupport.buildPageRequest();
        //从pageDomain对象中获取分页参数
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        //对排序条件进行转义处理防止sql注入
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        Boolean reasonable = pageDomain.getReasonable();
        //使用pageHelper分页开启分页，设置页码，每页大小，排序条件是否合理分页
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage()
    {
        PageHelper.clearPage();
    }
}
