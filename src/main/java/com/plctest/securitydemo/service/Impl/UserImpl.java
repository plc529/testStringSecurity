package com.plctest.securitydemo.service.Impl;

import com.plctest.securitydemo.entity.TUser;
import com.plctest.securitydemo.mapper.UserMapper;
import com.plctest.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Service
public class UserImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUser user = userMapper.select(username);
        if (user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
//        UserDetails build = User.builder()
//                .username(user.getName())
////                .password("{noop}"+ user.getPassword())
//                .password(user.getPassword())
//                .authorities(AuthorityUtils.NO_AUTHORITIES)
//                .build();
        //查询用户角色
//        List<Role> roles = roleMapper.getRoleListByUserId(user.getId());
        //设置用户的角色，给security框架使用
//        user.setRoles(roles);
        return user;
    }

//    @Override
//    public void insert(TUser user) {
//        String oldPassword = user.getPassword();
//        String newPassword = passwordEncoder.encode(oldPassword);//加密
//        user.setPassword(newPassword);
//        userMapper.insert(user);
//    }
}
