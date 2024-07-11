package br.eng.jonnes.core.usecase;

import br.eng.jonnes.core.domain.behavior.MajorityChecker;
import br.eng.jonnes.core.domain.model.Friend;
import br.eng.jonnes.core.domain.model.FriendRegisterRequest;
import br.eng.jonnes.core.port.in.RegisterFriendInputPort;
import br.eng.jonnes.core.port.out.FetchCurrentAgeOfMajorityOutputPort;
import br.eng.jonnes.core.port.out.SaveFriendOutputPort;

public class RegisterFriendUseCase implements RegisterFriendInputPort {

    private final SaveFriendOutputPort saveFriendOutputPort;
    private final FetchCurrentAgeOfMajorityOutputPort fetchCurrentAgeOfMajorityOutputPort;
    private final MajorityChecker majorityChecker;

    public RegisterFriendUseCase(SaveFriendOutputPort saveFriendOutputPort,
                                 FetchCurrentAgeOfMajorityOutputPort fetchCurrentAgeOfMajorityOutputPort,
                                 MajorityChecker majorityChecker) {
        this.saveFriendOutputPort = saveFriendOutputPort;
        this.fetchCurrentAgeOfMajorityOutputPort = fetchCurrentAgeOfMajorityOutputPort;
        this.majorityChecker = majorityChecker;
    }

    @Override
    public Friend register(FriendRegisterRequest friendRegisterRequest) {

        var friend = majorityChecker.checkIfAdult(
                friendRegisterRequest.name(),
                friendRegisterRequest.telephone(),
                friendRegisterRequest.age(),
                fetchCurrentAgeOfMajorityOutputPort.get()
        );

        return saveFriendOutputPort.save(friend);
    }
}
