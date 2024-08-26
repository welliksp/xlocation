package br.com.wsp.xlocation.repository;

import br.com.wsp.xlocation.entity.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {


    @Query("""
                SELECT p FROM PointOfInterest p
                WHERE(p.x >= :xMin AND p.x <= :xMax AND p.y >= :yMin AND p.y <= :yMax )
            """)
    List<PointOfInterest> findNearMe(@Param("xMin") Long xMin,
                                     @Param("xMax") Long xMax,
                                     @Param("yMin") Long yMin,
                                     @Param("yMax") Long yMax);
}
