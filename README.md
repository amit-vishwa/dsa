# Data Structures and Algorithms Learning Archive

A large Java practice repository covering data structures, algorithms, problem-solving patterns, and introductory low-level design. It is retained as a personal learning and revision archive rather than presented as a production application.

## Repository structure

The Maven project is located in `bosscoderacademy/`. Its source tree contains 584 Java files organized into:

- `prerequisites` — Java basics, arrays, matrices, sorting, stacks, queues, and linked lists.
- `module/one` — arrays and mathematics, binary search, bit manipulation, recursion, backtracking, sorting, and related assignments.
- `module/two` — two pointers, hashing, linked lists, stacks, queues, trees, heaps, graphs, greedy algorithms, and dynamic programming.
- `module/three` — low-level-design principles and common creational, structural, and behavioral patterns.

Many topics include separate lecture, notes, assignment, implementation-lab, or exam examples. Individual classes generally use a `main` method to demonstrate an approach.

## Requirements and build

- JDK 21
- Maven 3.x

```bash
cd bosscoderacademy
mvn compile
```

The source uses Java 21 sequenced-collection methods such as `getFirst`, `getLast`, `removeLast`, and `reversed`; compilation on Java 17 is therefore unsupported. There is currently no automated test suite, so examples should be evaluated individually when revisiting a topic.

## Repository hygiene

- Java sources use the `.java` extension; obsolete extensionless snapshots have been removed because their later named versions and full history remain available.
- Generated classes, Maven output, and IDE-specific configuration are ignored.
- No credentials or external services are required.

## Status

This is educational material accumulated during coursework and practice. Solutions may prioritize illustrating an approach over production-grade APIs, validation, or optimization. When using the repository for revision, compare each solution with current problem constraints and add tests before modifying algorithm behavior.
