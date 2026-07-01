# DetoxFocus - AI Agent Configuration

## Project Overview

Android app for digital detox and productivity. Users can block distracting apps, manage tasks with gamification (coins, streaks, levels), and view analytics dashboards.

**Target**: Android 8.0+ (API 26) | **Compile**: API 35 | **Kotlin**: 2.0.20 | **Compose**: 2024.09

---

## Tech Stack

| Layer | Technology |
|-------|------------|
| UI | Jetpack Compose + Material3 |
| State | MVVM + StateFlow |
| DI | Hilt 2.51.1 |
| DB | Room 2.6.1 |
| Background | WorkManager 2.9.1 |
| Navigation | Navigation Compose |
| Billing | Google Play Billing 7.0+ |
| Testing | JUnit5 + Turbine + Compose Testing |

---

## Project Structure

```
app/src/main/java/com/tonidev/detoxfocus/
├── di/                          # Hilt modules
├── data/
│   ├── local/
│   │   ├── entity/              # Room entities
│   │   ├── dao/                 # Data Access Objects
│   │   └── database/            # Database class
│   └── repository/              # Repository implementations
├── domain/
│   ├── model/                   # Domain models
│   ├── usecase/                 # Use cases
│   └── repository/              # Repository interfaces
├── presentation/
│   ├── theme/                   # Colors, Typography, Theme
│   ├── components/              # Reusable composables
│   ├── navigation/              # NavGraph, Routes
│   └── screens/
│       ├── home/                # Home screen
│       ├── dashboard/           # Analytics dashboard
│       ├── tasks/               # Task management
│       ├── blocking/            # App blocking
│       └── settings/            # Settings
└── util/                        # Extensions, helpers
```

---

## Commands

### Build
```bash
./gradlew assembleDebug
./gradlew assembleRelease
```

### Test
```bash
./gradlew test                    # Unit tests
./gradlew connectedAndroidTest   # Instrumented tests
./gradlew testDebugUnitTest      # Debug unit tests only
```

### Lint & Quality
```bash
./gradlew lint                   # Android Lint
./gradlew ktlintCheck            # Kotlin lint
./gradlew detekt                 # Static analysis
```

### Clean
```bash
./gradlew clean
```

---

## Boundaries

### ALWAYS DO
- Use Jetpack Compose for ALL UI (NO XML layouts)
- Use StateFlow (NOT LiveData) for state management
- Use `collectAsStateWithLifecycle()` in composables
- Use `@HiltViewModel` for ViewModels
- Use `viewModelScope` for coroutines
- Use Room DAOs returning `Flow<T>` for queries
- Use `Dispatchers.IO` for database/network operations
- Use `Dispatchers.Main` for UI updates
- Use `suspend` functions in repositories
- Write unit tests for ViewModels
- Use `kapt` → prefer `ksp` for annotation processing
- Use sealed classes for UI state: `Loading`, `Success`, `Error`
- Use `rememberSaveable` for UI state that survives config changes
- Scope ViewModels to screen-level composables only
- Use `LaunchedEffect` for side effects
- Use `Modifier` parameters (not internal state)
- Use Material3 components only
- Handle loading, error, and empty states in every screen

### ASK FIRST
- Adding new dependencies
- Modifying build.gradle.kts
- Changing ProGuard rules
- Modifying AndroidManifest.xml permissions
- Using Reflection or generics
- Creating new database migrations
- Implementing AccessibilityService
- Modifying navigation graph structure
- Using third-party libraries not in current stack

### NEVER DO
- **NO XML layouts** (use Compose only)
- **NO Fragments** (use Compose Navigation)
- **NO LiveData** (use StateFlow)
- **NO GlobalScope** (use viewModelScope or lifecycleScope)
- **NO `!!` operator** (handle nulls safely)
- **NO `var` in data classes** (use immutable)
- **NO hard-coded strings** (use resources)
- **NO hard-coded colors** (use theme)
- **NO Context in ViewModels** (use Hilt)
- **NO `runBlocking`** (use suspend functions)
- **NO business logic in composables** (use ViewModel)
- **NO direct Room calls in UI** (use Repository)
- **NO `remember` for business logic** (only UI state)
- **NO deprecated APIs** (use latest stable versions)
- **NO commits to main branch** (use feature branches)
- **NO secrets in code** (use local.properties or BuildConfig)
- **NO memory leaks** (cancel coroutines properly)

---

## Code Style

### Kotlin
- Use `kotlin` DSL for Gradle (`.kts`)
- Use `data class` for models
- Use `sealed class/interface` for UI state
- Use `object` for singletons
- Use `extension functions` for utilities
- Use `when` expressions (not if-else chains)
- Use `?.let` for null safety
- Use `suspend` for async functions
- Use `Flow<T>` for reactive streams

### Compose
- One composable per file
- File naming: `ScreenName.kt` for screens
- File naming: `ComponentName.kt` for components
- Use `@Composable` annotation on all UI functions
- Use `@Preview` for all composables
- Use `Modifier` as first parameter
- Use `contentPadding` for Scaffold
- Use `LazyColumn`/`LazyRow` for lists
- Use `key` in lazy lists for performance

### Architecture
- Screen = Composable + ViewModel
- ViewModel exposes `UiState<T>` via `StateFlow`
- Use cases handle business logic
- Repositories abstract data sources
- DI via Hilt modules

### Naming
- Screens: `XxxScreen.kt` (e.g., `DashboardScreen.kt`)
- ViewModels: `XxxViewModel.kt` (e.g., `DashboardViewModel.kt`)
- Use cases: `XxxUseCase.kt` (e.g., `GetTasksUseCase.kt`)
- DAOs: `XxxDao.kt` (e.g., `TaskDao.kt`)
- Entities: `XxxEntity.kt` (e.g., `TaskEntity.kt`)
- Models: `Xxx.kt` (e.g., `Task.kt`)

---

## Git Workflow

### Branch Naming
```
feature/xxx     - New features
fix/xxx         - Bug fixes
refactor/xxx    - Code refactoring
test/xxx        - Adding tests
docs/xxx        - Documentation
```

### Ticket Flow
1. Create branch from `main`: `git checkout -b feature/xxx`
2. Make changes (atomic commits)
3. Run tests: `./gradlew testDebugUnitTest`
4. Run lint: `./gradlew lint`
5. Push branch: `git push -u origin feature/xxx`
6. Create PR with description
7. Squash merge to main after review

### Commit Messages
```
type(scope): description

Types: feat, fix, refactor, test, docs, chore
Scope: ui, data, domain, di, nav, util
Example: feat(dashboard): add hourly usage chart
```

---

## Testing Requirements

### Unit Tests
- Test all ViewModels
- Test all UseCases
- Test all Repositories (with fakes)
- Test domain models

### Test Structure
```kotlin
class ExampleViewModelTest {
    @Test
    fun `when action, then state updates`() = runTest {
        // Given
        // When
        // Then
    }
}
```

### Test Tools
- JUnit5 for test framework
- Turbine for Flow testing
- Mockk for mocking
- Compose Testing for UI tests

---

## Security Rules

- **NEVER** commit `google-services.json`
- **NEVER** commit API keys or secrets
- Use `local.properties` for sensitive data
- Use `BuildConfig` for build-time secrets
- Validate all user input
- Use HTTPS for all network calls
- Implement proper error handling
- Use ProGuard/R8 for release builds

---

## Android-Specific Rules

### AccessibilityService
- Only request when user explicitly enables
- Explain permission clearly in UI
- Handle service disconnection gracefully
- Do not track sensitive user data

### WorkManager
- Use `PeriodicWorkRequestBuilder` for recurring tasks
- Use `OneTimeWorkRequestBuilder` for single tasks
- Handle work cancellation properly
- Use unique work names

### Room
- Always use migrations
- Test database queries
- Use `@Transaction` for multi-table operations
- Return `Flow<T>` from DAOs

### Navigation
- Use type-safe routes (sealed class)
- Pass minimal data between screens
- Handle back navigation properly
- Use deep links only when needed

---

## Performance Rules

- Use `derivedStateOf` for computed values
- Use `LazyColumn` for large lists
- Use `key` in lazy lists
- Avoid recomposition hotspots
- Use `@Stable`/`@Immutable` for stable classes
- Use `remember` for expensive computations
- Use `graphicsLayer` for animations
- Profile before optimizing

---

## PRD Feature Priorities

Based on PRD v1.0:

### Phase 1 (MVP - Week 1-2)
1. User authentication (Firebase Auth)
2. Home screen with quick actions
3. Basic app blocking (AccessibilityService)
4. Simple task list
5. Basic settings

### Phase 2 (Core - Week 3-4)
1. Analytics dashboard
2. Gamification (coins, streaks)
3. Advanced blocking schedules
4. Notification system

### Phase 3 (Premium - Week 5-6)
1. Subscription system (Google Play Billing)
2. Advanced analytics
3. Priority support
4. Theme customization

### Phase 4 (Polish - Week 7-8)
1. Onboarding flow
2. Performance optimization
3. Testing & QA
4. Store listing

---

## Notes

- Theme: Dark mode only (pure black #0B0B0F)
- Accents: Emerald green (#2ECC71) and Red (#FF3B30)
- Typography: Clean sans-serif
- Animations: Subtle, functional
- Offline-first: Room as source of truth
- Target: 60fps UI performance
- Minimize APK size (<15MB target)

---

*Last updated: 2026-07-01*
*Project: DetoxFocus v1.0*
*Author: tm210608*