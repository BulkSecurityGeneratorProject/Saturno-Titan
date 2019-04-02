package com.zenit.saturno.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import com.zenit.saturno.domain.enumeration.Marca;

/**
 * A DTO for the Modelo entity.
 */
public class ModeloDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 3, max = 4)
    private String codigo;

    @NotNull
    @Size(max = 100)
    private String nombre;

    @NotNull
    @Min(value = 1950)
    private Integer anioInicioProduccion;

    @Min(value = 1950)
    private Integer anioFinProduccion;

    @NotNull
    private Marca marca;

    private Long planId;

    private String planNombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnioInicioProduccion() {
        return anioInicioProduccion;
    }

    public void setAnioInicioProduccion(Integer anioInicioProduccion) {
        this.anioInicioProduccion = anioInicioProduccion;
    }

    public Integer getAnioFinProduccion() {
        return anioFinProduccion;
    }

    public void setAnioFinProduccion(Integer anioFinProduccion) {
        this.anioFinProduccion = anioFinProduccion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planMantenimientoId) {
        this.planId = planMantenimientoId;
    }

    public String getPlanNombre() {
        return planNombre;
    }

    public void setPlanNombre(String planMantenimientoNombre) {
        this.planNombre = planMantenimientoNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ModeloDTO modeloDTO = (ModeloDTO) o;
        if (modeloDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), modeloDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ModeloDTO{" +
            "id=" + getId() +
            ", codigo='" + getCodigo() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", anioInicioProduccion=" + getAnioInicioProduccion() +
            ", anioFinProduccion=" + getAnioFinProduccion() +
            ", marca='" + getMarca() + "'" +
            ", plan=" + getPlanId() +
            ", plan='" + getPlanNombre() + "'" +
            "}";
    }
}
