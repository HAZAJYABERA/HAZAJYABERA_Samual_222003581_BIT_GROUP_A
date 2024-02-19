-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 09:21 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hazajyabera_samuel_222003581`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteStudentOrTeacher` (IN `tableName` VARCHAR(50), IN `columnName` VARCHAR(50), IN `conditionValue` VARCHAR(100))   BEGIN
    DECLARE tableNameLowercase VARCHAR(50);
    SET tableNameLowercase = LOWER(tableName);
    
    SET @deleteQuery = CONCAT('DELETE FROM ', tableNameLowercase, ' WHERE ', columnName, ' = ?');
    
    PREPARE stmt FROM @deleteQuery;
    EXECUTE stmt USING conditionValue;
    DEALLOCATE PREPARE stmt;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayAllTablesData` ()   BEGIN
    SELECT * FROM students;
    SELECT * FROM courses;
    SELECT * FROM Enrollment;
    SELECT * FROM teachers;
    SELECT * FROM attendance;
    SELECT * FROM classes;
    SELECT * FROM library;
    SELECT * FROM payments;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetStudentsInCourse` (IN `courseName` VARCHAR(100))   BEGIN
    SELECT Student_name, Email
    FROM students
    WHERE Stu_id IN (
        SELECT Stu_id
        FROM Enrollment
        WHERE Course_id = (SELECT Course_id FROM courses WHERE Course_name = courseName)
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertAttendance` (IN `studentID` INT, IN `classID` INT, IN `attendanceDate` DATE, IN `status` VARCHAR(50))   BEGIN
    INSERT INTO attendance (Stu_id, Class_id, Attendance_date, Status)
    VALUES (studentID, classID, attendanceDate, status);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertClass` (IN `classLevel` INT, IN `location` VARCHAR(20), IN `year` INT)   BEGIN
    INSERT INTO classes (Class_level, Location, Year)
    VALUES (classLevel, location, year);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertEnrollment` (IN `studentID` INT, IN `courseID` INT, IN `enrollmentDate` DATE)   BEGIN
    INSERT INTO Enrollment (Stu_id, Course_id, Enrollment_Date)
    VALUES (studentID, courseID, enrollmentDate);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertLibraryBook` (IN `title` VARCHAR(50), IN `publicationYear` DATE, IN `author` VARCHAR(30))   BEGIN
    INSERT INTO library (Title, Publication_year, Author)
    VALUES (title, publicationYear, author);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertPayment` (IN `studentID` INT, IN `paymentDate` DATE, IN `paymentAmount` INT, IN `paymentMethod` VARCHAR(50), IN `status` VARCHAR(50))   BEGIN
    INSERT INTO payments (Stu_id, Payment_date, Payment_amaunt, Payment_method, Status)
    VALUES (studentID, paymentDate, paymentAmount, paymentMethod, status);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertStudents` (IN `studentName` VARCHAR(100), IN `email` VARCHAR(50), IN `telephone` VARCHAR(10), IN `dateOfBirth` DATE, IN `nationality` VARCHAR(20), IN `gender` CHAR, IN `courseName` VARCHAR(50), IN `enrollmentDate` DATE, IN `parents` VARCHAR(100))   BEGIN
 INSERT INTO students (Student_name, Email, Telephone, Date_of_birth, Nationality, Gender, Course_name, Enrollment_date, Parents)
    VALUES (studentName, email, telephone, dateOfBirth, nationality, gender, courseName, enrollmentDate, parents);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertTeacher` (IN `teacherName` VARCHAR(100), IN `contact` VARCHAR(40), IN `email` VARCHAR(50), IN `courseName` VARCHAR(100), IN `officeHours` INT)   BEGIN
    INSERT INTO teachers (Teacher_name, Contact, Email, Course_name, Office_hours)
    VALUES (teacherName, contact, email, courseName, officeHours);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateStudentOrCourse` (IN `tableName` VARCHAR(50), IN `recordID` INT, IN `columnName` VARCHAR(50), IN `newValue` VARCHAR(100))   BEGIN
    DECLARE tableNameLowercase VARCHAR(50);
    SET tableNameLowercase = LOWER(tableName);
    
    SET @updateQuery = CONCAT('UPDATE ', tableNameLowercase, ' SET ', columnName, ' = ?', ' WHERE ', tableNameLowercase, '_id = ?');
    
    PREPARE stmt FROM @updateQuery;
    EXECUTE stmt USING newValue, recordID;
    DEALLOCATE PREPARE stmt;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `all_information`
-- (See below for the actual view)
--
CREATE TABLE `all_information` (
`table_name` varchar(8)
,`ID` int(11)
,`Name` varchar(100)
,`Email` varchar(50)
,`Telephone` varchar(11)
,`Date_of_birth` varchar(50)
,`Nationality` varchar(20)
,`Gender` char(1)
,`Course_name` varchar(50)
,`Enrollment_date` date
,`Parents` varchar(100)
,`Course_id` binary(0)
,`Course_code` binary(0)
,`Credit` binary(0)
,`Department` binary(0)
,`Enrollment_id` binary(0)
,`Teacher_id` binary(0)
,`Class_id` binary(0)
,`Attendance_id` binary(0)
,`Status` binary(0)
,`Location` binary(0)
,`Year` binary(0)
,`Title` binary(0)
,`Publication_year` binary(0)
,`Author` binary(0)
,`Payment_id` binary(0)
,`Payment_date` binary(0)
,`Payment_amaunt` binary(0)
,`Payment_method` binary(0)
);

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `Attendance_id` int(11) NOT NULL,
  `Stu_id` int(11) DEFAULT NULL,
  `Class_id` int(11) DEFAULT NULL,
  `Attendance_date` date DEFAULT NULL,
  `Status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`Attendance_id`, `Stu_id`, `Class_id`, `Attendance_date`, `Status`) VALUES
(12, 1, 1, '2023-08-01', 'Present'),
(13, 2, 2, '2023-08-01', 'Absent'),
(14, 3, 3, '2023-08-01', 'Present'),
(15, 4, 1, '2023-08-01', 'Present'),
(16, 5, 1, '2023-08-01', 'Present'),
(17, 6, 2, '2023-08-01', 'Absent');

--
-- Triggers `attendance`
--
DELIMITER $$
CREATE TRIGGER `AfterInsertattendance` AFTER INSERT ON `attendance` FOR EACH ROW BEGIN
    INSERT INTO attendance_audit (attendance_id, action, action_date)
    VALUES (NEW.attendance_id, 'INSERT', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `attendance_audit`
--

CREATE TABLE `attendance_audit` (
  `id` int(11) NOT NULL,
  `Attendance_id` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Stand-in structure for view `attendance_with_date`
-- (See below for the actual view)
--
CREATE TABLE `attendance_with_date` (
`Attendance_id` int(11)
,`Stu_id` int(11)
,`Class_id` int(11)
,`Attendance_date` date
,`Status` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `Class_id` int(11) NOT NULL,
  `Class_level` int(11) NOT NULL,
  `Location` varchar(20) NOT NULL,
  `Year` int(11) NOT NULL,
  `started_date` varchar(50) NOT NULL,
  `ended_date` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`Class_id`, `Class_level`, `Location`, `Year`, `started_date`, `ended_date`) VALUES
(1, 1, 'Room A101', 2023, '12:00', ''),
(2, 2, 'Room B202', 2023, '', ''),
(3, 1, 'Room C103', 2023, '', ''),
(4, 2, 'Room D204', 2023, '', ''),
(5, 3, 'Room E305', 2023, '', ''),
(6, 1, 'Room A101', 2023, '', ''),
(7, 1, 'Room A101', 2023, '', ''),
(8, 2, 'Room B202', 2023, '', ''),
(9, 1, 'Room C103', 2023, '', ''),
(10, 2, 'Room D204', 2023, '', ''),
(11, 3, 'Room E305', 2023, '', ''),
(12, 1, 'Room A101', 2023, '', '');

--
-- Triggers `classes`
--
DELIMITER $$
CREATE TRIGGER `AfterDeleteClasses` AFTER DELETE ON `classes` FOR EACH ROW BEGIN
    
    INSERT INTO class_audit (class_id, action, action_date)
    VALUES (OLD.class_id, 'DELETE', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `classes_audit`
--

CREATE TABLE `classes_audit` (
  `id` int(11) NOT NULL,
  `Class_id` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Stand-in structure for view `classes_with_date`
-- (See below for the actual view)
--
CREATE TABLE `classes_with_date` (
`Class_id` int(11)
,`Class_level` int(11)
,`Location` varchar(20)
,`Year` int(11)
,`started_date` varchar(50)
,`ended_date` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `combined_data`
-- (See below for the actual view)
--
CREATE TABLE `combined_data` (
`Stu_id` int(11)
,`Student_name` varchar(100)
,`Student_Email` varchar(50)
,`Student_Telephone` varchar(10)
,`Student_DOB` date
,`Student_Nationality` varchar(20)
,`Student_Gender` char(1)
,`Student_Course` varchar(50)
,`Student_Enrollment_Date` date
,`Student_Parents` varchar(100)
,`Course_id` int(11)
,`Course_Name` varchar(100)
,`Course_Code` varchar(50)
,`Course_Credit` int(11)
,`Course_Department` varchar(50)
,`Enrollment_id` int(11)
,`Enrollment_Date` date
,`Teacher_name` varchar(100)
,`Teacher_Contact` varchar(40)
,`Teacher_Email` varchar(50)
,`Teacher_Course` varchar(100)
,`Teacher_Office_Hours` int(11)
,`Attendance_id` int(11)
,`Attendance_Date` date
,`Attendance_Status` varchar(50)
,`Class_id` int(11)
,`Class_Level` int(11)
,`Class_Location` varchar(20)
,`Class_Year` int(11)
,`Book_id` int(11)
,`Book_Title` varchar(50)
,`Book_Publication_Year` date
,`Book_Author` varchar(30)
,`Payment_id` int(11)
,`Payment_Date` date
,`Payment_Amount` int(11)
,`Payment_Method` varchar(50)
,`Payment_Status` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `Course_id` int(11) NOT NULL,
  `Course_name` varchar(100) NOT NULL,
  `Course_code` varchar(50) NOT NULL,
  `Credit` int(11) NOT NULL,
  `Department` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`Course_id`, `Course_name`, `Course_code`, `Credit`, `Department`) VALUES
(1, 'Computer Science', 'CS101', 4, 'Computer Science Department'),
(2, 'Law', 'LAW201', 4, 'Law Department'),
(3, 'Business function', 'ACC2137', 3, 'Business information technology'),
(4, 'Engineering', 'ENG101', 4, 'Engineering Department'),
(5, 'Computer Science', 'CS101', 3, 'Computer Science Department'),
(6, 'Law', 'LAW201', 4, 'Law Department'),
(7, 'Business function', 'ACC2137', 3, 'Business information technology'),
(8, 'Engineering', 'ENG101', 4, 'Engineering Department');

--
-- Triggers `courses`
--
DELIMITER $$
CREATE TRIGGER `AfterUpdatecourses` AFTER UPDATE ON `courses` FOR EACH ROW BEGIN
    INSERT INTO courses_audit (course_id, action, action_date)
    VALUES (NEW.course_id, 'UPDATE', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `courses_audit`
--

CREATE TABLE `courses_audit` (
  `id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Stand-in structure for view `courses_with_credit`
-- (See below for the actual view)
--
CREATE TABLE `courses_with_credit` (
`Course_id` int(11)
,`Course_name` varchar(100)
,`Course_code` varchar(50)
,`Credit` int(11)
,`Department` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `delete_data_from_two_tables`
-- (See below for the actual view)
--
CREATE TABLE `delete_data_from_two_tables` (
`Stu_id` int(11)
,`Student_name` varchar(100)
,`Email` varchar(50)
,`Telephone` varchar(10)
,`Date_of_birth` date
,`Nationality` varchar(20)
,`Gender` char(1)
,`Course_name` varchar(50)
,`Enrollment_date` date
,`Parents` varchar(100)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `delete_teachers_with_no_students`
-- (See below for the actual view)
--
CREATE TABLE `delete_teachers_with_no_students` (
`Teacher_id` int(11)
,`Teacher_name` varchar(100)
,`Contact` varchar(40)
,`Email` varchar(50)
,`Course_name` varchar(100)
,`Office_hours` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `enrollment`
--

CREATE TABLE `enrollment` (
  `Enrollment_id` int(11) NOT NULL,
  `Stu_id` int(11) DEFAULT NULL,
  `Course_id` int(11) DEFAULT NULL,
  `Enrollment_Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `enrollment`
--

INSERT INTO `enrollment` (`Enrollment_id`, `Stu_id`, `Course_id`, `Enrollment_Date`) VALUES
(1, 1, 1, '2022-09-01'),
(2, 2, 2, '2022-08-15'),
(3, 3, 3, '2022-07-20'),
(4, 4, 1, '2023-07-20'),
(5, 5, 1, '2022-06-30'),
(6, 6, 3, '2022-08-01'),
(7, 1, 1, '2022-09-01'),
(8, 2, 2, '2022-08-15'),
(9, 3, 3, '2022-07-20'),
(10, 4, 1, '2023-07-20'),
(11, 5, 1, '2022-06-30'),
(12, 6, 3, '2022-08-01'),
(13, 1, 1, '2022-09-01');

-- --------------------------------------------------------

--
-- Table structure for table `enrollment_audit`
--

CREATE TABLE `enrollment_audit` (
  `id` int(11) NOT NULL,
  `Enrollment_id` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Stand-in structure for view `enrollment_with_date`
-- (See below for the actual view)
--
CREATE TABLE `enrollment_with_date` (
`Enrollment_id` int(11)
,`Stu_id` int(11)
,`Course_id` int(11)
,`Enrollment_Date` date
);

-- --------------------------------------------------------

--
-- Table structure for table `librarys`
--

CREATE TABLE `librarys` (
  `Book_id` int(11) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Publication_year` date NOT NULL,
  `Author` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `librarys`
--

INSERT INTO `librarys` (`Book_id`, `Title`, `Publication_year`, `Author`) VALUES
(1, 'Introduction to Programming', '2020-01-01', 'Jane Smith'),
(2, 'The Art of Mathematics', '2019-05-15', 'John Doe'),
(3, 'Business Strategies for Success', '2022-08-20', 'Emily Johnson'),
(4, 'Engineering Mechanics Handbook', '2021-03-10', 'Michael Anderson'),
(5, 'Literary Classics Collection', '2018-11-30', 'Sophia Williams');

--
-- Triggers `librarys`
--
DELIMITER $$
CREATE TRIGGER `AfterInsertlibrary` AFTER INSERT ON `librarys` FOR EACH ROW BEGIN
    INSERT INTO librarys_audit (book_id, action, action_date)
    VALUES (NEW.book_id, 'INSERT', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `librarys_audit`
--

CREATE TABLE `librarys_audit` (
  `id` int(11) NOT NULL,
  `librarys_id` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Stand-in structure for view `librarys_with_publication_date`
-- (See below for the actual view)
--
CREATE TABLE `librarys_with_publication_date` (
`Book_id` int(11)
,`Title` varchar(50)
,`Publication_year` date
,`Author` varchar(30)
);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `Payment_id` int(11) NOT NULL,
  `Stu_id` int(11) DEFAULT NULL,
  `Payment_date` date DEFAULT NULL,
  `Payment_amaunt` int(11) NOT NULL,
  `Payment_method` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`Payment_id`, `Stu_id`, `Payment_date`, `Payment_amaunt`, `Payment_method`, `Status`) VALUES
(1, 1, '2023-08-01', 1000, 'Credit Card', 'Paid'),
(2, 2, '2023-08-02', 1500, 'Bank Transfer', 'Paid'),
(3, 3, '2023-08-03', 1200, 'Cash', 'Paid'),
(4, 4, '2023-08-04', 900, 'Credit Card', 'Paid'),
(5, 5, '2023-08-05', 1800, 'Bank Transfer', 'Unpaid'),
(6, 1, '2023-08-01', 1000, 'Credit Card', 'Paid'),
(7, 2, '2023-08-02', 1500, 'Bank Transfer', 'Paid'),
(8, 3, '2023-08-03', 1200, 'Cash', 'Paid'),
(9, 4, '2023-08-04', 900, 'Credit Card', 'Paid'),
(10, 5, '2023-08-05', 1800, 'Bank Transfer', 'Unpaid');

-- --------------------------------------------------------

--
-- Table structure for table `payments_audit`
--

CREATE TABLE `payments_audit` (
  `id` int(11) NOT NULL,
  `Payment_id` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Stand-in structure for view `payments_with_date`
-- (See below for the actual view)
--
CREATE TABLE `payments_with_date` (
`Payment_id` int(11)
,`Stu_id` int(11)
,`Payment_date` date
,`Payment_amaunt` int(11)
,`Payment_method` varchar(50)
,`Status` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `studentenrollments`
-- (See below for the actual view)
--
CREATE TABLE `studentenrollments` (
`Student_name` varchar(100)
,`Course_name` varchar(100)
,`Enrollment_Date` date
);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `Stu_id` int(11) NOT NULL,
  `Student_name` varchar(100) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Telephone` varchar(10) NOT NULL,
  `Date_of_birth` date NOT NULL,
  `Nationality` varchar(20) NOT NULL,
  `Gender` char(1) DEFAULT NULL,
  `Course_name` varchar(50) DEFAULT NULL,
  `Enrollment_date` date DEFAULT NULL,
  `Parents` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`Stu_id`, `Student_name`, `Email`, `Telephone`, `Date_of_birth`, `Nationality`, `Gender`, `Course_name`, `Enrollment_date`, `Parents`) VALUES
(1, 'Emmanuel Nzeyimana', 'emmanuel.nzeyimana@example.com', '2507888888', '2000-03-12', 'Rwanda', 'M', 'Computer Science', '2022-09-01', 'Grace Nzeyimana'),
(2, 'Marie Uwase', 'marie@example.com', '2507377777', '2001-06-25', 'Rwanda', 'F', 'Law', '2022-08-15', 'Jean Uwase'),
(3, 'Fidele Niyonzima', 'fidele@example.com', '2507999999', '2000-11-10', 'Rwanda', 'M', 'Business Administration', '2022-07-20', 'Esther Niyonzima'),
(4, 'jean pierre Niyonzima', 'niyonzima@example.com', '2507999999', '2000-11-10', 'Zambia', 'M', 'Business Administration', '2022-07-25', 'Esther Niyomurinzi'),
(5, 'Grace Abijuru', 'grace@example.com', '2507999800', '2001-11-10', 'Rwanda', 'M', 'Business Administration', '2023-07-20', 'Samuel Mbarimombazi'),
(6, 'Divine Mukamana', 'divine@example.com', '2507123456', '2002-04-03', 'Uganda', 'F', 'Engineering', '2022-06-30', 'Jean Mukamana'),
(7, 'tumukunde valens', 'tumukundevalens@gmail.com', '0786954328', '2000-12-25', 'Rwandan', 'M', 'Database', '2023-07-15', 'MUKARATWA Agnus'),
(8, 'Emmanuel Nzeyimana', 'emmanuel.nzeyimana@example.com', '2507888888', '2000-03-12', 'Rwanda', 'M', 'Computer Science', '2022-09-01', 'Grace Nzeyimana'),
(9, 'Marie Uwase', 'marie@example.com', '2507377777', '2001-06-25', 'Rwanda', 'F', 'Law', '2022-08-15', 'Jean Uwase'),
(10, 'Fidele Niyonzima', 'fidele@example.com', '2507999999', '2000-11-10', 'Rwanda', 'M', 'Business Administration', '2022-07-20', 'Esther Niyonzima'),
(11, 'jean pierre Niyonzima', 'niyonzima@example.com', '2507999999', '2000-11-10', 'Zambia', 'M', 'Business Administration', '2022-07-25', 'Esther Niyomurinzi'),
(12, 'Grace Abijuru', 'grace@example.com', '2507999800', '2001-11-10', 'Rwanda', 'M', 'Business Administration', '2023-07-20', 'Samuel Mbarimombazi'),
(13, 'Divine Mukamana', 'divine@example.com', '2507123456', '2002-04-03', 'Uganda', 'F', 'Engineering', '2022-06-30', 'Jean Mukamana');

--
-- Triggers `students`
--
DELIMITER $$
CREATE TRIGGER `AfterDeletestudents` AFTER DELETE ON `students` FOR EACH ROW BEGIN
    
    INSERT INTO students_audit (Stu_id, action, action_date)
    VALUES (OLD.Stu_id, 'DELETE', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `students_audit`
--

CREATE TABLE `students_audit` (
  `id` int(11) NOT NULL,
  `Stu_id_id` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Stand-in structure for view `students_enrolled_in_2023`
-- (See below for the actual view)
--
CREATE TABLE `students_enrolled_in_2023` (
`Stu_id` int(11)
,`Student_name` varchar(100)
,`Email` varchar(50)
,`Telephone` varchar(10)
,`Date_of_birth` date
,`Nationality` varchar(20)
,`Gender` char(1)
,`Course_name` varchar(50)
,`Enrollment_date` date
,`Parents` varchar(100)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `students_enrolled_in_credit_courses`
-- (See below for the actual view)
--
CREATE TABLE `students_enrolled_in_credit_courses` (
`Stu_id` int(11)
,`Student_name` varchar(100)
,`Email` varchar(50)
,`Telephone` varchar(10)
,`Date_of_birth` date
,`Nationality` varchar(20)
,`Gender` char(1)
,`Course_name` varchar(50)
,`Enrollment_date` date
,`Parents` varchar(100)
);

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

CREATE TABLE `teachers` (
  `Teacher_id` int(11) NOT NULL,
  `Teacher_name` varchar(100) NOT NULL,
  `Contact` varchar(40) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Course_name` varchar(100) DEFAULT NULL,
  `Office_hours` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teachers`
--

INSERT INTO `teachers` (`Teacher_id`, `Teacher_name`, `Contact`, `Email`, `Course_name`, `Office_hours`) VALUES
(2, 'Michael Smith', '9876543210', 'michael@example.com', 'Engineering', 8),
(3, 'Grace Nyirabukeye', '5555555555', 'grace@example.com', 'Mathematics', 9),
(4, 'Emmanuel Bugingo', '25078543210', 'emmanuel@example.com', 'database technology', 11),
(5, 'John Doe', '6666666666', 'john.doe@example.com', 'Physics', 7),
(7, 'Laura Johnson', '1234567890', 'laura@example.com', 'Computer Science', 10),
(8, 'Michael Smith', '9876543210', 'michael@example.com', 'Engineering', 8),
(9, 'Grace Nyirabukeye', '5555555555', 'grace@example.com', 'Mathematics', 9),
(10, 'Emmanuel Bugingo', '25078543210', 'emmanuel@example.com', 'database technology', 11),
(11, 'John Doe', '6666666666', 'john.doe@example.com', 'Physics', 7),
(12, 'Michael Smith', 'michael@example.com', '9876543210', 'Engineering', 8),
(13, 'Michael Smith', '9876543210', 'michael@example.com', 'Engineering', 8);

--
-- Triggers `teachers`
--
DELIMITER $$
CREATE TRIGGER `AfterUpdateteachers` AFTER UPDATE ON `teachers` FOR EACH ROW BEGIN
    
    INSERT INTO teachers_audit (teacher_id, action, action_date)
    VALUES (NEW.teacher_id, 'UPDATE', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `teachers_audit`
--

CREATE TABLE `teachers_audit` (
  `id` int(11) NOT NULL,
  `Teacher_id` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teachers_audit`
--

INSERT INTO `teachers_audit` (`id`, `Teacher_id`, `action`, `action_date`) VALUES
(1, 12, 'UPDATE', '2024-02-19 09:37:05'),
(2, 12, 'UPDATE', '2024-02-19 09:37:08'),
(3, 12, 'UPDATE', '2024-02-19 09:37:08');

-- --------------------------------------------------------

--
-- Table structure for table `update_student_info`
--

CREATE TABLE `update_student_info` (
  `Stu_id` int(11) DEFAULT NULL,
  `Student_name` varchar(100) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Telephone` varchar(10) DEFAULT NULL,
  `Date_of_birth` date DEFAULT NULL,
  `Nationality` varchar(20) DEFAULT NULL,
  `Gender` char(1) DEFAULT NULL,
  `Course_name` varchar(50) DEFAULT NULL,
  `Enrollment_date` date DEFAULT NULL,
  `Parents` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure for view `all_information`
--
DROP TABLE IF EXISTS `all_information`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `all_information`  AS SELECT 'students' AS `table_name`, `students`.`Stu_id` AS `ID`, `students`.`Student_name` AS `Name`, `students`.`Email` AS `Email`, `students`.`Telephone` AS `Telephone`, `students`.`Date_of_birth` AS `Date_of_birth`, `students`.`Nationality` AS `Nationality`, `students`.`Gender` AS `Gender`, `students`.`Course_name` AS `Course_name`, `students`.`Enrollment_date` AS `Enrollment_date`, `students`.`Parents` AS `Parents`, NULL AS `Course_id`, NULL AS `Course_code`, NULL AS `Credit`, NULL AS `Department`, NULL AS `Enrollment_id`, NULL AS `Teacher_id`, NULL AS `Class_id`, NULL AS `Attendance_id`, NULL AS `Status`, NULL AS `Location`, NULL AS `Year`, NULL AS `Title`, NULL AS `Publication_year`, NULL AS `Author`, NULL AS `Payment_id`, NULL AS `Payment_date`, NULL AS `Payment_amaunt`, NULL AS `Payment_method` FROM `students` union all select 'courses' AS `table_name`,`courses`.`Course_id` AS `ID`,`courses`.`Course_name` AS `Course_name`,`courses`.`Course_code` AS `Course_code`,`courses`.`Credit` AS `Credit`,`courses`.`Department` AS `Department`,NULL AS `Student_name`,NULL AS `Email`,NULL AS `Telephone`,NULL AS `Date_of_birth`,NULL AS `Nationality`,NULL AS `Gender`,NULL AS `Enrollment_date`,NULL AS `Parents`,NULL AS `Stu_id`,NULL AS `Enrollment_id`,NULL AS `Teacher_id`,NULL AS `Class_id`,NULL AS `Attendance_id`,NULL AS `Status`,NULL AS `Location`,NULL AS `Year`,NULL AS `Title`,NULL AS `Publication_year`,NULL AS `Author`,NULL AS `Payment_id`,NULL AS `Payment_date`,NULL AS `Payment_amaunt`,NULL AS `Payment_method` from `courses`  ;

-- --------------------------------------------------------

--
-- Structure for view `attendance_with_date`
--
DROP TABLE IF EXISTS `attendance_with_date`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `attendance_with_date`  AS SELECT `attendance`.`Attendance_id` AS `Attendance_id`, `attendance`.`Stu_id` AS `Stu_id`, `attendance`.`Class_id` AS `Class_id`, `attendance`.`Attendance_date` AS `Attendance_date`, `attendance`.`Status` AS `Status` FROM `attendance` WHERE `attendance`.`Attendance_date` between '2023-01-01' and '2023-12-31\'2023-12-31''2023-12-31\'2023-12-31'  ;

-- --------------------------------------------------------

--
-- Structure for view `classes_with_date`
--
DROP TABLE IF EXISTS `classes_with_date`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `classes_with_date`  AS SELECT `classes`.`Class_id` AS `Class_id`, `classes`.`Class_level` AS `Class_level`, `classes`.`Location` AS `Location`, `classes`.`Year` AS `Year`, `classes`.`started_date` AS `started_date`, `classes`.`ended_date` AS `ended_date` FROM `classes` WHERE `classes`.`Year` between 2021 and 2025202520252025  ;

-- --------------------------------------------------------

--
-- Structure for view `combined_data`
--
DROP TABLE IF EXISTS `combined_data`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `combined_data`  AS SELECT `s`.`Stu_id` AS `Stu_id`, `s`.`Student_name` AS `Student_name`, `s`.`Email` AS `Student_Email`, `s`.`Telephone` AS `Student_Telephone`, `s`.`Date_of_birth` AS `Student_DOB`, `s`.`Nationality` AS `Student_Nationality`, `s`.`Gender` AS `Student_Gender`, `s`.`Course_name` AS `Student_Course`, `s`.`Enrollment_date` AS `Student_Enrollment_Date`, `s`.`Parents` AS `Student_Parents`, `c`.`Course_id` AS `Course_id`, `c`.`Course_name` AS `Course_Name`, `c`.`Course_code` AS `Course_Code`, `c`.`Credit` AS `Course_Credit`, `c`.`Department` AS `Course_Department`, `e`.`Enrollment_id` AS `Enrollment_id`, `e`.`Enrollment_Date` AS `Enrollment_Date`, `t`.`Teacher_name` AS `Teacher_name`, `t`.`Contact` AS `Teacher_Contact`, `t`.`Email` AS `Teacher_Email`, `t`.`Course_name` AS `Teacher_Course`, `t`.`Office_hours` AS `Teacher_Office_Hours`, `a`.`Attendance_id` AS `Attendance_id`, `a`.`Attendance_date` AS `Attendance_Date`, `a`.`Status` AS `Attendance_Status`, `cl`.`Class_id` AS `Class_id`, `cl`.`Class_level` AS `Class_Level`, `cl`.`Location` AS `Class_Location`, `cl`.`Year` AS `Class_Year`, `l`.`Book_id` AS `Book_id`, `l`.`Title` AS `Book_Title`, `l`.`Publication_year` AS `Book_Publication_Year`, `l`.`Author` AS `Book_Author`, `p`.`Payment_id` AS `Payment_id`, `p`.`Payment_date` AS `Payment_Date`, `p`.`Payment_amaunt` AS `Payment_Amount`, `p`.`Payment_method` AS `Payment_Method`, `p`.`Status` AS `Payment_Status` FROM (((((((`students` `s` left join `enrollment` `e` on(`s`.`Stu_id` = `e`.`Stu_id`)) left join `courses` `c` on(`e`.`Course_id` = `c`.`Course_id`)) left join `teachers` `t` on(`c`.`Course_name` = `t`.`Course_name`)) left join `attendance` `a` on(`s`.`Stu_id` = `a`.`Stu_id`)) left join `classes` `cl` on(`a`.`Class_id` = `cl`.`Class_id`)) left join `librarys` `l` on(`l`.`Book_id` = `l`.`Book_id`)) left join `payments` `p` on(`s`.`Stu_id` = `p`.`Stu_id`))  ;

-- --------------------------------------------------------

--
-- Structure for view `courses_with_credit`
--
DROP TABLE IF EXISTS `courses_with_credit`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `courses_with_credit`  AS SELECT `courses`.`Course_id` AS `Course_id`, `courses`.`Course_name` AS `Course_name`, `courses`.`Course_code` AS `Course_code`, `courses`.`Credit` AS `Credit`, `courses`.`Department` AS `Department` FROM `courses` WHERE `courses`.`Credit` between 1 and 15151515  ;

-- --------------------------------------------------------

--
-- Structure for view `delete_data_from_two_tables`
--
DROP TABLE IF EXISTS `delete_data_from_two_tables`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `delete_data_from_two_tables`  AS SELECT `students`.`Stu_id` AS `Stu_id`, `students`.`Student_name` AS `Student_name`, `students`.`Email` AS `Email`, `students`.`Telephone` AS `Telephone`, `students`.`Date_of_birth` AS `Date_of_birth`, `students`.`Nationality` AS `Nationality`, `students`.`Gender` AS `Gender`, `students`.`Course_name` AS `Course_name`, `students`.`Enrollment_date` AS `Enrollment_date`, `students`.`Parents` AS `Parents` FROM `students` WHERE `students`.`Nationality` = 'Rwanda' AND `students`.`Course_name` = 'Computer Science\'Computer Science''Computer Science\'Computer Science'  ;

-- --------------------------------------------------------

--
-- Structure for view `delete_teachers_with_no_students`
--
DROP TABLE IF EXISTS `delete_teachers_with_no_students`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `delete_teachers_with_no_students`  AS SELECT `teachers`.`Teacher_id` AS `Teacher_id`, `teachers`.`Teacher_name` AS `Teacher_name`, `teachers`.`Contact` AS `Contact`, `teachers`.`Email` AS `Email`, `teachers`.`Course_name` AS `Course_name`, `teachers`.`Office_hours` AS `Office_hours` FROM `teachers` WHERE !(`teachers`.`Teacher_id` in (select `teachers`.`Teacher_id` from `enrollment`))  ;

-- --------------------------------------------------------

--
-- Structure for view `enrollment_with_date`
--
DROP TABLE IF EXISTS `enrollment_with_date`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `enrollment_with_date`  AS SELECT `enrollment`.`Enrollment_id` AS `Enrollment_id`, `enrollment`.`Stu_id` AS `Stu_id`, `enrollment`.`Course_id` AS `Course_id`, `enrollment`.`Enrollment_Date` AS `Enrollment_Date` FROM `enrollment` WHERE `enrollment`.`Enrollment_Date` between '2023-01-01' and '2023-12-31\'2023-12-31''2023-12-31\'2023-12-31'  ;

-- --------------------------------------------------------

--
-- Structure for view `librarys_with_publication_date`
--
DROP TABLE IF EXISTS `librarys_with_publication_date`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `librarys_with_publication_date`  AS SELECT `librarys`.`Book_id` AS `Book_id`, `librarys`.`Title` AS `Title`, `librarys`.`Publication_year` AS `Publication_year`, `librarys`.`Author` AS `Author` FROM `librarys` WHERE `librarys`.`Publication_year` between '2022-01-01' and '2023-12-31\'2023-12-31''2023-12-31\'2023-12-31'  ;

-- --------------------------------------------------------

--
-- Structure for view `payments_with_date`
--
DROP TABLE IF EXISTS `payments_with_date`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `payments_with_date`  AS SELECT `payments`.`Payment_id` AS `Payment_id`, `payments`.`Stu_id` AS `Stu_id`, `payments`.`Payment_date` AS `Payment_date`, `payments`.`Payment_amaunt` AS `Payment_amaunt`, `payments`.`Payment_method` AS `Payment_method`, `payments`.`Status` AS `Status` FROM `payments` WHERE `payments`.`Payment_date` between '2023-01-01' and '2023-12-31\'2023-12-31''2023-12-31\'2023-12-31'  ;

-- --------------------------------------------------------

--
-- Structure for view `studentenrollments`
--
DROP TABLE IF EXISTS `studentenrollments`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `studentenrollments`  AS SELECT `s`.`Student_name` AS `Student_name`, `c`.`Course_name` AS `Course_name`, `e`.`Enrollment_Date` AS `Enrollment_Date` FROM ((`students` `s` join `enrollment` `e` on(`s`.`Stu_id` = `e`.`Stu_id`)) join `courses` `c` on(`e`.`Course_id` = `c`.`Course_id`))  ;

-- --------------------------------------------------------

--
-- Structure for view `students_enrolled_in_2023`
--
DROP TABLE IF EXISTS `students_enrolled_in_2023`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `students_enrolled_in_2023`  AS SELECT `students`.`Stu_id` AS `Stu_id`, `students`.`Student_name` AS `Student_name`, `students`.`Email` AS `Email`, `students`.`Telephone` AS `Telephone`, `students`.`Date_of_birth` AS `Date_of_birth`, `students`.`Nationality` AS `Nationality`, `students`.`Gender` AS `Gender`, `students`.`Course_name` AS `Course_name`, `students`.`Enrollment_date` AS `Enrollment_date`, `students`.`Parents` AS `Parents` FROM `students` WHERE `students`.`Enrollment_date` between '2023-01-01' and '2023-12-31\'2023-12-31''2023-12-31\'2023-12-31'  ;

-- --------------------------------------------------------

--
-- Structure for view `students_enrolled_in_credit_courses`
--
DROP TABLE IF EXISTS `students_enrolled_in_credit_courses`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `students_enrolled_in_credit_courses`  AS SELECT `students`.`Stu_id` AS `Stu_id`, `students`.`Student_name` AS `Student_name`, `students`.`Email` AS `Email`, `students`.`Telephone` AS `Telephone`, `students`.`Date_of_birth` AS `Date_of_birth`, `students`.`Nationality` AS `Nationality`, `students`.`Gender` AS `Gender`, `students`.`Course_name` AS `Course_name`, `students`.`Enrollment_date` AS `Enrollment_date`, `students`.`Parents` AS `Parents` FROM `students` WHERE `students`.`Stu_id` in (select `enrollment`.`Stu_id` from `enrollment` where `enrollment`.`Course_id` in (select `courses`.`Course_id` from `courses` where `courses`.`Credit` = 4))  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`Attendance_id`),
  ADD KEY `fk_attendance_students` (`Stu_id`),
  ADD KEY `fk_attendance_classes` (`Class_id`);

--
-- Indexes for table `attendance_audit`
--
ALTER TABLE `attendance_audit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`Class_id`);

--
-- Indexes for table `classes_audit`
--
ALTER TABLE `classes_audit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`Course_id`);

--
-- Indexes for table `courses_audit`
--
ALTER TABLE `courses_audit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD PRIMARY KEY (`Enrollment_id`),
  ADD KEY `fk_enrollment_students` (`Stu_id`),
  ADD KEY `fk_enrollment_courses` (`Course_id`);

--
-- Indexes for table `enrollment_audit`
--
ALTER TABLE `enrollment_audit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `librarys`
--
ALTER TABLE `librarys`
  ADD PRIMARY KEY (`Book_id`);

--
-- Indexes for table `librarys_audit`
--
ALTER TABLE `librarys_audit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`Payment_id`),
  ADD KEY `fk_payments_student_id` (`Stu_id`);

--
-- Indexes for table `payments_audit`
--
ALTER TABLE `payments_audit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`Stu_id`);

--
-- Indexes for table `students_audit`
--
ALTER TABLE `students_audit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`Teacher_id`);

--
-- Indexes for table `teachers_audit`
--
ALTER TABLE `teachers_audit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `Attendance_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `attendance_audit`
--
ALTER TABLE `attendance_audit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
  MODIFY `Class_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `classes_audit`
--
ALTER TABLE `classes_audit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `Course_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `courses_audit`
--
ALTER TABLE `courses_audit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `enrollment`
--
ALTER TABLE `enrollment`
  MODIFY `Enrollment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `enrollment_audit`
--
ALTER TABLE `enrollment_audit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `librarys`
--
ALTER TABLE `librarys`
  MODIFY `Book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `librarys_audit`
--
ALTER TABLE `librarys_audit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `Payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `payments_audit`
--
ALTER TABLE `payments_audit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `Stu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `students_audit`
--
ALTER TABLE `students_audit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `teachers`
--
ALTER TABLE `teachers`
  MODIFY `Teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `teachers_audit`
--
ALTER TABLE `teachers_audit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `fk_attendance_classes` FOREIGN KEY (`Class_id`) REFERENCES `classes` (`Class_id`),
  ADD CONSTRAINT `fk_attendance_students` FOREIGN KEY (`Stu_id`) REFERENCES `students` (`Stu_id`);

--
-- Constraints for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD CONSTRAINT `fk_enrollment_courses` FOREIGN KEY (`Course_id`) REFERENCES `courses` (`Course_id`),
  ADD CONSTRAINT `fk_enrollment_students` FOREIGN KEY (`Stu_id`) REFERENCES `students` (`Stu_id`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `fk_payments_student_id` FOREIGN KEY (`Stu_id`) REFERENCES `students` (`Stu_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
