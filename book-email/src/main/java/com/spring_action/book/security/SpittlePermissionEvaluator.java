package com.spring_action.book.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.spring_action.book.domain.Email;

public class SpittlePermissionEvaluator implements PermissionEvaluator {

	private static final GrantedAuthority ADMIN_AUTHORITY = 
			new GrantedAuthorityImpl("ROLE_ADMIN");
	
	@Override
	public boolean hasPermission(Authentication authentication, 
			Object target, Object permission) {
		
		if (target instanceof Email) {
			Email email = (Email) target;
			String message = email.getMessage();
			if ("delete".equals(permission)) {
				return isAdmin(authentication) ||
						message.equals(authentication.getName());
			}
		}
		
		throw new UnsupportedOperationException(
				"hasPermission not supported for object <" 
				+ target + "> and permission <" + permission + ">");
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId,
			String targetType, Object permission) {
		throw new UnsupportedOperationException();
	}

	private boolean isAdmin(Authentication authentication) {
		return authentication.getAuthorities().contains(ADMIN_AUTHORITY);
	}
}
