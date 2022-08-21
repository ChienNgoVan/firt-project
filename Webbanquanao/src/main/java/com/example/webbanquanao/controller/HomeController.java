package com.example.webbanquanao.controller;

import com.example.webbanquanao.utils.DbUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"home", ""})
    public String home(Model model) {
        model.addAttribute("list", DbUtil.danhSachSanPham());
        return "home";
    }

    @RequestMapping("product")
    public String productList()  { return "index/product-list"; }

    @RequestMapping("productdtl")
    public String productDetail(){ return "index/product-detail"; }

    @RequestMapping("cart")
    public String cart(){ return "index/cart"; }

    @RequestMapping("checkout")
    public String checkout(){ return "index/checkout"; }

    @RequestMapping("myaccount")
    public String myaccount(){ return "index/myaccount"; }
}
