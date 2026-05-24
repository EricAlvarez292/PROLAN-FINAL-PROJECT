PROLAN Project - Phase 3 (Python)
==================================

HOW TO RUN
----------
1. Open a terminal in this folder.
2. Run:  python sensor_processor.py


COMPILATION / EXECUTION MODEL - Python (CPython Interpreter)
--------------------------------------------------------------
Python uses a SINGLE visible step from the programmer's perspective,
but internally performs two stages:

Stage 1 – Implicit Compilation
  When you run a .py file, the CPython interpreter automatically
  compiles the source code to BYTECODE (.pyc files stored in
  __pycache__/).  This step is hidden; the programmer never invokes
  a separate compiler command.

Stage 2 – Interpretation by the CPython VM
  The CPython Virtual Machine reads the bytecode and EXECUTES it
  line-by-line at runtime.  There is no Just-In-Time (JIT) compiler
  in standard CPython, so Python programs generally run slower than
  compiled Java bytecode with JIT optimization.

Key characteristics:
  - Dynamic typing: variables hold any type; types are checked at
    RUNTIME, not before the program runs.
  - Errors (including type errors) are only discovered when the
    interpreter actually reaches the offending line.
  - No build step needed — makes rapid prototyping very fast.

How this differs from Java:
  Java requires an explicit compile step (javac) that produces
  platform-independent bytecode BEFORE execution.  Its static type
  system catches type mismatches at compile time, not runtime.
  The JVM's JIT compiler also optimizes hot code paths to native
  machine code during execution, which can make Java significantly
  faster than Python for computation-heavy tasks.
