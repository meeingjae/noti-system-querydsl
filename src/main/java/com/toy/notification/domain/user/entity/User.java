package com.toy.notification.domain.user.entity;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue
    @NotNull                                        // @NotNull vs @Column(nullable = false)
    @Column(name = "user_id", nullable = false)     // 현재 null일 경우 쿼리 던지지 않게 양쪽 다 선제적 조치 취해 놓은 상태
    private long userId;                            // see: https://www.baeldung.com/hibernate-notnull-vs-nullable
                                                    // @NotNull Annotation에 ddl 적용 옵션으로 사용하는 것이 General 하다
    @NotNull                                        // 추후에 nullalble = false 옵션을 걷어내는 방향으로 진행
    @Column(name = "company_id", nullable = false)
    private long companyId;

    @NotNull
    @Column(name = "username", nullable = false)
    private String userName;

    @Nullable                                       // null 값을 받는 필드임을 표면적으로 명시
    @Column(name = "do_not_disturb_flag", nullable = true)
    private Boolean doNotDisturb;

    @QueryProjection
    public User(long userId) {

        this.userId = userId;
    }

    @Getter
    @RequiredArgsConstructor
    public enum DoNotDisturb {
        ON(true),
        OFF(false);

        private final boolean flag;
    }
}
