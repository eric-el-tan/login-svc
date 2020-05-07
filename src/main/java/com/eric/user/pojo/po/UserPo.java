package com.eric.user.pojo.po;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class UserPo {
    @Id
    private Integer id;
    private String name;
    private LocalDate dob;

    public UserPo(int id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public UserPo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPo userPo = (UserPo) o;
        return Objects.equals(id, userPo.id) &&
                Objects.equals(name, userPo.name) &&
                Objects.equals(dob, userPo.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dob);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
