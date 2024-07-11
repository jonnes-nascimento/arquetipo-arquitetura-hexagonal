package br.eng.jonnes.config;

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
