PROLAN Project - Phase 3 (Java)
================================

HOW TO COMPILE AND RUN
-----------------------
1. Open a terminal in this folder.
2. Compile:   javac SensorProcessor.java
3. Run:       java SensorProcessor


COMPILATION / EXECUTION MODEL - Java (JVM)
-------------------------------------------
Java uses a TWO-STEP process:

Step 1 – Compilation (javac)
  The Java compiler (javac) reads the human-readable source code (.java)
  and translates it into platform-independent BYTECODE stored in a .class
  file.  Bytecode is NOT native machine code; it is an intermediate
  instruction set designed for the Java Virtual Machine.

Step 2 – Execution (JVM)
  The Java Virtual Machine (JVM) loads the .class file at runtime and
  either INTERPRETS the bytecode instruction-by-instruction, or compiles
  hot code paths to native machine code via the Just-In-Time (JIT)
  compiler, depending on the JVM implementation (e.g., HotSpot).

Key characteristics:
  - "Write Once, Run Anywhere": the same .class file runs on any OS that
    has a JVM installed.
  - Static typing: data types are checked at COMPILE time, so type errors
    are caught before the program ever runs.
  - Memory is managed automatically by the Garbage Collector.

How this differs from Python:
  Python skips the explicit compile step visible to the programmer.
  The interpreter reads source (.py), compiles it to bytecode (.pyc)
  internally, then executes it line-by-line through the CPython VM.
  Type errors in Python are only discovered at RUNTIME, because Python
  is dynamically typed.  Java's ahead-of-time compilation catches type
  mistakes much earlier.
