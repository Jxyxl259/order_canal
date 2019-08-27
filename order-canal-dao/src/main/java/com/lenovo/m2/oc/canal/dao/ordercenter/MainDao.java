package com.lenovo.m2.oc.canal.dao.ordercenter;

import com.lenovo.m2.arch.framework.domain.PageModel;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.oc.canal.domain.ordercenter.Main;
import com.lenovo.m2.oc.canal.domain.report.OrderFreightVo;
import com.lenovo.m2.oc.canal.domain.report.OrdersReportVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by jh on 2016/6/29.
 */
public interface MainDao {

    /**
     * 动态查询sql
     * @param conditions
     * @return
     */
    List<Main> getMainByMap(@Param("conditions") Map<String, Object> conditions);


    /**MainMapper.xml
     * OrderMain信息分页查询
     *
     * @param pageQuery
     * @param conditions
     * @return
     */
    PageModel<Main> getOrderMainPage(PageQuery pageQuery, @Param("conditions") Map conditions);

    /**
     * main单表查询
     *
     * @param pageQuery
     * @param conditions
     * @return
     */
    PageModel<Main> getCheckMainPage(PageQuery pageQuery, @Param("conditions") Map conditions);

    Main getMainById(@Param("Id") long Id);

    /**
     * 更新订单状态
     * @param
     * @return
     */
    int updateStatus(@Param("orderId") String orderId, @Param("status") String status, @Param("updateBy") String updateBy);
    /**
     * 更新支付状态
     * @param main
     * @return
     */
    int updatePayStatus(Main main);
    int updatePayStatus(@Param("id") String orderId, @Param("payStatus") String status, @Param("updateBy") String updateBy);


    int updateStatusAndPayStatus(@Param("id") long orderId, @Param("status") String status, @Param("payStatus") String payStatus, @Param("updateBy") String updateBy);

    /**
     * 添加客户经理
     * @param customerManagerCode
     * @param orderId
     * @param updateBy
     * @return
     */
    int updateCustomerManagerCodeById(@Param("customerManagerCode") String customerManagerCode, @Param("orderId") String orderId, @Param("updateBy") String updateBy);

    /**
     * 订单报表 分页查询
     * @param pageQuery
     * @param map
     * @return
     */
    PageModel<OrdersReportVo> getOrderReportPage(PageQuery pageQuery, @Param("conditions") Map<String, Object> map);

    List<OrdersReportVo> getOrderReportForPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("conditions") Map<String, Object> map);


    List<OrdersReportVo> getOrderReportLists(@Param("ids") List<String> ids, @Param("type") int type);

    int updatePaymentTypeAndPayStatus(@Param("payment") String payment, @Param("systemRemark") String systemRemark, @Param("updateBy") String updateBy, @Param("orderId") String orderId);

    int updateLockedByOutId(@Param("outId") String outId, @Param("systemRemark") String sysRemark, @Param("updateBy") String updateBy, @Param("locked") boolean isLocked);

    int updateLocked(@Param("orderId") String outId, @Param("systemRemark") String sysRemark, @Param("updateBy") String updateBy, @Param("locked") boolean isLocked);

    String findSysRemarkByOutId(String outId);

    int updateMainPrice(@Param("conditions") Map<String, Object> map);

    /**
     * 根据订单号，查询系统备注，进行拼接操作
     * @param orderId
     * @return
     */
    String findSysRemarkById(Long orderId);


    Main  getMainByOutId(String outId);


    Main getTenantByOrderId(@Param("orderId") long orderId);

    int updateOutIdByOrderId(@Param("orderId") String orderId, @Param("outId") String outId, @Param("updateBy") String updateBy);

    List<Main> getHsOrderInfoByParentId(@Param("parentId") long parentId);

    /**
     * 查询 某时间段内 lenovoId的正向订单数量
     * @param lenovoId
     * @param starTime
     * @param endTime
     * @return
     */
    List<Main> findOrderByLenovoId(@Param("lenovoId") String lenovoId, @Param("startTime") String starTime, @Param("endTime") String endTime);



    /**
     * 查询OTO订单列表
     * @param pageQuery
     * @param conditionMap
     * @return
     */
    PageModel<Main> getScmpurchaseList(PageQuery pageQuery, @Param("conditions") Map conditionMap);

    /**
     * 查询OTO订单备注
     * @param orderId
     * @return
     */
    Main getScmpurchaseRemark(@Param("orderId") long orderId);

    /**
     * 保存OTO订单备注
     * @param orderId
     * @param remark
     * @return
     */
    int insertScmpurchaseRemark(@Param("orderId") long orderId, @Param("remark") String remark);

    /**
     *
     * @param orderId
     * @param otoConfirmStatus
     * @param updateBy
     * @return
     */
    int updateOtoConfirmStatus(@Param("id") long orderId, @Param("otoConfirmStatus") String otoConfirmStatus, @Param("updateBy") String updateBy);

    /**
     * 更新签收状态,签收时间
     *
     * @param main
     * @return
     */
    int updateSignStatus(Main main);

    /**
     * 虚拟币运费报表
     * @param pageQuery
     * @param conditionMap
     * @return
     */
    PageModel<OrderFreightVo> getOrderFreightReport(PageQuery pageQuery, @Param("conditions") Map conditionMap);

    Long getOrderFreightReportTotal(@Param("conditions") Map conditionMap);



}
