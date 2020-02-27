package com.tmanager.module.domain.bar.port;

import com.tmanager.module.domain.bar.model.Bar;

public interface GetBarPersistancePort {

	Bar getBar(String id);
}
