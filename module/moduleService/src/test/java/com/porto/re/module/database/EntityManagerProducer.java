package com.porto.re.module.database;


import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.porto.re.module.business.database.ReModuleProviderDatabase;

public class EntityManagerProducer {

	@Produces @ReModuleProviderDatabase
    @PersistenceContext(unitName = "pu-innovare")
    private EntityManager entityManagerDefault;

}
