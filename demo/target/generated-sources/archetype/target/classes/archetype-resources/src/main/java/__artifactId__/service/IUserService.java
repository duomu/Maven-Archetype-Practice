#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.service;

import ${package}.${artifactId}.model.User;

import java.util.List;

/**
 * Author：linlin.yang
 * Date：2017/6/29 15:59
 */
public interface IUserService {
    int getUserCount();

    List<User> getUserByName(String name);
}
