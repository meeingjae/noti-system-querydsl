package com.toy.notification.domain.noti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "NOTI")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Noti {

    @Id
    @GeneratedValue
    @Column(name = "noti_id", nullable = false)
    private long notiId;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "message", nullable = false)
    private String message;

    // NotiReceive의 삭제에 영향을 미치지 않는다
    // LAZY option 검토. 현재 Test 위해 EAGER로 설정
    //@OneToMany(mappedBy = "noti", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = false)
    @OneToMany(mappedBy = "noti", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = false)
    private List<NotiReceive> notiReceiveList;
}
