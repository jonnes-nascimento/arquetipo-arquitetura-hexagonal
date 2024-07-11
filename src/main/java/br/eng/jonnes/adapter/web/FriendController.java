package br.eng.jonnes.adapter.web;

import br.eng.jonnes.core.domain.model.Friend;
import br.eng.jonnes.core.domain.model.FriendCheckMajorityRequest;
import br.eng.jonnes.core.domain.model.FriendRegisterRequest;
import br.eng.jonnes.core.usecase.CheckFriendMajorityUseCase;
import br.eng.jonnes.core.usecase.RegisterFriendUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/friend")
public class FriendController {

    private final CheckFriendMajorityUseCase checkFriendMajorityUseCase;
    private final RegisterFriendUseCase registerFriendUseCase;

    public FriendController(CheckFriendMajorityUseCase checkFriendMajorityUseCase, RegisterFriendUseCase registerFriendUseCase) {
        this.checkFriendMajorityUseCase = checkFriendMajorityUseCase;
        this.registerFriendUseCase = registerFriendUseCase;
    }

    @GetMapping
    public ResponseEntity<Friend> checkFriendMajority(@RequestBody FriendCheckMajorityRequest friendCheckMajorityRequest) {
        var friend = checkFriendMajorityUseCase.check(friendCheckMajorityRequest);
        return ResponseEntity.ok(friend);
    }

    @PostMapping
    public ResponseEntity<Friend> registerFriend(@RequestBody FriendRegisterRequest friendRegisterRequest) {
        var friend = registerFriendUseCase.register(friendRegisterRequest);
        var uriOfCreatedFriend = "must be implemented";
        return new ResponseEntity<>(friend, HttpStatus.CREATED);
    }
}
