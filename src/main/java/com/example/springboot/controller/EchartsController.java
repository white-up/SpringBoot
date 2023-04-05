package com.example.springboot.controller;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.example.springboot.common.Result;
import com.example.springboot.entity.News;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.hutool.http.HttpUtil;

import java.util.ArrayList;

@RestController
@RequestMapping("/echarts")
public class EchartsController {


    @GetMapping("/epidemic")
    public String epidemic() {
        return HttpUtil.get("https://c.m.163.com/ug/api/wuhan/app/data/list-total?t=" + System.currentTimeMillis());
    }
    @GetMapping("/tree")
    public String tree(){
        String t = HttpUtil.get("https://echarts.apache.org/examples/data/asset/data/flare.json");
        System.out.println(t);
        return t;
    }
    @GetMapping("/news")
    public Result<ArrayList<News>> news() {
        String response = HttpUtil.get("https://v.juhe.cn/toutiao/index?type=top&key=a1a755458cc22f129942b34904feb820");
        JSONObject jsonObjectResult = new JSONObject(response).getJSONObject("result");
        JSONArray jsonArray = jsonObjectResult.getJSONArray("data");
        ArrayList<News> datas = new ArrayList<>();
        for (int i = 0; i <jsonArray.size() ; i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            News data = new News();
            data.setTitle(item.getStr("title"));
            data.setData(item.getStr("date"));
            data.setCategory(item.getStr("category"));
            data.setAuthor_name(item.getStr("author_name"));
            datas.add(data);
        }

        return Result.success(datas);
    }



}