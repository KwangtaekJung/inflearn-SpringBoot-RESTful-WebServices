package com.example.restfulwebservice.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AdminUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void headerVersion1() throws Exception {

        ResultActions resultActions = mockMvc.perform(get("/admin/users/{id}", 1)
                        .header("X-API-VERSION", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Kenneth"))
                .andExpect(jsonPath("$.joinDate").exists())
                .andExpect(jsonPath("ssn").exists())
                .andExpect(jsonPath("grade").doesNotExist())
                ;
    }

    @Test
    public void headerVersion2() throws Exception {

        ResultActions resultActions = mockMvc.perform(get("/admin/users/{id}", 1)
                        .header("X-API-VERSION", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Kenneth"))
                .andExpect(jsonPath("$.joinDate").exists())
                .andExpect(jsonPath("ssn").doesNotExist())
                .andExpect(jsonPath("grade").exists())
                ;
    }
}