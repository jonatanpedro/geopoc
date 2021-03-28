package com.example.demo.domain;

import com.example.demo.domain.entity.Region;
import com.example.demo.repository.GeoRepository;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoUseCase {

    private GeoRepository repository;

    @Autowired
    public GeoUseCase(GeoRepository repository) {
        this.repository = repository;
    }

    public Boolean verifyIfLatLongIsInRegion(Double lat, Double lon){

        try {
            Region region = this.repository.findByIdAndPais(1L, "Brasil");

            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory( null );

            WKTReader reader = new WKTReader( geometryFactory );
            MultiPolygon polygon = (MultiPolygon) reader.read(region.getWkbGeometry());

            Coordinate coord = new Coordinate(lon, lat);
            Point point = geometryFactory.createPoint(coord);

            return polygon.contains(point);

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
