package org.hermit.cinerex.security.jwt;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hermit.cinerex.security.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetail implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetail(String username, String email, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public JwtUserDetail(Long id, String username, String email, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    
    /** 
     * @param user
     * @return JwtUserDetail
     */
    public static JwtUserDetail build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

        return new JwtUserDetail(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), authorities);

    }
    
    
    /** 
     * @return Long
     */
    public Long getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * @return Collection<? extends GrantedAuthority>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    
    
    /** 
     * @return String
     */
    @Override
    public String getPassword() {
        return password;
    }

    
    /** 
     * @return String
     */
    @Override
    public String getUsername() {
        return username;
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    
    /** 
     * @param object
     * @return boolean
     */
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof JwtUserDetail))
            return false;
        if (!super.equals(object))
            return false;
        JwtUserDetail that = (JwtUserDetail) object;
        return java.util.Objects.equals(id, that.id) && java.util.Objects.equals(username, that.username)
                && java.util.Objects.equals(email, that.email) && java.util.Objects.equals(password, that.password)
                && java.util.Objects.equals(authorities, that.authorities);
    }

    
    /** 
     * @return int
     */
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, username, email, password, authorities);
    }
}
