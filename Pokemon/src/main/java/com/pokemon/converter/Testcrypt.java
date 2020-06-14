package com.pokemon.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Testcrypt {
	public static void main(String[] args) {
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("admin"));
    }
	
	public String encrypt(String pass) {
        BCryptPasswordEncoder pe=new BCryptPasswordEncoder();
        return pe.encode(pass);
    }
}
