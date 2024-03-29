package com.project.MyRh.Models.Enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.project.MyRh.Models.Enums.Permission.*;

@RequiredArgsConstructor
public enum Role {
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    COMPANY_READ,
                    COMPANY_UPDATE,
                    COMPANY_DELETE,
                    COMPANY_CREATE
            )
    ),
    COMPANY(
            Set.of(
                    COMPANY_READ,
                    COMPANY_UPDATE,
                    COMPANY_DELETE,
                    COMPANY_CREATE
            )
    ),
    APPLICANT(
            Set.of(
                    APPLICANT_READ,
                    APPLICANT_UPDATE,
                    APPLICANT_DELETE,
                    APPLICANT_CREATE
            )
    );



    @Getter
    private final Set<Permission> permissions;



    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
