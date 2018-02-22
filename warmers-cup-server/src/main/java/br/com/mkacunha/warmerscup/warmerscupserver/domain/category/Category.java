package br.com.mkacunha.warmerscup.warmerscupserver.domain.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;
import java.util.function.Consumer;

@Entity
@Table
public class Category implements Consumer<CategoryDTO> {

    @Id
    private String id;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer measure = 0;

    protected Category() {
    }

    private Category(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.measure = builder.measure;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void accept(CategoryDTO dto) {
        this.name = dto.getName();
        this.measure = dto.getMeasure();
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMeasure() {
        return measure;
    }


    static class Builder {

        private String id;

        private String name;

        private Integer measure;

        private Builder() {
            this.id = UUID.randomUUID().toString();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder measure(Integer measure) {
            this.measure = measure;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
