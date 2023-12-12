package com.example.baimauck.backend.services;

import com.example.baimauck.backend.models.Xe;
import com.example.baimauck.backend.reponsitories.XeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XeService {
    @Autowired
    private XeRepository xeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Xe> findAll(){
        return xeRepository.findAll();
    }

    public List<Xe> findByCategory(Long maLoai){
        return entityManager
                .createQuery("select x from Xe x join LoaiXe lx on x.loaiXe.maLoai=lx.maLoai where x.loaiXe.maLoai=:maLoai", Xe.class)
                .setParameter("maLoai", maLoai)
                .getResultList();
    }

    public void addCar(Xe xe){
        xeRepository.save(xe);
    }

    public void delCar(Long id){
        xeRepository.deleteById(id);
    }
}
