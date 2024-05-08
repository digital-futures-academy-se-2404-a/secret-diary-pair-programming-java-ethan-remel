package com.secretdiary.test;

import com.secretdiary.app.Diary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestSecretDiary {

    @Nested
    @DisplayName("Diary entry tests")
    class DiaryEntryTests {

        @Test
        public void testEntriesArrayIncrementsBy1WhenValidEntryAdded() {
            // Arrange
            Diary testDiary = new Diary();
            // Act
            testDiary.addEntry("Test entry");
            // Assert
            assertEquals(1, testDiary.getEntries().size());
        }

        @Test
        public void testEntriesArrayContainsTheCorrectEntry() {
            //Arrange
            Diary testDiary = new Diary();
            // Act
            testDiary.addEntry("Test entry");
            // Assert
            assertEquals("Test entry", testDiary.getEntry(0));
        }

        @Test
        public void canAddMoreThan1EntryToDiary() {
            // Arrange
            Diary testDiary = new Diary();
            // Act
            testDiary.addEntry("Test entry 1");
            testDiary.addEntry("Test entry 2");
            // Assert
            assertAll(
                    () -> assertEquals(2, testDiary.getEntries().size()),
                    () -> assertEquals("Test entry 1", testDiary.getEntry(0)),
                    () -> assertEquals("Test entry 2", testDiary.getEntry(1))
            );
        }

        @Test
        public void errorThrownWhenInvalidArgumentPassedToAddEntry() {
            // Arrange
            Diary testDiary = new Diary();
            //Act & Assert
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> testDiary.addEntry(null)),
                    () -> assertThrows(IllegalArgumentException.class, () -> testDiary.addEntry(""))
            );
        }
    }

    @Nested
    @DisplayName("Diary reading Tests")
    class DiaryReadingTests {

        @Test
        public void canReadSpecificEntryFromDiary() {
            // Arrange
            Diary testDiary = new Diary();
            // Act
            testDiary.addEntry("Test entry 1");
            testDiary.addEntry("Test entry 2");
            testDiary.addEntry("Test entry 3");
            // Assert
            assertEquals("Test entry 2", testDiary.getEntries().get(1));
        }

        @Test
        public void canReadAllEntriesFromDiary() {
            // Arrange
            Diary testDiary = new Diary();
            // Act
            testDiary.addEntry("Test entry 1");
            testDiary.addEntry("Test entry 2");
            testDiary.addEntry("Test entry 3");
            testDiary.addEntry("Test entry 4");
            testDiary.addEntry("Test entry 5");
            ArrayList<String> entries = testDiary.getEntries();
            // Assert
            assertAll(
                    () -> assertEquals("Test entry 1", entries.get(0)),
                    () -> assertEquals("Test entry 2", entries.get(1)),
                    () -> assertEquals("Test entry 3", entries.get(2)),
                    () -> assertEquals("Test entry 4", entries.get(3)),
                    () -> assertEquals("Test entry 5", entries.get(4))
                    
            );
        }
    }


}
