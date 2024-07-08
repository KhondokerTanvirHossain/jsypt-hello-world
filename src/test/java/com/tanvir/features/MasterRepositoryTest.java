package com.tanvir.features;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.test.StepVerifier;
@DataR2dbcTest
class MasterRepositoryTest {

        @Autowired
        private MasterRepository masterRepository;

        @BeforeEach
        void setUp() {
            // Setup data for testing if necessary
        }

        @Test
        void findAllShouldReturnNotEmptyResults() {
            StepVerifier.create(masterRepository.findAll())
                .expectNextCount(3) // Assuming there's at least one entry in the database for testing
                .verifyComplete();
        }

        @Test
        void findByIdWithValidIdShouldReturnCorrectEntity() {
            String validId = "validId"; // Replace with an actual ID that exists in your test database
            StepVerifier.create(masterRepository.findById(validId))
                .expectNextMatches(masterEntity -> masterEntity.getId().equals(validId))
                .verifyComplete();
        }

        @Test
        void findByIdWithInvalidIdShouldReturnEmpty() {
            String invalidId = "invalidId";
            StepVerifier.create(masterRepository.findById(invalidId))
                .verifyComplete();
        }

        @Test
        void saveShouldPersistEntity() {
            MasterEntity newEntity = new MasterEntity();
            newEntity.setId("newId");
            newEntity.setName("New Entity"); // Assuming MasterEntity has a name field

            StepVerifier.create(masterRepository.save(newEntity))
                .expectNextMatches(masterEntity -> masterEntity.getId().equals("newId") && masterEntity.getName().equals("New Entity"))
                .verifyComplete();
        }

        @Test
        void deleteByIdShouldRemoveEntity() {
            String entityId = "entityIdToDelete"; // Replace with an actual ID to delete
            StepVerifier.create(masterRepository.deleteById(entityId))
                .verifyComplete();

            StepVerifier.create(masterRepository.findById(entityId))
                .verifyComplete(); // Verifies that the entity is indeed deleted
        }
}
