package com.duqi.security.common.utils;

import com.duqi.entity.User;
import com.duqi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 获取当前请求的用户
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CurrentUserUtils {

  private final UserService userService;

  public User getCurrentUser() {
    return userService.find(getCurrentUsername());
  }

  private String getCurrentUsername() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getPrincipal() != null) {
      return (String) authentication.getPrincipal();
    }
    return null;
  }
}
