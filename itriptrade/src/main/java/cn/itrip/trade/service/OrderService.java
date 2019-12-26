package cn.itrip.trade.service;

import cn.itrip.beans.pojo.ItripHotelOrder;

public interface OrderService {

    public ItripHotelOrder loadItripHotelOrder(String orderNo)throws Exception;

    public boolean processed(String orderNo)throws Exception;

    public void  paySuccess(String orderNo,Integer orderStatus,String tradeNo)throws Exception;
}
