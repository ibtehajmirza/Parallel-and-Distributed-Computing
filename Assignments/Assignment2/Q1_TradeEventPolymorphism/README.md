# Question 1: High-Frequency Trading Engine (Dynamic Polymorphism)

## Overview

This module simulates a high-frequency trading (HFT) ingestion engine. It standardizes disparate market data feeds (FIX Protocol and Reuters Market Quotes) into a common object model using Object-Oriented Programming (OOP) inheritance and dynamic runtime polymorphism.

## File Structure

- `TradeEvent.java`: Superclass containing baseline event attributes (`senderId`, `timestamp`, `basePrice`) and a default `dispatch()` method.
- `FIXOrderEvent.java`: Subclass modeling buy/sell order transactions, computing exchange fees (0.15%), and overriding `dispatch()`.
- `ReutersQuoteEvent.java`: Subclass modeling real-time market data quotes, computing the bid-ask spread, and overriding `dispatch()`.
- `TradingEngineApp.java`: Driver application utilizing superclass reference handles to demonstrate polymorphic invocation at runtime.

## Core Concepts Implemented

- **Inheritance (`extends`)**: Code reusability via superclass state extraction.
- **Constructor Chaining (`super`)**: Proper propagation of immutable timestamps and pricing data.
- **Dynamic Method Overriding (`@Override`)**: Runtime selection of specialized behaviors without using conditional `if-else` blocks.
