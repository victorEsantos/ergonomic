package com.ergo.ergonomic.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptoTest {

    @Test
    void testeSenha(){
        //hash estatico para a senha 123456 - para garantir que nenhuma alteração na classe Crypto quebre a aplicacao
        String staticHash = "$2a$12$sazlPtiKGjMYHK3zTyZpQulaR.4YjTQBZ.4dYJtKfitG7/UO7Ub/6";
        String senha = "123456";
        String hash = Crypto.encrypt(senha);
        String hash2 = Crypto.encrypt(senha);

        assertTrue(Crypto.checkPassword(senha, staticHash));
        assertTrue(Crypto.checkPassword(senha, hash));
        assertTrue(Crypto.checkPassword(senha, hash2));
    }

    @Test
    void testeSenhaComplexa(){
        //hash estatico para a senha complexa - para garantir que nenhuma alteração na classe Crypto quebre a aplicacao
        String staticHash = "$2a$12$jx0evPALFlZDHcWsqwe/HuphVNlxhIbElIBe1m3tdfXVmh/lLF8fO";
        String senha = "minhaSenha@especialComNumero123456//z˜˜ç";
        String hash = Crypto.encrypt(senha);
        String hash2 = Crypto.encrypt(senha);

        assertTrue(Crypto.checkPassword(senha, staticHash));
        assertTrue(Crypto.checkPassword(senha, hash));
        assertTrue(Crypto.checkPassword(senha, hash2));
    }


}