package br.eng.jonnes.adapter.repository.mapper;

import br.eng.jonnes.adapter.repository.model.FriendJpa;
import br.eng.jonnes.core.domain.model.Friend;
import org.springframework.stereotype.Component;

@Component
public class FriendMapper {

    public FriendJpa toFriendJpa(Friend friend) {
        return new FriendJpa(
                friend.getName(),
                friend.getTelephone(),
                friend.getAge(),
                friend.isAdult()
        );
    }

    public Friend toFriend(FriendJpa friendJpa) {
        return new Friend(
                friendJpa.getName(),
                friendJpa.getTelephone(),
                friendJpa.getAge(),
                friendJpa.isAdult()
        );
    }
}
