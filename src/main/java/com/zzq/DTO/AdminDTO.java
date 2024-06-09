package com.zzq.DTO;

import lombok.Data;

@Data
public class AdminDTO {
    private Long id;
    private String oldPassword;
    private String newPassword;

}
