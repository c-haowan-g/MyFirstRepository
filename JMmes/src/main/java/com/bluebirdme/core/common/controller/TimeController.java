package com.bluebirdme.core.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.NoLogin;

/**
 * 
 * @author Goofy
 * @Date 2019年4月21日 下午6:00:11
 */
@RestController
@RequestMapping("/time.js")
public class TimeController {
	
	@NoLogin
	@RequestMapping(method=RequestMethod.GET)
	public String time(){
		return "var server_time="+System.currentTimeMillis()+";\nsetInterval(function(){ server_time+=1000;},1000);";
	}

}
