# PROLAN Project — Phase 3: Command-Line Data Processor
**Course:** PROLAN (Programming Languages)

---

## Overview

An Industrial Sensor Data Processor built in both **Java** and **Python**. Both versions
ingest mixed sensor data (string IDs + numeric readings), apply threshold filtering, and
display a formatted summary table with computed statistics.

---

## How to Run

### Java
Requires: Java Development Kit (JDK)
```
cd java
javac SensorProcessor.java
java SensorProcessor
```

### Python
Requires: Python 3
```
cd python
python sensor_processor.py
```

---

## Compilation / Execution Model

### Java — Two-Step: Compile then Execute

**Step 1 – javac (Compiler)**
Reads the `.java` source and translates it into **bytecode** (`.class` file).
Bytecode is platform-independent — not native machine code, but an intermediate
instruction set designed for the Java Virtual Machine.

**Step 2 – JVM (Runtime)**
Loads the `.class` file and either interprets the bytecode or compiles hot paths
to native machine code via the **Just-In-Time (JIT)** compiler (e.g., HotSpot JVM).

Key traits:
- *Write Once, Run Anywhere* — same `.class` runs on any OS with a JVM
- **Static typing** — type errors caught at compile time, before the program runs
- Automatic memory management via **Garbage Collector**

---

### Python — Interpreted with Implicit Compilation

**Stage 1 – Implicit Bytecode Compilation**
When a `.py` file is run, CPython silently compiles it into bytecode (`.pyc`)
stored in `__pycache__/`. No separate compile command is needed.

**Stage 2 – CPython VM Execution**
The bytecode is executed line-by-line at runtime. Standard CPython has no JIT
compiler, making it generally slower than Java for CPU-heavy tasks.

Key traits:
- **Dynamic typing** — variables hold any type; no declaration needed
- Type errors only surface at **runtime** when the line is reached
- No build step — fast for prototyping and scripting

---

## Side-by-Side Comparison

| Feature              | Java                   | Python               |
|----------------------|------------------------|----------------------|
| Compile step         | Explicit (`javac`)     | Implicit / hidden    |
| Execution engine     | JVM + JIT              | CPython VM (no JIT)  |
| Typing discipline    | Static (compile-time)  | Dynamic (runtime)    |
| Type error detected  | Before running         | While running        |
| Portability unit     | `.class` file          | `.py` source file    |
| Speed (general)      | Faster (JIT-optimized) | Slower (interpreted) |
| Ease of use          | More verbose setup     | Faster to write/run  |
