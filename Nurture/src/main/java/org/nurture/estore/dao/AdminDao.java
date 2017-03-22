package org.nurture.estore.dao;

import java.util.List;

import org.nurture.estore.vo.OrderMapper;

public interface AdminDao {

	List<OrderMapper> getOrdersRowMapper();
	
}
