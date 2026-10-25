# Question 6: E-Commerce Inventory Concurrency Benchmark

## Overview

This module conducts a performance benchmark between coarse-grained synchronization (`Collections.synchronizedMap`) and fine-grained lock-striped concurrency (`ConcurrentHashMap`) under heavy multithreaded read/write workloads (10 threads, 500,000 total operations).

## File Structure

- `InventoryCatalogManager.java`: Complete benchmark test suite executing identical thread counts, updates, and key updates against both map implementations to measure execution time and throughput.

## Core Concepts Implemented

- **Coarse-Grained Locking (`synchronizedMap`)**: A single object-level lock serializes every read and write, causing lock contention and high latency under load.
- **Fine-Grained Concurrency (`ConcurrentHashMap`)**: Bucket-level striping and lock-free Compare-And-Swap (CAS) operations enable concurrent modifications across distinct keys.
- **Throughput Metrics**: Evaluating parallel efficiency by calculating operations completed per second (`ops/sec`).
