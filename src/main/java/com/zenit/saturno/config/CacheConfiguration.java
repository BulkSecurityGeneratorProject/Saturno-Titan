package com.zenit.saturno.config;

import java.time.Duration;

import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import io.github.jhipster.config.jcache.BeanClassLoaderAwareJCacheRegionFactory;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        BeanClassLoaderAwareJCacheRegionFactory.setBeanClassLoader(this.getClass().getClassLoader());
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(com.zenit.saturno.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(com.zenit.saturno.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Turno.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Turno.class.getName() + ".servicios", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Cliente.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Cliente.class.getName() + ".turnos", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Vehiculo.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Vehiculo.class.getName() + ".turnos", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Modelo.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Modelo.class.getName() + ".vehiculos", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.PlanMantenimiento.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.PlanMantenimiento.class.getName() + ".servicios", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.PlanMantenimiento.class.getName() + ".modelos", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.TipoServicio.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.TipoServicio.class.getName() + ".servicios", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Servicio.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Servicio.class.getName() + ".tareas", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Servicio.class.getName() + ".turnos", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Tarea.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Tarea.class.getName() + ".servicios", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Agenda.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Agenda.class.getName() + ".horarios", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Agenda.class.getName() + ".horarioEspecials", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Agenda.class.getName() + ".diaNoLaborables", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Agenda.class.getName() + ".turnos", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Horario.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.Horario.class.getName() + ".agenda", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.HorarioEspecial.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.HorarioEspecial.class.getName() + ".agenda", jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.DiaNoLaborable.class.getName(), jcacheConfiguration);
            cm.createCache(com.zenit.saturno.domain.DiaNoLaborable.class.getName() + ".agenda", jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
