package com.lairun.sys.user.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author x_holic@outlook.com
 * @date 2020-04-03
 */
@Data
public class ResetPassword {

    @NotBlank(message = "被重置用户ID不能为空")
    private String userId;

    @NotBlank(message = "新密码不能为空")
    private String password;

}
