# Question 4: Quantitative Portfolio Risk Assessment (Fork/Join Framework)

## Overview

This module parallelizes heavy financial analytics using Java's Fork/Join framework (`ForkJoinPool`). It computes portfolio risk aggregations and executes in-place stress test adjustments across 10,000 synthetic financial assets using a divide-and-conquer approach.

## File Structure

- `ParallelRiskCalculator.java`: Subclasses `RecursiveTask<Double>` to recursively break arrays into subtasks (threshold: 1,000 items) and aggregate total asset valuation.
- `PortfolioThresholdTask.java`: Subclasses `RecursiveAction` to recursively identify high-risk assets (> $700.0) and mutate values in place with a 5% stress penalty.
- `ForkJoinPortfolioApp.java`: Benchmark driver creating datasets, invoking parallel pool routines, and timing execution efficiency.

## Core Concepts Implemented

- **Divide-and-Conquer Parallelism**: Halving problem sizes recursively to maximize multithreaded resource saturation.
- **`RecursiveTask` vs. `RecursiveAction`**: Managing computations that return computed results versus tasks that mutate shared structures in-place.
- **Work-Stealing Scheduler**: Leveraging thread pools where idle worker threads steal partitioned subtasks from busy worker deques.
