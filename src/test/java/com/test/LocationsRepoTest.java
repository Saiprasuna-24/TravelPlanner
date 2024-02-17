package com.test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.Travelplanner.Entity.Locations;
import com.Travelplanner.Repo.LocationsRepo;

@DataJpaTest
@EnableJpaRepositories(basePackages = "com.Travelplanner.Repo")
public class LocationsRepoTest {

    @Autowired
    private LocationsRepo locationsRepo;

    @Test
    public void testSaveLocation() {
        Locations location = new Locations("New York", "USA");
        locationsRepo.save(location);
        assertEquals(1, locationsRepo.count());
    }

    @Test
    public void testFindAllLocations() {
        Locations location1 = new Locations("New York", "USA");
        Locations location2 = new Locations("London", "UK");
        locationsRepo.saveAll(Arrays.asList(location1, location2));
        List<Locations> locations = locationsRepo.findAll();
        assertEquals(2, locations.size());
        assertTrue(locations.contains(location1));
        assertTrue(locations.contains(location2));
    }

    @Test
    public void testDeleteLocation() {
        Locations location = new Locations("New York", "USA");
        locationsRepo.save(location);
        locationsRepo.delete(location);
        assertEquals(0, locationsRepo.count());
    }

}
