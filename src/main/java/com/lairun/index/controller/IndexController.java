package com.lairun.index.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-11
 */
@RestController
public class IndexController {

    //@GetMapping("/")
    public String index() {
        return "this is index";
    }
}
