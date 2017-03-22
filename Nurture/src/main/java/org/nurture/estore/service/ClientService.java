package org.nurture.estore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.nurture.estore.model.Client;

public interface ClientService {
	Page<Client> getClientsByPage(Pageable pageable);
}
