package cn.itrip.trade.service;

import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.dao.hotelorder.ItripHotelOrderMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private Logger logger=Logger.getLogger(OrderServiceImpl.class);

    @Resource
    private ItripHotelOrderMapper itripHotelOrderMapper;

    //加载酒店订单
    @Override
    public ItripHotelOrder loadItripHotelOrder(String orderNo) throws Exception {
        logger.debug("加载订单：" + orderNo);
        Map<String, Object> param = new HashMap();
        param.put("orderNo", orderNo);
        List<ItripHotelOrder> orders = itripHotelOrderMapper.getItripHotelOrderListByMap(param);
        if (orders.size() == 1) {
            return orders.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean processed(String orderNo) throws Exception {
        Map<String, Object> param = new HashMap();
        param.put("orderNo", orderNo);
        List<ItripHotelOrder> orders = itripHotelOrderMapper.getItripHotelOrderListByMap(param);
        if (orders.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void paySuccess(String orderNo, Integer orderStatus, String tradeNo) throws Exception {
        ItripHotelOrder itripHotelOrder=new ItripHotelOrder();
        itripHotelOrder.setOrderNo(orderNo);
        itripHotelOrder.setOrderStatus(orderStatus);
        itripHotelOrder.setTradeNo(tradeNo);
        int num=itripHotelOrderMapper.updateItripHotelOrder(itripHotelOrder);
        System.out.println("num="+num);
    }
}
