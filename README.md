# DetoxFocus

**Aplicación Android para bloquear apps distractoras y gestionar hábitos digitales**

## 📱 Descripción

DetoxFocus es una app diseñada para ayudarte a recuperar el control de tu tiempo digital mediante:

- **Bloqueo de apps**: Selecciona apps distractoras y bloquéalas durante períodos específicos
- **Modos Detox**: Configura horarios automáticos de bloqueo
- **Seguimiento de hábitos**: Crea tareas y monitorea tu progreso diario
- **Dashboard de analíticas**: Visualiza tu consumo de tiempo y progreso en tiempo real

## 🏗️ Arquitectura

- **UI**: Jetpack Compose + Material3
- **Estado**: MVVM + Hilt (inyección de dependencias)
- **Datos**: Room (base de datos local) + Flow (reactividad)
- **Background**: WorkManager (para timers en background)
- **Accesibilidad**: AccessibilityService (para detectar cambios de app)

## 🛠️ Stack Técnico

- Android SDK 26+ (minSdk) / 35 (targetSdk)
- Kotlin 2.0.20
- Jetpack Compose 2024.09
- Hilt 2.51.1
- Room 2.6.1
- WorkManager 2.9.1

## 📋 Estructura del Proyecto

```
app/src/main/java/com/tonidev/detoxfocus/
├── presentation/
│   ├── theme/              # Design system (colores, tipografía, tema)
│   └── screens/
│       └── dashboard/      # Pantalla principal de analíticas
├── data/
│   └── local/
│       ├── entity/         # Entidades Room
│       ├── dao/            # DAOs de acceso a datos
│       └── database/       # Instancia de BD
└── MainActivity.kt         # Punto de entrada
```

## 🚀 Próximos Pasos

- [ ] Implementar pantalla de bloqueo de apps
- [ ] Integrar AccessibilityService
- [ ] Crear pantalla de configuración de Modos Detox
- [ ] Conectar datos reales a dashboard (gráfico de 24 horas)
- [ ] Implementar notificaciones
- [ ] Tests unitarios e integración

## 📝 Notas de Desarrollo

- El tema siempre es oscuro (PRD: "negro absoluto profundo")
- Palette: Fondo `#0B0B0F`, Acentos verde esmeralda `#2ECC71` y rojo `#FF3B30`
- Dashboard pendiente: gráfico de barras con datos horarios reales desde Room