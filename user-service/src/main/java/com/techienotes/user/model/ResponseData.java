package com.techienotes.user.model;

import com.techienotes.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {

    private User user;
    private Department department;
}
