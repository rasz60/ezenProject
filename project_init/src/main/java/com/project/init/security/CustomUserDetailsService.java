package com.project.init.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.init.dao.UserDao;
import com.project.init.dto.UserDto;
import com.project.init.util.Constant;

public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		UserDao udao = Constant.udao;
		UserDto dto = udao.login(username);

		if(dto == null) {
			System.out.println("null");
			
			//로그인 실패시 exception 발생
			throw new UsernameNotFoundException("No user found with username");
			
		}
		
		if(!UserDto.isEnabled()) { //비활성화된 유저인 경우 disabledException 발생 
			throw new DisabledException("Ban User : " + username);
		}
		
		String pw = dto.getUserPw(); // ��ȣȭ�� �н�����

		//role��(���� ���� ��, ROLE_USER,ROLE_ADMIN,ROLE_MANAGE ��)�� �����ϴ� ����Ʈ ��ü
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();

		roles.add(new SimpleGrantedAuthority(dto.getUserAuthority()));

		//���� id,pw,roles�� �̿��Ͽ� UserDetails��ü�� ����� ��ȯ����
		UserDetails user = new User(username, pw, roles);
		
		//spring���� pw��ġ ���� üũ�ϰ� ���� ���� ���� �۾� ����
		return user; 
	}

}