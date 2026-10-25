# Question 5: IoT Sensor Grid Telemetry Search Engine (Parallel Min/Max)

## Overview

This module partitions a simulated dense telemetry array of 50,000 data points across 4 concurrent worker threads to find the global minimum and maximum values without thread contention or locking bottlenecks.

## File Structure

- `SensorSearchEngine.java`: Abstract base class implementing `Runnable` and encapsulating array slice bounds (`startIdx`, `endIdx`).
- `ParallelMinSearch.java`: Concrete search worker discovering local minimum sensor values within an assigned array slice.
- `ParallelMaxSearch.java`: Concrete search worker discovering local maximum sensor values within an assigned array slice.
- `SensorGridMonitorApp.java`: Application splitting work partitions, orchestrating worker execution, joining threads, and performing final reduction.

## Core Concepts Implemented

- **Data-Parallel Decomposition**: Dividing an array into equal contiguous intervals across available hardware threads.
- **Contention-Free Computation**: Each thread operates exclusively on its local data slice, eliminating race conditions and lock overhead.
- **Two-Phase Map-Reduce**: Threads locally calculate partial extremes, followed by a final reduction on the main thread.
