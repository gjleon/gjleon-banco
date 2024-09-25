package br.com.gjleon.controller.dto;

import br.com.gjleon.domain.model.Feature;

public record FeatureDto(
        Long id,
        String icon,
        String description
) {
    public FeatureDto(Feature featureModel) {
        this(
                featureModel.getId(),
                featureModel.getIcon(),
                featureModel.getDescription()
        );
    }

    public Feature toModel() {
        Feature featureModel = new Feature();
        featureModel.setId(this.id);
        featureModel.setIcon(this.icon);
        featureModel.setDescription(this.description);
        return featureModel;
    }
}
