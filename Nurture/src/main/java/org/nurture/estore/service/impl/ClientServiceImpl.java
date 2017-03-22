package org.nurture.estore.service.impl;

import org.nurture.estore.dao.ClientDao;
import org.nurture.estore.model.Client;
import org.nurture.estore.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	 @Autowired
	 private ClientDao clientDao;
	 
	public Page<Client> getClientsByPage(Pageable pageable) {
		svcLog(this.getClass(), "getClientsByPage", "START");
		
			return clientDao.findAll(pageable);
	}

	
	
	private void svcLog(Class<? extends ClientServiceImpl> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
		
	}
}
