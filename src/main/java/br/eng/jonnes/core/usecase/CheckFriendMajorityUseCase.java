package br.eng.jonnes.core.usecase;

import br.eng.jonnes.core.domain.behavior.MajorityChecker;
import br.eng.jonnes.core.domain.model.Friend;
import br.eng.jonnes.core.domain.model.FriendCheckMajorityRequest;
import br.eng.jonnes.core.port.in.CheckFriendMajorityInputPort;
import br.eng.jonnes.core.port.out.FetchCurrentAgeOfMajorityOutputPort;

public class CheckFriendMajorityUseCase implements CheckFriendMajorityInputPort {

    private final MajorityChecker majorityChecker;
    private final FetchCurrentAgeOfMajorityOutputPort fetchCurrentAgeOfMajorityOutputPort;

    public CheckFriendMajorityUseCase(MajorityChecker majorityChecker,
                                      FetchCurrentAgeOfMajorityOutputPort fetchCurrentAgeOfMajorityOutputPort) {
        this.majorityChecker = majorityChecker;
        this.fetchCurrentAgeOfMajorityOutputPort = fetchCurrentAgeOfMajorityOutputPort;
    }

    @Override
    public Friend check(FriendCheckMajorityRequest friendCheckMajorityRequest) {
        return majorityChecker.checkIfAdult(
                friendCheckMajorityRequest.name(),
                friendCheckMajorityRequest.telephone(),
                friendCheckMajorityRequest.age(),
                fetchCurrentAgeOfMajorityOutputPort.get()
        );
    }
}
