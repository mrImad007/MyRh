package com.project.MyRh.Models.Enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    COMPANY_READ("management:read"),
    COMPANY_UPDATE("management:update"),
    COMPANY_CREATE("management:create"),
    COMPANY_DELETE("management:delete")

    ;

    @Getter
    private final String permission;
}
