package br.eng.jonnes.adapter.web;

import br.eng.jonnes.core.domain.model.Friend;
import br.eng.jonnes.core.domain.model.FriendCheckMajorityRequest;
import br.eng.jonnes.core.domain.model.FriendRegisterRequest;
import br.eng.jonnes.core.port.in.CheckFriendMajorityInputPort;
import br.eng.jonnes.core.port.in.RegisterFriendInputPort;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/friend")
@Tag(name = "Friend API", description = "Endpoints para cadastro de amigos")
public class FriendController {

    private final CheckFriendMajorityInputPort checkFriendMajorityInputPort;
    private final RegisterFriendInputPort registerFriendInputPort;

    public FriendController(CheckFriendMajorityInputPort checkFriendMajorityInputPort,
                            RegisterFriendInputPort registerFriendInputPort) {
        this.checkFriendMajorityInputPort = checkFriendMajorityInputPort;
        this.registerFriendInputPort = registerFriendInputPort;
    }

    @GetMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objeto contendo as informações de maioridade do amigo")
    })
    public ResponseEntity<Friend> checkFriendMajority(@RequestBody FriendCheckMajorityRequest friendCheckMajorityRequest) {
        var friend = checkFriendMajorityInputPort.check(friendCheckMajorityRequest);
        return ResponseEntity.ok(friend);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Objeto contendo as informações do amigo criado")
    })
    public ResponseEntity<Friend> registerFriend(@RequestBody FriendRegisterRequest friendRegisterRequest) {
        var friend = registerFriendInputPort.register(friendRegisterRequest);

        URI uriOfCreatedFriend = null;

        try {
            uriOfCreatedFriend = new URI("http://localhost");
        } catch (Exception ignored) {
        }

        return ResponseEntity.created(uriOfCreatedFriend).body(friend);
    }

}
