package com.lairun.sys.role.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2020-01-16
 */
@Data
public class MenuTreeInfo {

    private Integer key;

    @JsonIgnore
    private Integer upKey;

    private String title;

    private List<MenuTreeInfo> children;

}
