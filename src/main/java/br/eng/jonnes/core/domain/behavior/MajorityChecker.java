package br.eng.jonnes.core.domain.behavior;

import br.eng.jonnes.core.domain.model.Friend;

public class MajorityChecker {

    public MajorityChecker() {
    }

    private boolean isAdult(int age, int currentAgeOfMajority) {
        return age > currentAgeOfMajority;
    }

    public Friend checkIfAdult(String name, String telephone, int age, int currentAgeOfMajority) {
        return new Friend(name, telephone, age, isAdult(age, currentAgeOfMajority));
    }
}
