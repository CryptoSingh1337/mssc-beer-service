package com.saransh.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saransh.msscbeerservice.web.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private final UUID uuid = UUID.randomUUID();

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(
                get("/api/v1/beer/" + uuid)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception {
        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerJson = objectMapper.writeValueAsString(beerDTO);
        mockMvc.perform(
                post("/api/v1/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerJson = objectMapper.writeValueAsString(beerDTO);
        mockMvc.perform(
                put("/api/v1/beer/" + uuid)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerJson))
                .andExpect(status().isOk());
    }
}