-- Department table
CREATE TABLE Department (
    departmentId SERIAL PRIMARY KEY,
    departmentName VARCHAR(100) NOT NULL
);

-- Employee table
CREATE TABLE Employee (
    employeeId SERIAL PRIMARY KEY,
    employeeName VARCHAR(100) NOT NULL,
    departmentId INT NOT NULL REFERENCES Department(departmentId)
);

-- Skill table
CREATE TABLE Skill (
    skillId SERIAL PRIMARY KEY,
    skillName VARCHAR(100) NOT NULL,
    skillLevel INT CHECK (SkillLevel >= 1 AND SkillLevel <= 10) -- checks if it's between 1 and 10
);

-- Project table
CREATE TABLE Project (
    projectId SERIAL PRIMARY KEY,
    projectName VARCHAR(100) NOT NULL,
    departmentId INT NOT NULL REFERENCES Department(departmentId)
);

-- EmployeeDetail table
CREATE TABLE EmployeeDetail (
    employeeId INT PRIMARY KEY REFERENCES Employee(employeeId),
    address VARCHAR(255),
    phoneNumber VARCHAR(20),
    SSNLastFour VARCHAR(4),
	departmentId INT REFERENCES Department(departmentId)
);

-- EmployeeSkill table (Many-to-Many relationship between Employee and Skill)
CREATE TABLE EmployeeSkill (
    employeeId INT REFERENCES Employee(employeeId),
    skillId INT REFERENCES Skill(skillId),
    PRIMARY KEY (employeeId, skillId)
);

-- EmployeeProject table (Many-to-Many relationship between Employee and Project)
CREATE TABLE EmployeeProject (
    employeeId INT REFERENCES Employee(employeeId),
    projectId INT REFERENCES Project(projectId),
    PRIMARY KEY (employeeId, projectId)
);