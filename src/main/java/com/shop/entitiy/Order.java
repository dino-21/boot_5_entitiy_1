package com.shop.entitiy;


import com.shop.constant.Orderstatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")  //order 키워드가 있으므로 Order 엔티티에 매핑되는 체이블로 orders를 지정
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;   // 한명의 회원은 여러번 주문할 수 있으므로 주문엔티티 기준 다대일 단방향매핑

    private LocalDateTime orderDate; //주문일

    @Enumerated(EnumType.STRING)
    private Orderstatus orderstatus;  //주문상태

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
