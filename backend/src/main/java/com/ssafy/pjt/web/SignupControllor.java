package com.ssafy.pjt.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.core.entity.Member;
import com.ssafy.pjt.provider.service.SignpuServiece;
import com.ssafy.pjt.web.dto.SignupRequsetDTO;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/singup")

@RequiredArgsConstructor
public class SignupControllor {

	@Autowired
	private SignpuServiece signpuServiece;
	
	
    @ApiOperation(value = "회원가입")
    @PostMapping
	private ResponseEntity<String> join(@Valid @RequestBody SignupRequsetDTO signupRequsetDTO) {
    	
    	if(signpuServiece.check(signupRequsetDTO.getEmail(), signupRequsetDTO.getName())) {
    		try {			   			
    			signpuServiece.joinMember(signupRequsetDTO);
    			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}		
		return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
	}
	
}