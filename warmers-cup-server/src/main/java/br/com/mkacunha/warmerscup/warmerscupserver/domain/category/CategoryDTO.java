package br.com.mkacunha.warmerscup.warmerscupserver.domain.category;

import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.annotation.Name;

import javax.validation.constraints.NotNull;

public class CategoryDTO {

    private String id;

    @Name
    private String name;

    @NotNull(message = "Pontuação é obrigatório")
    private Integer measure;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMeasure() {
        return measure;
    }

    public void setMeasure(Integer measure) {
        this.measure = measure;
    }
}
