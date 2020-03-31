package com.djyz.config;

import com.djyz.domain.Employee;
import com.djyz.domain.Role;
import com.djyz.service.EmployeeService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class EmployeeRealm extends AuthorizingRealm {
    @Autowired
    private EmployeeService employeeService;

    /*认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取登录提交的信息
        String username = (String)token.getPrincipal();
        //到数据库中查询有没有用户
        Employee employee = employeeService.getEmployeeWithUsername(username);
        if(employee == null){
            return null;
        }
        /*认证*/
        /*参数：主体，正确的密码，盐：当前realm名称*/
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(employee, employee.getPassword(), this.getName());
        return info;
    }

    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户的身份信息
        Employee employee = (Employee) principalCollection.getPrimaryPrincipal();
        //根据当前用户，查询角色和权限
        ArrayList<String> roles = new ArrayList<>();
        ArrayList<String> permissions = new ArrayList<>();
        //查询角色
        roles = employeeService.getRolesByEid(employee.getEid());

        //根据角色id查询权限
        permissions = employeeService.getPermissionsByEid(employee.getEid());

        //给授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        
        return info;
    }
}
