package br.eng.jonnes.core.domain.model;

public record FriendCheckMajorityRequest(
        String name,
        String telephone,
        int age
) {}