package com.jakleb.demo.enums;

import lombok.Getter;

@Getter
public enum RoleKind {
    USER("USER"),
    ADMIN("ADMIN");
    
    private String role;

    private RoleKind(String role){
        this.role = role;
    }

}