# USE CASE: <number> <the name should be the goal as a short active verb phrase>

## CHARACTERISTIC INFORMATION

### Goal in Context

As a member of the World Health Organisation I need to know a variety of information about cities including

- A list of all Cities in the world organised from largest population to smallest
- All the cities in a continent organised by largest population to smallest
- All the cities in a region organised by largest population to smallest
- All the cities in a country organised by largest population to smallest
- All the cities in a district organised by largest population to smallest
- The top N populated cities in the world
- The top N populated cities in a continent
- The top N populated cities in a region
- The top N populated cities in a country
- The top N populated cities in a district
- The population of a specific city
- A city report which contains, the following, (Name, Country, District, Population)

### Scope

Company (double Check)

### Level

Primary Task

### Preconditions

*what we expect is already the state of the world*

### Success End Condition

Reports are sucessfully created on demand

### Failed End Condition

No reports are created

### Primary Actor

Member of the World Health Organisation

### Trigger

A request for city information

## MAIN SUCCESS SCENARIO

*put here the steps of the scenario from trigger to goal delivery, and any cleanup after*

1. A request for information on cities is created
2. The WHO member captures any variables, depending on the type of report requested (City name, or ID, or limit)
3. WHO member extracts the relevent reports based on variables
4. WHO member provides report to finance.

## SCHEDULE

14th April 2021 
