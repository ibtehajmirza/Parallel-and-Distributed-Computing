# Question 3: Asynchronous Diagnostics & Telemetry Engine (Multithreading)

## Overview

This module demonstrates core Java concurrency mechanisms by instantiating and executing asynchronous background worker tasks through both the `Runnable` interface and subclassing the `Thread` class.

## File Structure

- `LogProcessorTask.java`: Worker class implementing `java.lang.Runnable`, running a 5-iteration loop with 1000 ms simulated disk I/O pauses.
- `TelemetryThread.java`: Worker class extending `java.lang.Thread`, executing a 5-iteration loop with 800 ms simulated metric probe pauses.
- `AsyncWebEngineApp.java`: Driver application displaying default thread metadata, initializing named threads, tracking lifecycle states, and orchestrating barrier joins.

## Core Concepts Implemented

- **Thread Creation Variants**: Comparing task decoupling (`Runnable`) vs. direct thread specialization (`extends Thread`).
- **Thread Lifecycle States**: Observing transitions from `NEW` to `RUNNABLE` and `TIMED_WAITING`.
- **Coordination (`join`)**: Ensuring the main supervisor thread awaits all background worker task completions before clean exit.
