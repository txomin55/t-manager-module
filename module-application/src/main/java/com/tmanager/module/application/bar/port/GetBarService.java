package com.tmanager.module.application.bar.port;

import com.tmanager.module.application.bar.command.BarGetCommand;
import com.tmanager.module.application.bar.dto.BarDTO;
import com.tmanager.module.exception.CustomException;

public interface GetBarService {

	BarDTO getBar(BarGetCommand command) throws CustomException;
}
