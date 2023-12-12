package com.example.baimauck.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "LoaiXe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoaiXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLoai")
    private long maLoai;

    @Column(name = "tenLoai")
    private String tenLoai;

    @OneToMany(mappedBy = "loaiXe")
    private List<Xe> xe;

    public LoaiXe(long maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public LoaiXe(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "LoaiXe{" +
                "maLoai=" + maLoai +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }
}
