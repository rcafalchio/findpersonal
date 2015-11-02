/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.findpersonal.findpersonalws.config;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.findpersonal.findpersonaljpa.entity.Usuario;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UsuarioRepository userRepository;

	@Autowired
	public CustomUserDetailsService(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepository.findByEmail(email);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException(String.format("User %s does not exist!", user));
		}
		return new UsuarioRepositoryUserDetails(user.get());
	}

	private final static class UsuarioRepositoryUserDetails extends Usuario implements UserDetails {

		private static final long serialVersionUID = 1L;

		private UsuarioRepositoryUserDetails(Usuario user) {
			super(user);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return getPapeis();
		}

		@Override
		public String getUsername() {
			return getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public String getPassword() {
			return getSenha();
		}
	}

}
