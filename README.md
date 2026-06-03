# Question-Service
# Question Service

Question Service is a Spring Boot microservice developed as part of a Quiz Application based on Microservices Architecture.

## Features

* Manage quiz questions (CRUD operations)
* Fetch questions by category and difficulty level
* Expose REST APIs for Quiz Service consumption
* Oracle SQL database integration using Spring Data JPA
* Service registration and discovery using Eureka Client
* Inter-service communication through OpenFeign

## Tech Stack

* Java 8/17
* Spring Boot
* Spring Data JPA
* Oracle SQL
* Eureka Discovery Client
* OpenFeign
* Maven

## Architecture

Question Service acts as the question repository for the Quiz Application. It stores and manages question data and exposes APIs that are consumed by the Quiz Service to generate quizzes and evaluate responses.
