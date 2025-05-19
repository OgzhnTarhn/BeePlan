# BeePlan

**Automated Course Scheduling Tool**

BeePlan is a Java-based command-line application designed to generate conflict-free course schedules for university departments and classes. It processes faculty availability and room constraints to produce optimal timetables.

## Features

- **Conflict Detection**: Ensures no overlapping assignments for students, instructors, or rooms.
- **Faculty Availability**: Respects individual instructor time constraints.
- **Room Allocation**: Assigns courses to available rooms considering capacity and equipment requirements.
- **Batch Input**: Reads course, instructor, and room data from formatted text files.
- **Scalability**: Handles large datasets through efficient use of Java collections.

## Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/OgzhnTarhn/BeePlan.git
   cd BeePlan
   ```
2. **Build with Maven**
   ```bash
   mvn clean compile
   ```
3. **Optional: Create executable JAR**
   ```bash
   mvn package
   # The resulting JAR will be in target/BeePlan-1.0.jar
   ```

## Usage

The application expects three input files in the working directory:

- `courses.txt`: List of course codes and metadata
- `instructors.txt`: Instructor names and availability slots
- `rooms.txt`: Room identifiers and capacities

**Run from compiled classes:**
```bash
java -cp target/classes com.beeplan.Main courses.txt instructors.txt rooms.txt
```

**Run from JAR:**
```bash
java -jar target/BeePlan-1.0.jar courses.txt instructors.txt rooms.txt
```

The program outputs a `schedule.txt` file containing the finalized timetable in a human-readable format.

## File Formats

- **courses.txt**
  ```
  CS101,Introduction to Computer Science,3
  MA202,Advanced Mathematics,4
  ```
- **instructors.txt**
  ```
  Dr. Smith: Mon 9-12, Wed 14-17
  Prof. Lee: Tue 10-12, Thu 13-16
  ```
- **rooms.txt**
  ```
  R101,35
  Lab1,20
  ```

## Technologies

- Java 17
- Maven
- Java Collections Framework

## Contributing

1. Fork the repository
2. Create a new branch (`git checkout -b feature-name`)
3. Make your changes and commit (`git commit -m "Add new feature"`)
4. Push to the branch (`git push origin feature-name`)
5. Open a Pull Request

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
