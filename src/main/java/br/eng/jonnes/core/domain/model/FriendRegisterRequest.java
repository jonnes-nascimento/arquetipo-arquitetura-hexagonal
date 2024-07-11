package br.eng.jonnes.core.domain.model;

public record FriendRegisterRequest(
        String name,
        String telephone,
        int age
) {}