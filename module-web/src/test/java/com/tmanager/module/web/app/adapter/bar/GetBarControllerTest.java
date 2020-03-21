package com.tmanager.module.web.app.adapter.bar;

import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.application.bar.command.BarGetCommand;
import com.tmanager.module.application.bar.port.GetBarService;
import com.tmanager.module.exception.CustomException;

@RunWith(MockitoJUnitRunner.class)
public class GetBarControllerTest {

    @Mock
    private GetBarService getBarService;
    
	@Test
	public void getBarController() throws CustomException{
		
		Map<String, String> aux = new HashMap<String, String>();
		
		BarGetCommand command = new BarGetCommand("1", aux);
		
		getBarService.getBar(command); 

		verify(getBarService).getBar(command); 
	}
}
