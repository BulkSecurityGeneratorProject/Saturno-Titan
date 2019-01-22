package com.zenit.saturno.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import com.zenit.saturno.domain.enumeration.TipoRecurso;

/**
 * A DTO for the Agenda entity.
 */
public class AgendaDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 100)
    private String nombre;

    @NotNull
    private TipoRecurso tipoDeRecurso;

    private LocalDate fechaDesde;

    private LocalDate fechaHasta;

    private Boolean activa;

    private Set<IntervaloDTO> intervalos = new HashSet<>();

    private Set<DiaNoLaborableDTO> diaNoLaborables = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoRecurso getTipoDeRecurso() {
        return tipoDeRecurso;
    }

    public void setTipoDeRecurso(TipoRecurso tipoDeRecurso) {
        this.tipoDeRecurso = tipoDeRecurso;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Boolean isActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public Set<IntervaloDTO> getIntervalos() {
        return intervalos;
    }

    public void setIntervalos(Set<IntervaloDTO> intervalos) {
        this.intervalos = intervalos;
    }

    public Set<DiaNoLaborableDTO> getDiaNoLaborables() {
        return diaNoLaborables;
    }

    public void setDiaNoLaborables(Set<DiaNoLaborableDTO> diaNoLaborables) {
        this.diaNoLaborables = diaNoLaborables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AgendaDTO agendaDTO = (AgendaDTO) o;
        if (agendaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), agendaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AgendaDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", tipoDeRecurso='" + getTipoDeRecurso() + "'" +
            ", fechaDesde='" + getFechaDesde() + "'" +
            ", fechaHasta='" + getFechaHasta() + "'" +
            ", activa='" + isActiva() + "'" +
            "}";
    }
}