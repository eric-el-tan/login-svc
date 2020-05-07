package com.eric.user.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Identifier of a user.", dataType = "Long", example = "1", position = 1)
    private Integer id;
    @NotBlank
    @ApiModelProperty(value = "First Name.", dataType = "String", example = "Adam", position = 2)
    private String name;
    @NotBlank
    @ApiModelProperty(value = "Date of Birth", dataType = "Date", example = "2000-01-01", position = 3)
    private LocalDate dob;

    public UserDto(int id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public UserDto() {
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
        UserDto userPo = (UserDto) o;
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
