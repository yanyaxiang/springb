package com.yyx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "/pages/index";
	}

	@RequestMapping("/tables.do")
	public String tables() {
		return "/pages/tables";
	}

	@RequestMapping("/tougu/list.do")
	@ResponseBody
	public Object touguList(@RequestParam Map<String, Object> param) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
//		if(param.get("start").equals("10")) {
		if(param.get("iDisplayStart").equals("10")) {
			map = new HashMap<String, Object>();
			map.put("name", "张11");
			map.put("age", "11");
			map.put("sex", "女");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张12");
			map.put("age", "12");
			map.put("sex", "男");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张13");
			map.put("age", "13");
			map.put("sex", "女");
			list.add(map);
		} else {
			map = new HashMap<String, Object>();
			map.put("name", "张1");
			map.put("age", "1");
			map.put("sex", "男");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张2");
			map.put("age", "2");
			map.put("sex", "男");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张3");
			map.put("age", "3");
			map.put("sex", "男");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张4");
			map.put("age", "4");
			map.put("sex", "女");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张5");
			map.put("age", "5");
			map.put("sex", "女");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张6");
			map.put("age", "6");
			map.put("sex", "男");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张7");
			map.put("age", "7");
			map.put("sex", "女");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张8");
			map.put("age", "8");
			map.put("sex", "男");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张9");
			map.put("age", "9");
			map.put("sex", "女");
			list.add(map);
			map = new HashMap<String, Object>();
			map.put("name", "张10");
			map.put("age", "10");
			map.put("sex", "男");
			list.add(map);
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("draw", Integer.parseInt(param.get("draw").toString()));
//		data.put("recordsTotal", 13);
//		data.put("recordsFiltered", 13);
		data.put("sEcho", Integer.parseInt(param.get("sEcho").toString()));
		data.put("data", list);
		return data;
	}

}
