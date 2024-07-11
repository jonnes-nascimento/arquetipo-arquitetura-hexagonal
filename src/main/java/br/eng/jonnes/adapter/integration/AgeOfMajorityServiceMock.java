package br.eng.jonnes.adapter.integration;

import br.eng.jonnes.core.port.out.FetchCurrentAgeOfMajorityOutputPort;

public class AgeOfMajorityServiceMock implements FetchCurrentAgeOfMajorityOutputPort {

    @Override
    public int get() {
        return 18;
    }
}
