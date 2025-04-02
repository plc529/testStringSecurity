package com.plctest.securitydemo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * role
 * @author 
 */
@Data
public class Role implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 角色：唯一
     */
    private String role;

    /**
     * 角色名，唯一
     */
    private String roleName;

    private static final long serialVersionUID = 1L;
}