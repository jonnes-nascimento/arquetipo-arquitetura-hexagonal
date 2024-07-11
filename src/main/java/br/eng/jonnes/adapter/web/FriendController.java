package br.eng.jonnes.adapter.web;

import br.eng.jonnes.core.domain.model.Friend;
import br.eng.jonnes.core.domain.model.FriendCheckMajorityRequest;
import br.eng.jonnes.core.domain.model.FriendRegisterRequest;
import br.eng.jonnes.core.port.in.CheckFriendMajorityInputPort;
import br.eng.jonnes.core.port.in.RegisterFriendInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/friend")
public class FriendController {

    private final CheckFriendMajorityInputPort checkFriendMajorityInputPort;
    private final RegisterFriendInputPort registerFriendInputPort;

    public FriendController(CheckFriendMajorityInputPort checkFriendMajorityInputPort,
                            RegisterFriendInputPort registerFriendInputPort) {
        this.checkFriendMajorityInputPort = checkFriendMajorityInputPort;
        this.registerFriendInputPort = registerFriendInputPort;
    }

    @GetMapping
    public ResponseEntity<Friend> checkFriendMajority(@RequestBody FriendCheckMajorityRequest friendCheckMajorityRequest) {
        var friend = checkFriendMajorityInputPort.check(friendCheckMajorityRequest);
        return ResponseEntity.ok(friend);
    }

    @PostMapping
    public ResponseEntity<Friend> registerFriend(@RequestBody FriendRegisterRequest friendRegisterRequest) {
        var friend = registerFriendInputPort.register(friendRegisterRequest);
        var uriOfCreatedFriend = "must be implemented";
        return new ResponseEntity<>(friend, HttpStatus.CREATED);
    }

}
