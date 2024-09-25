package br.com.gjleon.controller.dto;

import br.com.gjleon.domain.model.User;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record UserDto(
        Long id,
        String name,
        AccountDto account,
        CardDto card,
        List<FeatureDto> features,
        List<NewsDto> news)
{
    public UserDto(User userModel) {
            this(
                    userModel.getId(),
                    userModel.getName(),
                    ofNullable(userModel.getAccount()).map(AccountDto::new).orElse(null),
                    ofNullable(userModel.getCard()).map(CardDto::new).orElse(null),
                    ofNullable(userModel.getFeatures()).orElse(emptyList()).stream().map(FeatureDto::new).collect(toList()),
                    ofNullable(userModel.getNews()).orElse(emptyList()).stream().map(NewsDto::new).collect(toList())
            );
        }

        public User toModel() {
            User userModel = new User();
            userModel.setId(this.id);
            userModel.setName(this.name);
            userModel.setAccount(ofNullable(this.account).map(AccountDto::toModel).orElse(null));
            userModel.setCard(ofNullable(this.card).map(CardDto::toModel).orElse(null));
            userModel.setFeatures(ofNullable(this.features).orElse(emptyList()).stream().map(FeatureDto::toModel).collect(toList()));
            userModel.setNews(ofNullable(this.news).orElse(emptyList()).stream().map(NewsDto::toModel).collect(toList()));
            return userModel;
        }
}
