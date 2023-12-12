package com.example.baimauck.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Xe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maXe")
    private long maXe;
    @Column(name = "tenXe")
    private String tenXe;
    @Column(name = "gia")
    private double gia;
    @Column(name = "namSX")
    private int namSX;

    @ManyToOne
    @JoinColumn(name = "MaLoai")
    private LoaiXe loaiXe;

    public Xe(String tenXe, double gia, int namSX, LoaiXe loaiXe) {
        this.tenXe = tenXe;
        this.gia = gia;
        this.namSX = namSX;
        this.loaiXe = loaiXe;
    }
}
