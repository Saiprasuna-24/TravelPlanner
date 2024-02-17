package com.test;


import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.Travelplanner.Entity.TravelBudgetAllocations;
import com.Travelplanner.Repo.TravelBudgetAllocationsRepo;

@DataJpaTest
public class TravelBudgetAllocationsRepoTest {

    @MockBean
    private TravelBudgetAllocationsRepo repo;

    @Test
    public void testFindById() {
        int id = 1;
        TravelBudgetAllocations expected = new TravelBudgetAllocations();
        expected.setId(id);
        when(repo.findById(id)).thenReturn(Optional.of(expected));
        TravelBudgetAllocations actual = repo.findById(id).orElse(null);
        assertEquals(expected, actual);
    }

    
}
