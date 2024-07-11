package br.eng.jonnes.adapter.repository;

import br.eng.jonnes.adapter.repository.jpa.FriendJpaRepository;
import br.eng.jonnes.adapter.repository.mapper.FriendMapper;
import br.eng.jonnes.core.domain.model.Friend;
import br.eng.jonnes.core.port.out.SaveFriendOutputPort;

public class FriendRepository implements SaveFriendOutputPort {

    private final FriendJpaRepository friendJpaRepository;
    private final FriendMapper friendMapper;

    public FriendRepository(FriendJpaRepository friendJpaRepository, FriendMapper friendMapper) {
        this.friendJpaRepository = friendJpaRepository;
        this.friendMapper = friendMapper;
    }

    @Override
    public Friend save(Friend friend) {
        var friendJpa = friendMapper.toFriendJpa(friend);
        var friendSaved = friendJpaRepository.save(friendJpa);
        return friendMapper.toFriend(friendSaved);
    }
}
