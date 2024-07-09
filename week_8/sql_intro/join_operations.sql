-- List all employees in a specific department (human resouces).
SELECT
	employeeName
FROM Department
JOIN EmployeeDetail
	ON Department.departmentId = EmployeeDetail.departmentId
JOIN Employee
	ON EmployeeDetail.employeeId = Employee.employeeId
WHERE departmentName = 'Human Resources';

-- List all projects an employee (Emily Brown) is working on.
SELECT
	projectName
FROM Employee
JOIN EmployeeProject
	ON Employee.employeeId = EmployeeProject.employeeId
JOIN Project
	ON EmployeeProject.projectId = Project.projectId
WHERE
	employeeName = 'Emily Brown';
	
-- List all the employees with skill "coding" (Programming)
SELECT
	employeeName
FROM Employee AS e
JOIN EmployeeSkill AS es
	ON e.employeeId = es.employeeId
JOIN Skill AS s
	ON es.skillId = s.skillId
WHERE
	skillName = 'Programming';
	
-- You are the DB designer, add 3 more useful queries with JOIN that can be used later.
-- 1. Ranking the highest skills of employees
SELECT
	employeeName,
	skillName,
	MAX(skillLevel) AS skillLevel
FROM Employee AS e
JOIN EmployeeSkill AS es
	ON e.employeeId = es.employeeId
JOIN Skill AS s
	ON es.skillId = s.skillId
GROUP BY
	employeeName,
	skillName
ORDER BY
	skillLevel DESC;
	
-- 2. Projects with the most amount of people working them
SELECT
	projectName,
	COUNT(employeeName)
FROM Employee
JOIN EmployeeProject
	ON Employee.employeeId = EmployeeProject.employeeId
JOIN Project
	ON EmployeeProject.projectId = Project.projectId
GROUP BY
	projectName
ORDER BY COUNT(employeeName) DESC;

-- 3. Largest Departments
SELECT
	departmentName,
	COUNT(employeeName)
FROM Department
JOIN EmployeeDetail
	ON Department.departmentId = EmployeeDetail.departmentId
JOIN Employee
	ON EmployeeDetail.employeeId = Employee.employeeId
GROUP BY
	departmentName
ORDER BY COUNT(employeeName) DESC;