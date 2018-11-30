package com.itcast.controller;

import com.itcast.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/*
 * @Author:  Yajun_Xu
 * @Create: 2018/11/21 19:16
 **/
@Repository
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/body")
    public @ResponseBody
    User body(@RequestBody String body) {
        System.out.println (body);
        User user = new User ();
        user.setPassword ("123");
        user.setUsername ("张");
        return user;
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView ();
        User user = new User ();
        user.setUsername ("zhangsan");
        user.setPassword ("你好");
        modelAndView.addObject ("user", user);
        modelAndView.setViewName ("success");
        return modelAndView;
    }

    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request, MultipartFile upload) throws Exception {
        //上传的位置
        String path = request.getSession ().getServletContext ().getRealPath ("/uploads/");
        //判断文件夹是否存在
        File file = new File (path);
        if (!file.exists ()) {
            file.mkdirs ();
        }

        //获取上传文件的文件名
        String filename = upload.getOriginalFilename ();
        String uuid = UUID.randomUUID ().toString ().replace ("-", "");
        upload.transferTo (new File (path,filename));

        return "success";
    }
}
