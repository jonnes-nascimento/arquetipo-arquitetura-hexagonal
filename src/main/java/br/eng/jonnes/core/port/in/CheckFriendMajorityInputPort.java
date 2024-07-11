package br.eng.jonnes.core.port.in;

import br.eng.jonnes.core.domain.model.Friend;
import br.eng.jonnes.core.domain.model.FriendCheckMajorityRequest;

public interface CheckFriendMajorityInputPort {

    Friend check(FriendCheckMajorityRequest friendCheckMajorityRequest);
}
