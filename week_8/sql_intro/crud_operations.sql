-- ============== INSERT ================
-- Insert records into Department table
INSERT INTO Department (departmentName) VALUES
    ('Human Resources'),
    ('Information Technology'),
    ('Marketing'),
    ('Finance');

-- Insert records into Employee table
INSERT INTO Employee (employeeName, departmentId) VALUES
    ('John Doe', 1),
    ('Jane Smith', 2),
    ('Michael Johnson', 3),
    ('Emily Brown', 1),
    ('Chris Davis', 2),
    ('Sarah Wilson', 3),
    ('Robert Martinez', 4),
    ('Amanda Taylor', 1);

-- Insert records into Skill table
INSERT INTO Skill (skillName, skillLevel) VALUES
    ('Programming', 8),
    ('Marketing Strategy', 7),
    ('Database Management', 9),
    ('Project Management', 6),
    ('Communication', 8),
    ('Graphic Design', 7),
    ('Financial Analysis', 9),
    ('Human Resources Management', 8);

-- Insert records into Project table
INSERT INTO Project (projectName, departmentId) VALUES
    ('Employee Training Program', 1),
    ('Database Migration', 2),
    ('Product Launch Campaign', 3),
    ('Financial Report Automation', 4),
    ('Website Redesign', 2),
    ('Recruitment Drive', 1);

-- Insert records into EmployeeDetail table
INSERT INTO EmployeeDetail (employeeId, address, phoneNumber, SSNLastFour, departmentId) VALUES
    (1, '123 Main St, City', '123-456-7890', '1234', 1),
    (2, '456 Oak Ave, Town', '234-567-8901', '5678', 2),
    (3, '789 Elm Blvd, Village', '345-678-9012', '9012', 3),
    (4, '321 Pine Rd, City', '456-789-0123', '3456', 1),
    (5, '654 Maple Ln, Town', '567-890-1234', '6789', 2),
    (6, '987 Cedar St, Village', '678-901-2345', '2345', 3),
    (7, '210 Birch Ave, City', '789-012-3456', '4567', 4),
    (8, '543 Spruce Rd, Town', '890-123-4567', '8901', 1);

-- Insert records into EmployeeSkill table
INSERT INTO EmployeeSkill (employeeId, skillId) VALUES
    (1, 1), (1, 4),
    (2, 3), (2, 5),
    (3, 3), (3, 7),
    (4, 2), (4, 8),
    (5, 1), (5, 6),
    (6, 4), (6, 5),
    (7, 2), (7, 8),
    (8, 1), (8, 3);

-- Insert records into EmployeeProject table
INSERT INTO EmployeeProject (employeeId, projectId) VALUES
    (1, 1), (1, 4),
    (2, 2), (2, 5),
    (3, 3), (3, 6),
    (4, 1), (4, 4),
    (5, 2), (5, 3),
    (6, 5), (6, 6),
    (7, 1), (7, 2),
    (8, 3), (8, 4);


-- ============== UPDATE ================
UPDATE EmployeeDetail
SET address = '4711 Plymouth Drive, City'
WHERE employeeId = 4;

-- ============== DELETE ================
INSERT INTO Skill (skillId, skillName)
VALUES (9, 'Eating');

DELETE FROM Skill
WHERE skillName = 'Eating';