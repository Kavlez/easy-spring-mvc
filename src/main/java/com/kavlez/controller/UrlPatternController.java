package com.kavlez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 */
@Controller
@RequestMapping("/urlPattern")
public class UrlPatternController {

    private static final String VIEW_DIR = "urlPattern";

    @RequestMapping
    public String main() {
        return VIEW_DIR.concat("/main");
    }

    /**
     * define variable in URL
     */
    @RequestMapping("/path/user/{username}")
    @ResponseBody
    public String path(@PathVariable String username) {
        return username;
    }

    /**
     * certainly supports multi path variable.
     */
    @RequestMapping("/auth/user/{username}/pass/{password}")
    @ResponseBody
    public String auth(@PathVariable String username, @PathVariable String password) {
        return "username=".concat(username).concat(":password=").concat(password);
    }

    /**
     * need more precision in defining URL? how about regexp?
     */
    @RequestMapping("/reg/{password:\\d{6}}")
    @ResponseBody
    public String reg(@PathVariable String password) {
        return "password=".concat(password);
    }

    /**
     * let's try matrix variable
     */
    @RequestMapping(value = "/matrix/{client}", method = RequestMethod.GET)
    @ResponseBody
    public String matrix(@PathVariable String client, @MatrixVariable String age) {
        return "client=".concat(client).concat(":age=").concat(age);
    }

    /**
     * without path variable? no problem!
     * height is an optional param.
     */
    @RequestMapping(value = "/matrix_/{client}", method = RequestMethod.GET)
    @ResponseBody
    public String matrix_(@MatrixVariable(value = "age", pathVar = "client") String age,
                          @MatrixVariable(value = "height", pathVar = "client", defaultValue = "180cm") String height) {
        return "client=".concat("####").concat(":age=").concat(age).concat(":height=").concat(height);
    }

    /**
     * Too many matrix params declared?
     * All matrix variables may be obtained in a map.
     */
    @RequestMapping(value = "/xirtam/{client}", method = RequestMethod.GET)
    @ResponseBody
    public String xirtam(@MatrixVariable(pathVar = "client") Map<String, String> matrixVarz) {
        return matrixVarz.toString();
    }

}