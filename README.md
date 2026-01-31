# GitRepos

How to Build / Run App
- Run the app in android studio >> Project name - <b> GitHub Repos </b>

Architecture
- clean Architecture

1. UI
   - The Screen Github repo is in this package
   - The View Model : maintains state
2. Domain Layer
   - Contains repository (interface) & usecase [Business logic]
3. Data Layer
   - DTO's: Models to get the data from server
   - Network module
   - DI
   - Mappers - To convert DTOs to domain
   - Repository implementation: return domain models
Dependency Injection
- Creates objects
- maages lifecycle

Working: 
UI -> ViewModel
ViewModel -> UseCase
UseCase -> Repository
Repository decides where data will come from
Data layer does the work
Results flow back up

Library Used
- kotlinx.serialization: 
- Paging 3
- Retrofit
  
