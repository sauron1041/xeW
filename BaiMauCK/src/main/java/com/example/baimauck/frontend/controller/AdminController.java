package com.example.baimauck.frontend.controller;

import com.example.baimauck.backend.models.LoaiXe;
import com.example.baimauck.backend.models.Xe;
import com.example.baimauck.backend.services.LoaiXeService;
import com.example.baimauck.backend.services.XeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private XeService xeService;

    @Autowired
    private LoaiXeService loaiXeService;
    @GetMapping("")
    public String showHome(Model model){
        return "home";
    }

    @GetMapping("/listCar")
    public String showListCar(Model model){
        List<Xe> xeList = xeService.findAll();
        model.addAttribute("xeList", xeList);
        return "listcar";
    }
    //    load danh sach loai xe
    @GetMapping("/listCategoryCar")
    public String showCategoryCar(Model model){
        List<LoaiXe> loaiXeList = loaiXeService.findAll();
        model.addAttribute("loaiXeList", loaiXeList);
        return "listcatecar";
    }



    @GetMapping("/listCarByCateCar")
    public String showSelCateCar(Model model, HttpSession session){
        List<LoaiXe> loaiXeList = loaiXeService.findAll();
        model.addAttribute("loaiXeList", loaiXeList);
        return "listCarByCategory";
    }


    @GetMapping("/selCategory")
    public String showListCarByCateCar(Model model, HttpSession session, HttpServletRequest request){
        List<LoaiXe> loaiXeList = loaiXeService.findAll();
        model.addAttribute("loaiXeList", loaiXeList);
        Long maLoai = Long.valueOf(request.getParameter("selCate"));
        List<Xe> xeList = xeService.findByCategory(maLoai);
        model.addAttribute("xeList",xeList);
        return "listCarByCategory";
    }


    @GetMapping("/addCar")
    public String showFromAddCar(Model model){
        Xe xe = new Xe();
        model.addAttribute("xe", xe);
        List<LoaiXe> loaiXeList = loaiXeService.findAll();
        model.addAttribute("loaiXeList", loaiXeList);
        return "addCar";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute("xe") Xe xe){
        xeService.addCar(xe);
        return "redirect:/admin/listCar";
    }

    @GetMapping("/deleteCar/{maXe}")
    public String deleteCar(@PathVariable("maXe") Long id){
        xeService.delCar(id);
        return "redirect:/admin/listCar";
    }

}
