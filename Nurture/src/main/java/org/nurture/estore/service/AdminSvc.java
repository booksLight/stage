package org.nurture.estore.service;

import java.util.List;

import org.nurture.estore.vo.OrderMapper;

public interface AdminSvc {

	List<OrderMapper> getOrdersRowMapper();
}
