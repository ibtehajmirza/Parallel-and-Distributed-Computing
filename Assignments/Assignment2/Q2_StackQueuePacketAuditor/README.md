# Question 2: Zero-Trust Packet Symmetry Auditor (Custom Stack & Queue)

## Overview

This module implements low-level, array-backed primitive data structures from scratch (without utilizing `java.util.Stack` or `java.util.Queue`) to audit bidirectional packet symmetry (palindrome verification) for zero-trust network packet payloads.

## File Structure

- `TransactionStack.java`: Primitive, bounded, array-backed LIFO (Last-In, First-Out) stack with explicit index bounds checking.
- `RequestQueue.java`: Primitive, array-backed FIFO (First-In, First-Out) circular buffer tracking front/rear pointers and element counts.
- `PacketSymmetryAuditor.java`: Driver program feeding payloads simultaneously into the stack and circular queue, comparing popped and dequeued characters to verify symmetry.

## Core Concepts Implemented

- **LIFO vs. FIFO Mechanics**: Verifying that a sequence matching from both ends simultaneously reveals reverse symmetry.
- **Circular Buffer Logic**: Managing boundary wraparound using pointer modulo arithmetic (`(rear + 1) % capacity`).
- **Memory Predictability**: Avoiding object allocation overhead and GC pauses by using raw fixed-size primitive arrays.
