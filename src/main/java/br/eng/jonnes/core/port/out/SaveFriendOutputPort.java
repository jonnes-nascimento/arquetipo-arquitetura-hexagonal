package br.eng.jonnes.core.port.out;

import br.eng.jonnes.core.domain.model.Friend;

public interface SaveFriendOutputPort {

    Friend save(Friend friend);
}
