package com.example.demo.web;

import com.example.demo.core.service.dto.CoffeeDTO;
import com.example.demo.provider.service.CoffeeService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Slf4j
@ApiModel
@RestController
@RequestMapping("/api/v1/coffees")
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;
    @ApiOperation(value = "Ȯ��")
    @GetMapping
    public List<CoffeeDTO> getAllCoffees(HttpSession session) {
        return coffeeService.findAll().orElse(Collections.emptyList());
    }
}