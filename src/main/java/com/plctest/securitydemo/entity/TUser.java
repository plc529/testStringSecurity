package com.plctest.securitydemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TUser implements Serializable, UserDetails {
    private int id;
    private String name;
    private int age;
    private short gender;
    @JsonIgnore //当前字段不返回
    private String password;
    private String email;
    private String phone;
    private short accountNoExpired;
    private short credentialsNoExpired;
    private short accountNoLocked;
    private short accountEnabled;
    private List<Role> roles;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //格式化时间
    private LocalDateTime updateTime;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //声明序列化版本号，用于序列化/反序列化时都是同一个版本号
    private static final long serialVersionUID = 1L;
    //用实体类实现UserDetails方法，用于返回自定义数据，比如用户的信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //创建集合收集角色列表
//        Collection<SimpleGrantedAuthority> collection = new ArrayList<>();
//        //遍历角色列表，然后设置到GrantedAuthority的SimpleGrantedAuthority实现类中返回
//        for (Role role : this.roles) {
//            collection.add(new SimpleGrantedAuthority(role.getRole()));
//        }
//        return collection; //返回当前用户的角色权限
        return null;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNoExpired == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNoLocked == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNoExpired == 1;
    }

    @Override
    public boolean isEnabled() {
        return this.accountEnabled == 1;
    }
}
