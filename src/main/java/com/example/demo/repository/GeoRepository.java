package com.example.demo.repository;

import com.example.demo.domain.entity.Region;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoRepository extends CrudRepository<Region, Long> {

        @Cacheable("region")
        @Query("select ogc_fid, pais, st_astext(wkb_geometry) as wkb_geometry from brasil_simp where pais = :pais and ogc_fid = :id")
        Region findByIdAndPais(@Param("id") Long id, @Param("pais") String pais);
}
