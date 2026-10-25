# Question 7: Hardware Cache Locality & Memory Stride Profiler

## Overview

This module benchmarks the performance impact of CPU L1/L2/L3 cache line utilization when traversing a 2,000 × 2,000 two-dimensional matrix using Row-Major order versus Column-Major order.

## File Structure

- `CacheLocalityBenchmark.java`: Profiles Row-Major traversal (`matrix[i][j]`) against Column-Major traversal (`matrix[j][i]`), measuring execution timings and cache speedup ratios.

## Core Concepts Implemented

- **Spatial Cache Locality**: Reading adjacent memory elements stored on the same 64-byte hardware cache line.
- **Row-Major Memory Layout**: Java stores 2D arrays as arrays of array references. Iterating over inner columns access contiguous memory, maximizing cache hits.
- **Cache Misses & Striding**: Column-major iteration steps across distinct rows on each iteration, causing frequent cache misses, cache evictions, and memory bus stalls.
