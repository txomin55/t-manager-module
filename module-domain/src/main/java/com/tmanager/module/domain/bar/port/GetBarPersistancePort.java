package com.tmanager.module.domain.bar.port;

import java.util.Map;

import com.tmanager.module.domain.bar.model.Bar;

public interface GetBarPersistancePort {

	Bar getBar(String id, Map<String, String> aux);
}
