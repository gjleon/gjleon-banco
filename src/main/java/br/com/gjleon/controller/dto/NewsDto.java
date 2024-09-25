package br.com.gjleon.controller.dto;

import br.com.gjleon.domain.model.News;

public record NewsDto(
        Long id,
        String icon,
        String description
) {
    public NewsDto(News newsModel) {
        this(
                newsModel.getId(),
                newsModel.getIcon(),
                newsModel.getDescription());
    }

    public News toModel() {
        News newsModel = new News();
        newsModel.setId(this.id);
        newsModel.setIcon(this.icon);
        newsModel.setDescription(this.description);
        return newsModel;
    }
}
