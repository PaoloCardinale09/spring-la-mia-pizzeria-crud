package org.lessons.springpizzeria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name must not be null or blank")

    @Column(nullable = false)
    private String name;
    @NotBlank(message = "Description must not be null or blank")
    @Size(max = 255, message = "The description must be a maximum of 255 characters")
    @Lob // annotazione per dare un long text
    private String description;
    @Column(length = 1000)
    @Size(max = 1000, message = "The Url must be a maximum of 1000 characters")
    private String picUrl;
    @DecimalMin(value = "0.0", inclusive = false, message = "The price must be greater than 0")
    @NotNull(message = "The price must be greater than 0")
    private BigDecimal price;

    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // custom getter per timestamp formattato
    public String getFormattedCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd MMMM  yyyy 'at' HH:mm");
        return createdAt.format(formatter);
    }
}
