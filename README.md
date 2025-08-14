# 🚀 CryptoCurrency Tracker App

[![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Material Design](https://img.shields.io/badge/Material%20Design-757575?style=for-the-badge&logo=material-design&logoColor=white)](https://material.io/design)

## 📱 Overview

A modern cryptocurrency tracking application built with cutting-edge Android development technologies. This app was developed as a final graduation project for the Information Technology Institute (ITI), showcasing advanced Android development skills with Material Design 3 and modern architectural patterns.

### ✨ Key Features

- 📊 **Real-time Price Tracking**: Live cryptocurrency prices with up-to-date market data
- 🔍 **Smart Search**: Instant search through thousands of cryptocurrencies
- 🌙 **Dynamic Theming**: Complete dark/light mode support with smooth transitions
- 📱 **Modern Flat Design**: Clean, contemporary UI with Material Design 3
- 🚀 **Advanced Architecture**: Clean Architecture with MVVM pattern implementation
- 🔄 **Robust Error Handling**: Comprehensive network error management and user feedback
- 🎨 **Custom Components**: Beautiful, reusable UI components with flat design principles
- 💾 **HTML Content Processing**: Clean rendering of cryptocurrency descriptions without HTML tags

## 🛠️ Tech Stack

### 🏗️ Architecture & Design Patterns
- **Clean Architecture** - Clear separation of concerns across layers
- **MVVM Pattern** - Reactive UI state management
- **Repository Pattern** - Centralized data access layer
- **Use Cases** - Isolated business logic implementation
- **Single Source of Truth** - Unidirectional data flow

### 🎨 UI & Design
- **Jetpack Compose** - Modern declarative UI toolkit
- **Material Design 3** - Latest Google design system
- **Flat Design** - Clean, shadow-free modern aesthetics
- **Custom Theme System** - Dynamic light/dark theme switching
- **Feather Icons** - Beautiful, lightweight icon library
- **Responsive Design** - Adaptive layouts for different screen sizes

### 🌐 Networking & Data
- **Retrofit** - Type-safe HTTP client for REST API consumption
- **Gson** - JSON serialization/deserialization
- **Coroutines** - Asynchronous programming with structured concurrency
- **StateFlow** - Reactive state management
- **CoinPaprika API** - Reliable cryptocurrency data source

### 🔧 Dependency Injection & Tools
- **Dagger Hilt** - Compile-time dependency injection
- **Navigation Compose** - Type-safe navigation between screens
- **JSoup** - HTML parsing and content cleaning
- **KSP** - Kotlin Symbol Processing for faster builds

## 📋 Requirements

- **Android Studio**: Iguana 2023.2.1 or newer
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)
- **Kotlin**: 1.9.0+
- **JDK**: 17
- **Gradle**: 8.0+

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/CryptoCurrencyApp.git
cd CryptoCurrencyApp
```

### 2. Open in Android Studio
- Launch Android Studio
- Select "Open an existing project"
- Navigate to the project folder and open it

### 3. Sync Project
```bash
# In Android Studio
File → Sync Project with Gradle Files
```

### 4. Run the Application
- Select a device or emulator
- Click the Run button (▶️) or press Shift+F10

## 📱 Screenshots & Features

### 🏠 Main Screen
- **Cryptocurrency List**: Real-time price display with ranking
- **Smart Search Bar**: Instant filtering with search suggestions
- **Theme Toggle**: Seamless switching between light/dark modes
- **Modern Cards**: Flat design with clean typography and status indicators

### 📊 Coin Details Screen
- **Comprehensive Information**: Detailed coin data and market statistics
- **Clean Description**: HTML-free content rendering for better readability
- **Team Information**: Developer and team member details with modern avatars
- **Tags System**: Categorized labels with color-coded flat design
- **Active Status**: Real-time activity indicators

### 🌙 Theme System
- **Light Mode**: Clean, bright interface optimized for daylight use
- **Dark Mode**: Eye-friendly dark theme with proper contrast ratios
- **Instant Switching**: Smooth animations during theme transitions
- **System Integration**: Respects system theme preferences

### 🚫 Error States
- **Network Errors**: Beautiful error screens with retry functionality
- **Empty States**: Informative messages for no search results
- **Loading States**: Modern progress indicators with contextual messages

## 🏗️ Project Structure

```
app/src/main/java/com/example/cryptocurrencyapp/
├── common/                          # Shared utilities and constants
│   ├── Constants.kt                 # API endpoints and app constants
│   └── Resource.kt                  # Sealed class for state management
├── data/                           # Data layer implementation
│   ├── remote/                     # Network layer
│   │   ├── dto/                    # Data transfer objects
│   │   └── CoinPaprikaApi.kt      # Retrofit service interface
│   └── repository/                 # Repository implementations
│       └── CoinRepositoryImpl.kt   # Data repository
├── domain/                         # Business logic layer
│   ├── model/                      # Domain models
│   │   ├��─ Coin.kt                # Coin entity
│   │   ├── CoinDetail.kt          # Detailed coin information
│   │   └── TeamMember.kt          # Team member entity
│   ├── repository/                 # Repository interfaces
│   │   └── CoinRepository.kt      # Abstract repository
│   └── use_case/                  # Business use cases
│       ├── get_coins/             # Get coins list use case
│       └── get_coin/              # Get coin details use case
├── presentation/                   # UI layer
│   ├── ui/theme/                  # Design system
│   │   ├── Color.kt               # Color palette
│   │   ├── Theme.kt               # Theme configuration
│   │   ├── ThemeManager.kt        # Theme state management
│   │   └── Type.kt                # Typography system
│   ├── components/                # Reusable UI components
│   │   ├── ThemeToggle.kt         # Theme switching component
│   │   └── NoInternetScreen.kt    # Error state component
│   ├── coin_list/                 # Coins list feature
│   │   ├── CoinListScreen.kt      # Main screen composable
│   │   ├── CoinListState.kt       # Screen state data class
│   │   ├── CoinListViewModel.kt   # Screen view model
│   │   └── components/            # Screen-specific components
│   ├── coin_details/              # Coin details feature
│   │   ├── CoinDetailScreen.kt    # Details screen composable
│   │   ├── CoinDetailState.kt     # Details state data class
│   │   ├── CoinDetailsViewModel.kt# Details view model
│   │   └── components/            # Detail screen components
│   └── utils/                     # UI utilities
│       └── HtmlUtils.kt           # HTML processing utilities
└── CoinApplication.kt             # Application class with Hilt setup
```

## 🎯 Implemented Features

### ✅ Core Functionality
- [x] **Cryptocurrency List**: Display of top cryptocurrencies with real-time data
- [x] **Detailed Information**: Comprehensive coin details with market data
- [x] **Real-time Search**: Instant filtering through cryptocurrency database
- [x] **Network Error Handling**: Robust error management with user-friendly messages
- [x] **Loading States**: Contextual loading indicators throughout the app

### ✅ UI/UX Excellence
- [x] **Flat Design System**: Modern, shadow-free interface design
- [x] **Dynamic Theming**: Seamless light/dark mode switching
- [x] **Modern Icons**: Beautiful Feather icons integration
- [x] **Smooth Animations**: Fluid transitions and micro-interactions
- [x] **Responsive Layout**: Adaptive design for various screen sizes
- [x] **Accessibility**: Proper content descriptions and navigation

### ✅ Technical Implementation
- [x] **Clean Architecture**: Proper separation of concerns
- [x] **MVVM Pattern**: Reactive programming with LiveData/StateFlow
- [x] **Dependency Injection**: Hilt for maintainable code
- [x] **Coroutines Integration**: Asynchronous operations
- [x] **Error Handling**: Comprehensive exception management
- [x] **HTML Processing**: Clean content rendering without markup

## 🔧 Technical Improvements

### 🎨 UI Enhancements
- **Shadow-free Design**: Complete removal of elevations for modern flat aesthetics
- **Modern Color Palette**: Carefully curated colors following Material Design 3
- **Contemporary Icons**: Integration of Feather icons for consistent visual language
- **Enhanced Typography**: Improved readability with proper font weights and sizing

### ⚡ Performance Optimizations
- **HTML Content Processing**: Efficient cleaning of cryptocurrency descriptions
- **State Management**: Optimized with StateFlow for better performance
- **Lazy Loading**: On-demand data loading for improved responsiveness
- **Memory Management**: Proper lifecycle handling and resource cleanup

### 🛡️ Error Handling & UX
- **Network Error Recovery**: Graceful handling of connectivity issues
- **Empty State Management**: Informative screens for edge cases
- **Loading State Indicators**: Clear feedback during data operations
- **User-Centric Messaging**: Helpful error messages with action suggestions

## 🎓 Learning Outcomes

### 📚 Skills Developed
- **Advanced Android Development**: Modern app development with latest Android APIs
- **Jetpack Compose Mastery**: Declarative UI programming proficiency
- **Architecture Implementation**: Clean Architecture and MVVM pattern expertise
- **Dependency Injection**: Hilt framework integration and best practices
- **API Integration**: RESTful API consumption and data handling
- **Modern UI/UX Design**: Contemporary design principles and user experience

### 🔄 Future Enhancements
- [ ] **Favorites System**: Save and manage favorite cryptocurrencies
- [ ] **Price Alerts**: Push notifications for price thresholds
- [ ] **Portfolio Tracking**: Investment portfolio management
- [ ] **Charts Integration**: Interactive price charts and technical analysis
- [ ] **Offline Support**: Local caching for offline viewing
- [ ] **Widget Support**: Home screen widgets for quick price checking

## 🧪 Testing

### Unit Tests
- Repository layer testing
- Use case logic validation
- ViewModel state management testing

### UI Tests
- Compose UI testing
- Navigation flow testing
- Theme switching validation

```bash
# Run tests
./gradlew test
./gradlew connectedAndroidTest
```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Developer Information

**Student Name**: Mohamed Elsayed  
**ITI Track**: Android Development  

## 📞 Contact Information

- **LinkedIn**: [Your LinkedIn Profile]
- **GitHub**: [Your GitHub Profile]
- **Email**: [your.email@example.com]
- **Portfolio**: [Your Portfolio Website]

## 🙏 Acknowledgments

Special thanks to:

- **Information Technology Institute (ITI)** for providing excellent training and resources
- **ITI Instructors and Mentors** for guidance and technical support
- **CoinPaprika API** for providing reliable cryptocurrency data
- **Android Development Community** for extensive documentation and resources
- **Google Material Design Team** for design system guidelines
- **JetBrains** for Kotlin programming language
- **Open Source Contributors** for the amazing libraries used in this project

## 📊 Project Statistics

- **Lines of Code**: ~2,500+ lines of Kotlin
- **Development Time**: 1 weeks
- **Screens**: 2 main screens + components
- **API Endpoints**: 2 (List & Details)
- **Dependencies**: 15+ modern Android libraries
- **Minimum Android Version**: API 24 (Android 7.0)

---

<div align="center">
  <h3>🎯 Developed with ❤️ for ITI Final Project</h3>
  <p><strong>CryptoCurrency Tracker - Showcasing Modern Android Development</strong></p>
  <p><em>Demonstrating Clean Architecture, Jetpack Compose, and Material Design 3</em></p>
</div>

---

### 🏆 Project Highlights

This project demonstrates proficiency in:
- ✅ **Modern Android Development** with latest tools and frameworks
- ✅ **Clean Code Principles** with proper architecture implementation
- ✅ **UI/UX Design** following Material Design guidelines
- ✅ **State Management** with reactive programming patterns
- ✅ **Testing Practices** with unit and integration tests
- ✅ **Performance Optimization** with efficient resource management
