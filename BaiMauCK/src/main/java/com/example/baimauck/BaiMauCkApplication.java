package com.example.baimauck;

import com.example.baimauck.backend.models.LoaiXe;
import com.example.baimauck.backend.models.Xe;
import com.example.baimauck.backend.reponsitories.LoaiXeRepository;
import com.example.baimauck.backend.reponsitories.XeRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BaiMauCkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaiMauCkApplication.class, args);
    }

    @Autowired
    private LoaiXeRepository loaiXeRepository;

    @Autowired
    private XeRepository xeRepository;

    @Bean
    CommandLineRunner createData(){
        return  args -> {
            Faker faker = new Faker();
            for (int i = 0; i <3;i++){
                String tenLoai = faker.brand().car();
                LoaiXe loaiXe = new LoaiXe(tenLoai);
                loaiXeRepository.save(loaiXe);

                String tenXe = faker.brand().car() +" "+ i;
                String gia = faker.commerce().price();
                int namSx = 2020+i;
                Xe xe = new Xe(tenXe,Double.parseDouble(gia),namSx, loaiXe);
                xeRepository.save(xe);
            }
        };
    }

}
