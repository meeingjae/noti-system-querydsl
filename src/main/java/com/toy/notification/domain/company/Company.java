package com.toy.notification.domain.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Company {

    @Id
    @Column(name = "company_id", nullable = false)
    private long companyId;

    @Column(name = "name", nullable = false)
    private String name;

    @Override
    public String toString() {

        return "companyId : " + this.companyId + ", name : " + this.name;
    }
}
