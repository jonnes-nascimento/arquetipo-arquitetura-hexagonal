package br.eng.jonnes.core.port.in;

import br.eng.jonnes.core.domain.model.Friend;
import br.eng.jonnes.core.domain.model.FriendRegisterRequest;

public interface RegisterFriendInputPort {

    Friend register(FriendRegisterRequest friendRegisterRequest);
}
