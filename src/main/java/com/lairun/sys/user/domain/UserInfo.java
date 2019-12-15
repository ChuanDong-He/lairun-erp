package com.lairun.sys.user.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-12
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -8747063124430630775L;

    private String userId;

    private String userName;

    private String phoneNumber;

    private String telephoneNumber;

    private String faxNumber;

    private String email;

    private String roleName;

}
