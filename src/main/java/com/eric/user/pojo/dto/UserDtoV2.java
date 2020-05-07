package com.eric.user.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserDtoV2 extends UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Age (from v2) ", dataType = "Long", example = "15", position = 4)
    private Integer age;

    public UserDtoV2(int id, String name, LocalDate dob) {
        super(id, name, dob);
    }

    public UserDtoV2() {
        super();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
