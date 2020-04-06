package com.lairun.sys.user.domain;

import com.lairun.common.entity.BaseEntity;
import com.lairun.sys.role.domain.RoleInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -8747063124430630775L;

    private String userId;

    private String userName;

    private String phoneNumber;

    private String telephoneNumber;

    private String faxNumber;

    private String email;

    private List<RoleInfo> roles;

}
