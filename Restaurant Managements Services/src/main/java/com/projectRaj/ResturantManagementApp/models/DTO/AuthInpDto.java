package com.projectRaj.ResturantManagementApp.models.DTO;

import com.projectRaj.ResturantManagementApp.models.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthInpDto {
    private String TokenValue;
    private String email;
    private Role role;

}
