package com.tmanager.module.application.bar.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.bar.command.BarGetCommand;
import com.tmanager.module.application.bar.dto.BarDTO;
import com.tmanager.module.application.bar.port.GetBarService;
import com.tmanager.module.domain.bar.model.Bar;
import com.tmanager.module.domain.bar.port.GetBarPersistancePort;
import com.tmanager.module.exception.CustomException;
import com.tmanager.module.exception.error.ErrorEnum;

public class GetBarServiceAdapter implements GetBarService {

	private GetBarPersistancePort getBarPersistancePort;

	@Autowired
	public GetBarServiceAdapter(GetBarPersistancePort getBarPersistancePort) {
		this.getBarPersistancePort = getBarPersistancePort;
	}

	@Override
	public BarDTO getBar(BarGetCommand command) throws CustomException {
				
		Bar bar = getBarPersistancePort.getBar(command.getId(), command.getAux());
		
		if(bar == null) {
			throw new CustomException(ErrorEnum.UNAUTHORIZED_RESOURCE_ERROR);
		}
		
		return new BarDTO(bar.getId(), bar.getName()); 
	}
}
