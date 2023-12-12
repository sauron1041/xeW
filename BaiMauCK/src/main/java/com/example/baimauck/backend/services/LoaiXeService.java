package com.example.baimauck.backend.services;

import com.example.baimauck.backend.models.LoaiXe;
import com.example.baimauck.backend.models.Xe;
import com.example.baimauck.backend.reponsitories.LoaiXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiXeService {

    @Autowired
    private LoaiXeRepository loaiXeRepository;

    public List<LoaiXe> findAll(){
        return loaiXeRepository.findAll();
    }
}
