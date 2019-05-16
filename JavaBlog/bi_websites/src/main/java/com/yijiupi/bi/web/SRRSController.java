package com.yijiupi.bi.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Decription: SSRS controller
 * @Author: Huang Yuansheng
 * @Date: Create in 9:07 2018/8/2 0002
 * @Email: huangyuansheng@yijiupi.cn
 **/
@Controller
@RequestMapping("/ssrs")
public class SRRSController extends BaseController {
	
	@Value("${yjp.ssrsBi.serverUrl}")
	private String serverUrl;
	
	@ResponseBody
	@RequestMapping("serverUrl")
	public String getServerUrl() {
		return serverUrl;
	}
}
