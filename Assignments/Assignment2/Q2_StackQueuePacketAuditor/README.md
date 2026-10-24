# Question 2: Zero-Trust Packet Symmetry Auditor (Custom Stack & Queue)

## Overview

This module implements low-level, array-backed primitive data structures from scratch (without utilizing `java.util.Stack` or `java.util.Queue`) to audit bidirectional packet symmetry (palindrome verification) for zero-trust network packet payloads. Both structures implement explicit `isEmpty()` and `isFull()` boundary validations.

## File Structure

- `TransactionStack.java`: Primitive, bounded, array-backed LIFO stack with explicit `isFull()` and `isEmpty()` checks.
- `RequestQueue.java`: Primitive, array-backed FIFO circular buffer with explicit `isFull()` and `isEmpty()` checks.
- `PacketSymmetryAuditor.java`: Driver program feeding payloads simultaneously into the stack and circular queue, comparing popped and dequeued characters to verify symmetry.

## Core Concepts Implemented

- **Buffer Boundary Safety**: Implementing `isFull()` methods to guard against memory corruption and array index out of bounds exceptions.
- **LIFO vs. FIFO Mechanics**: Verifying that a sequence matching from both ends simultaneously reveals reverse symmetry.
- **Circular Buffer Logic**: Managing boundary wraparound using pointer modulo arithmetic (`(rear + 1) % capacity`).
