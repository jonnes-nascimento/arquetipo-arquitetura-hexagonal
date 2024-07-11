package br.eng.jonnes.config;

import br.eng.jonnes.adapter.integration.AgeOfMajorityServiceMock;
import br.eng.jonnes.adapter.repository.FriendRepository;
import br.eng.jonnes.adapter.repository.jpa.FriendJpaRepository;
import br.eng.jonnes.adapter.repository.mapper.FriendMapper;
import br.eng.jonnes.core.domain.behavior.MajorityChecker;
import br.eng.jonnes.core.port.out.FetchCurrentAgeOfMajorityOutputPort;
import br.eng.jonnes.core.port.out.SaveFriendOutputPort;
import br.eng.jonnes.core.usecase.CheckFriendMajorityUseCase;
import br.eng.jonnes.core.usecase.RegisterFriendUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreInjection {

    @Bean
    public MajorityChecker majorityChecker() {
        return new MajorityChecker();
    }

    @Bean
    public FetchCurrentAgeOfMajorityOutputPort fetchCurrentAgeOfMajorityOutputPort() {
        return new AgeOfMajorityServiceMock();
    }

    @Bean
    public SaveFriendOutputPort saveFriendOutputPort(FriendJpaRepository friendJpaRepository,
                                                     FriendMapper friendMapper) {
        return new FriendRepository(friendJpaRepository,
                friendMapper);
    }

    @Bean
    public CheckFriendMajorityUseCase checkFriendMajorityUseCase(MajorityChecker majorityChecker,
                                                                 FetchCurrentAgeOfMajorityOutputPort fetchCurrentAgeOfMajorityOutputPort) {
        return new CheckFriendMajorityUseCase(majorityChecker,
                fetchCurrentAgeOfMajorityOutputPort);
    }

    @Bean
    public RegisterFriendUseCase registerFriendUseCase(SaveFriendOutputPort saveFriendOutputPort,
                                                       FetchCurrentAgeOfMajorityOutputPort fetchCurrentAgeOfMajorityOutputPort,
                                                       MajorityChecker majorityChecker) {
        return new RegisterFriendUseCase(saveFriendOutputPort,
                fetchCurrentAgeOfMajorityOutputPort,
                majorityChecker);
    }
}
