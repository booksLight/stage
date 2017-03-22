package org.nurture.estore.service.impl;

import java.util.List;

import org.nurture.estore.dao.AdminDao;
import org.nurture.estore.service.AdminSvc;
import org.nurture.estore.vo.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminSvcImpl implements AdminSvc {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminSvcImpl.class);

	 @Autowired
	 private AdminDao adminDao;
	 
	public List<OrderMapper> getOrdersRowMapper() {
		svcAdminLog(this.getClass(), "getOrdersRowMapper", "START");
		return adminDao.getOrdersRowMapper();
	}

	
	 
    private void svcAdminLog(Class<? extends AdminSvcImpl> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
	}
}
