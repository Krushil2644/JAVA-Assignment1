-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS deforestation_db;

-- Switch to the database
USE deforestation_db;

-- Drop the table if it exists (optional for development)
DROP TABLE IF EXISTS deforestation_data;

-- Create the deforestation_data table
CREATE TABLE deforestation_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    year INT NOT NULL,
    area_affected DECIMAL(10, 2) NOT NULL,
    cause VARCHAR(100) NOT NULL,
    description TEXT
);

-- Insert sample data into the table
INSERT INTO deforestation_data (year, area_affected, cause, description)
VALUES
    (2021, 100.50, 'Logging', 'Description of logging impact'),
    (2022, 150.75, 'Agriculture', 'Description of agriculture impact'),
	(2023, 75.25, 'Urbanization', 'Description of urbanization impact'),
	(2024, 85.60, 'Mining', 'Description of mining impact'),
	(2025, 120.30, 'Infrastructure', 'Description of infrastructure impact'),
	(2026, 95.40, 'Wildfires', 'Description of wildfires impact');

    

-- Verify data insertion
SELECT * FROM deforestation_data;
